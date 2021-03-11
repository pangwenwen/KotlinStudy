package com.example.kotlint.interactive

class Ko {
    companion object{
        @JvmStatic
        var a = "haha"
            private set // 设置set 为不可调用

        @JvmStatic
        @get:JvmName("kb")
        var b = "lal"
    }

}