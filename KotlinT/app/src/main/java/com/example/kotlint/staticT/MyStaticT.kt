package com.example.kotlint.staticT

// object 不是类，像 class 一样在 Kotlin 中属于关键字：
//   创建一个类，并且创建一个这个类的对象。这个就是 object 的意思：对象。
// 和java 的单例相同  不需要额外维护一个实例变量 sInstance
// 静态方法

// const val CONST_SECOND_NUMBER = 2  const: Kotlin 中只有基本类型和 String 类型可以声明成常量
object MyStaticT {
    var name:String? = null
    private val age = 10
  fun getMac():String{
      return "mac"
  }
}