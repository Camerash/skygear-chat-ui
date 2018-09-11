package com.camerash.sample

import android.content.Context
import android.widget.Toast
import io.skygear.skygear.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

class ChatHelper {

    interface SkygearLoginCallback {
        fun onLoginSuccess()
        fun onLoginFailed()
    }

    companion object {
        const val USER_TABLE_KEY = "user"
        const val USERNAME_KEY = "username"
        const val ITSC_KEY = "itsc"

        fun getNameById(context: Context, id: String, callback: (String) -> Unit) {
            val container = Container.defaultContainer(context)
            val query = Query(USER_TABLE_KEY)
                    .equalTo("_id", id)

            container.publicDatabase.query(query, object: RecordQueryResponseHandler() {
                override fun onQuerySuccess(records: Array<out Record>) {
                    super.onQuerySuccess(records)

                    if(records.isEmpty()) return

                    val username = records[0].get(USERNAME_KEY) as String?
                    val itsc = records[0].get(ITSC_KEY) as String?

                    callback(username ?: itsc ?: "")
                }

                override fun onQueryError(error: Error) {
                    callback("")
                }
            })
        }

        fun getNamesByIds(context: Context, id: Set<String>, callback: (Map<String, String>) -> Unit) {
            val container = Container.defaultContainer(context)
            val query = Query(USER_TABLE_KEY)
                    .contains("_id", id.toList())

            container.publicDatabase.query(query, object: RecordQueryResponseHandler() {
                override fun onQuerySuccess(records: Array<out Record>) {
                    super.onQuerySuccess(records)

                    if(records.isEmpty()) return

                    val nameList = mutableMapOf<String, String>()

                    records.forEach {
                        val username = it.get(USERNAME_KEY) as String?
                        val itsc = it.get(ITSC_KEY) as String?
                        nameList[it.id] = username ?: itsc ?: ""
                    }

                    callback(nameList)
                }

                override fun onQueryError(error: Error) {
                    callback(mapOf())
                }
            })
        }

        fun skygearLogin(context: Context, username: String, callback: SkygearLoginCallback) {
            val config = Configuration.Builder()
                    .endPoint(context.resources.getString(R.string.skygear_end_point))
                    .apiKey(context.resources.getString(R.string.skygear_API_key))
                    .build()

            val skygear = Container.defaultContainer(context)
            skygear.configure(config)

            var md: MessageDigest? = null
            try {
                md = MessageDigest.getInstance("MD5")
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            val md5 = md!!.digest(username.toByteArray())
            val sb = StringBuffer()
            for (b in md5) {
                sb.append(String.format("%02x", b and (0xff).toByte()))
            }
            val skygearPassword = sb.toString() //MD5 of username

            skygear.auth.loginWithUsername(username, skygearPassword, object : AuthResponseHandler() {

                override fun onAuthSuccess(user: Record) {
                    callback.onLoginSuccess()
                }

                override fun onAuthFail(error: Error) {
                    if (error.code == Error.Code.RESOURCE_NOT_FOUND) {
                        skygear.auth.signupWithUsername(username, skygearPassword, object : AuthResponseHandler() {
                            override fun onAuthSuccess(user: Record) {
                                callback.onLoginSuccess()
                            }

                            override fun onAuthFail(error: Error) {
                                callback.onLoginFailed()
                            }
                        })
                    } else {
                        callback.onLoginFailed()
                    }
                }
            })
        }
    }
}