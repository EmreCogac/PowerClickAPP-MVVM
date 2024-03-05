package com.powerclick.app.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.powerclick.app.model.IpDataClass
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HTTPRepository(private val application: Application) {

    fun leftRequest(ipDataClass: IpDataClass) {
        val url = "http://${ipDataClass.ip}:8080/data/left"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("MainActivity", "Hata oluştu: ${e.message}")

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    Log.d("MainActivity", "Başarılı: $body")

                } else {
                    Log.e("MainActivity", "Hata oluştu: ${response.code}")
                    Toast.makeText(application, "deneme", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun rightRequest(ipDataClass: IpDataClass) {
        val url = "http://${ipDataClass.ip}:8080/data/right"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("MainActivity", "Hata oluştu: ${e.message}")

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    Log.d("MainActivity", "Başarılı: $body")

                } else {
                    Log.e("MainActivity", "Hata oluştu: ${response.code}")
                    Toast.makeText(application, "deneme", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
    fun testRequest(ipDataClass: IpDataClass) {
        val url = "http://${ipDataClass.ip}:8080/test"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("MainActivity", "Hata oluştu: ${e.message}")

            }
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    Log.d("MainActivity", "Başarılı: $body")

                } else {
                    Log.e("MainActivity", "Hata oluştu: ${response.code}")
                    Toast.makeText(application, "deneme", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}