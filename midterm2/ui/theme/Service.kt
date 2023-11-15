package com.example.midterm2.ui.theme

dependencies {
    implementation "androidx.activity:activity-compose:1.3.0-alpha02"
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
    implementation "io.reactivex.rxjava3:rxjava:3.0.13"
    implementation "io.reactivex.rxjava3:rxandroid:3.0.0"
    implementation "io.reactivex.rxjava3:rxkotlin:3.0.1"
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"

import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("/users")
    suspend fun getUsers(): List<User1>
}