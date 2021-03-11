package com.example.kotlint.foundation

import kotlinx.coroutines.*

// https://kaixue.io/kotlin-coroutines-1/
// https://kaixue.io/kotlin-coroutines-2/
// https://kaixue.io/kotlin-coroutines-3/

fun main() {

    // ================================
    // 通过下列方法创建协程
    // 1. 线程阻塞的，用于单元测试
    runBlocking {

    }
    // 2.非线程阻塞，但是Android 开发中同样不推荐这种用法，因为它的生命周期会和 app 一致，且不能取消
    GlobalScope.launch {
        // 从当前线程挂起。换句话说，就是这个协程从正在执行它的线程上脱离
        ss() // ????为神马在不线程啊
        println("haha "+Thread.currentThread())
    }
    // 3.  方法三是比较推荐的使用方法，我们可以通过 context 参数去管理和控制协程的生命周期
    // （这里的 context 和 Android 里的不是一个东西，是一个更通用的概念，会有一个 Android 平台的封装来配合使用）
//    val coroutineScope = CoroutineScope(context)
//    coroutineScope.launch {
//
//    }

    //=========================使用
//    GlobalScope.launch(Dispatchers.Main) {
        //            👇  async 函数之后再讲
//        val avatar = async { api.getAvatar(user) }    // 获取用户头像
//        val logo = async { api.getCompanyLogo(user) } // 获取用户所在公司的 logo
//        val merged = suspendingMerge(avatar, logo)    // 合并结果
//        //                  👆
//        show(merged) // 更新 UI
//    }

    //// kotlin 中使用thread
    Thread{
        Thread.sleep(1)
        println(2)
    }.start()
    println(1)
    Thread.sleep(10000)

    // =================================================
//    coroutineScope.launch(Dispatchers.Main) {
//        //                      👇  async 函数启动新的协程
//        val avatar: Deferred = async { api.getAvatar(user) }    // 获取用户头像
//        val logo: Deferred = async { api.getCompanyLogo(user) } // 获取用户所在公司的 logo
//        //            👇          👇 获取返回值
//        show(avatar.await(), logo.await())                     // 更新 UI
//    }
    // public suspend fun await(): T
}

// 挂起函数 必须在协程中调用
// launch ，async 或者其他函数创建的协程，在执行到某一个 suspend 函数的时候，这个协程会被「suspend」，也就是被挂起。
// 挂起的是协程
// 挂起函数在执行完成之后，协程会重新切回它原先的线程。
// suspend :它其实是一个提醒,函数的创建者对函数的使用者的提醒：我是一个耗时函数，我被我的创建者用挂起的方式放在后台运行，所以请在协程里调用我。
// 真正挂起协程这件事，是 Kotlin 的协程框架帮我们做的
suspend fun ss() = withContext(Dispatchers.IO){
   println("heihei"+Thread.currentThread())
}
