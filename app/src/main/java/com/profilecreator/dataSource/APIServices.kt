package com.profilecreator.dataSource

import com.google.gson.Gson
import com.profilecreator.model.ProfileDetails
import com.profilecreator.model.User
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface APIServices {

    @POST("/login")
    fun authenticateUser(@Query("email") email: String, @Query("password") password: String): Call<User>

    //POST method is not used because we are updating already stored json data
    @PUT("b/5d28930e6e599f247d56d0f7")  //secret key of jsonbin.io --> 5d28930e6e599f247d56d0f7
    @Headers(
        "Content-Type:application/json",
        "secret-key:\$2a\$10$" + "wHjjA1hNO5ey/eIjZgvehuU6ZqMP4RkAqbmf3x4tlswcd8pBdHmCm"
    )
    fun saveProfile(@Body gson: JSONObject): Call<ProfileDetails>
}