package com.example.kotlint.foundation

// 如果类中有主构造器，那么其他的次构造器都需要通过 this 关键字调用主构造器，
// 可以直接调用或者通过别的次构造器间接调用。如果不调用 IDE 就会报错：

// 在使用次构造器创建对象时，init 代码块是先于次构造器执行的

class User{
    var age:Int
    var name:String

    // 初始化代码块   在实例化时执行，并且执行顺序都在构造器之前。
    init {
        println(" usser init...")
    }


    constructor(age:Int,name:String){
        println("user constructor...")
        this.age = age
        this.name = name
    }

    fun opName(name:String){
        // 错误，kotlin中参数默认是val
        //name = name+"haha"
    }
}

// 主构造器
class School(name:String){
    var name:String = name
}

class School2(name:String){
    var name:String
    // init 代码块是紧跟在主构造器之后执行的，这是因为主构造器本身没有代码体，init 代码块就充当了主构造器代码体的功能
    init {
        this.name = name
    }

}

// 主构造器是声明属性
class school2(var name:String){
    // 次构造器必须实现主构造器
    constructor():this("yyaa"){
        name = "haha"
    }
}

//创建一个类，并且创建一个这个类的对象  ==> 单例类  饿汉式
object Sample{
    val value = "sample value"
}

//在主构造器上使用「可见性修饰符」或者「注解」 时不可以省略
class User2 private constructor(name: String) {
//           👆 主构造器被修饰为私有的，外部就无法调用该构造器
}


//===============================================================================
class User3(var name: String) {
}
// 等价于：
class User4(name: String) {
    var name: String = name
}
//===============================================================================

interface interfaceT{
    fun interfaceT()
}
open class A{
    open fun funA(){

    }
}

class AA:A(),interfaceT{
    override fun interfaceT() {
        println("AA")
    }

    override fun funA() {
        println("fff")
    }
}

fun main() {
    var user:User = User(10,"huahua")
    println(Sample.value)

    val aa = AA()
    aa.interfaceT()

    val sch = school2()
    print(sch.name)

}