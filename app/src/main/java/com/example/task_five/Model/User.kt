package com.example.task_five.Model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    //Percelized User data class
    var username: String?,
    var email: String?,
    var phone: String?,
    var sex: String?,
    var password: String?,
    var confirmPassword: String?) : Parcelable{

}