package com.example.kotlint.foundation

fun main() {
    val  str:String? = null
    if (str?.length?: 0 < 4){
        println("不合法")
    }
}