package com.example.ontapkt

sealed class Screen (val route:String){
    object Register :Screen(route = "register_screen")
    object Login :Screen(route = "login_screen")
}