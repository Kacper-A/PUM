package com.example.lista6.data

import com.google.gson.annotations.SerializedName

class user(


    var username: String,
    var email: String,
    var first_name: String,
    var second_name: String,
    var gender: String,
    var date_of_birth: String,
    var avatar: String,
    var address: address

)

class address(
    var city: String
)