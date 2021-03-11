package com.example.kotlint.staticT

class MyStaticT2 {
    // 使用伴生对象创造静态方法
    companion object{
        fun getMac():String{
            return "fff"
        }

        // 加上注解后可以直接调用
        @JvmStatic
        fun getWifi():String{
            return "wifi"
        }
    }
}