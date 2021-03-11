package com.example.kotlint.foundation

/**
 *  在 Kotlin 里面，所有的变量默认都是不允许为空的，如果你给它赋值 null，就会报错
 *  使用 ? 声明可空属性
 */

class NullSafeAndlaterT {
    var name: String? = null
    var school = "haha"
        get(){
            return ""
        }
        set(value){
            field = value+"hha"
        }
    var age:Int? = 10

    //告诉编译器我没法第一时间就初始化，但我肯定会在使用它之前完成初始化的
    lateinit var play:String

    fun setNull(){
        name = null
        name = null
    }

    fun opP(){
        school?.get(0) //如果非空则调用，否则不执行 ，是线程安全的
        school!![0] // 一定非空
    }

    fun setPlay(){
        play = "ping pang"
    }



}