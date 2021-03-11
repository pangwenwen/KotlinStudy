package com.example.kotlint.foundation

/**
 * 变量的规则：
 * 变量需要手动初始化，如果不初始化的话会报错；
 * 变量默认非空，所以初始化赋值 null 的话报错，之后再次赋值为 null 也会报错；
 * 变量用 ? 设置为可空的时候，使用的时候因为「可能为空」又报错。
 * kotlin 有类型推断功能
 *
 * kotlin 里变量默认是public  ,internal 仅module中可见
 * protected
 *    Java 中 protected 表示包内可见 + 子类可见。
 *    Kotlin 中 protected 表示 private + 子类可见。
 * private
 *    Java 中的 private 表示类中可见，作为内部类时对外部类「可见」。
 *    Kotlin 中的 private 表示类中或所在文件内可见，作为内部类时对外部类「不可见」。
 *
 * 函数参数同样有可空，并且传的过程这需要判断是否为空
 *
 * 在 Kotlin 中，所有东西都是对象，Kotlin 中使用的基本类型有：数字、字符、布尔值、数组与字符串。
 *
 *
 * Kotlin 里，Int 是否装箱根据场合来定：
 *   var a: Int = 1 // unbox
 *   var b: Int? = 2 // box
 *   var list: List<Int> = listOf(1, 2) // box
 *
 *  Kotlin 里的类默认是 final 的，可用于继承是使用open修饰， open 没有父类到子类的遗传性
 *
 *  使用 is 关键字进行「类型判断」
 *    if (activity is NewActivity) {
 *        👇的强转由于类型推断被省略了
 *         activity.action()
 *     }
 *     或
 *     (activity as? NewActivity)?.action()
 *
 *
 */




//kotlin是空安全的
// ? :表示变量可以为空，为可空类型
var name:String? = null

// 顶级函数和标量可以直接在其他类中使用
var disctib = "描述"
fun topF(){
    println("...")
}

// 常量
// Kotlin 的常量必须声明在对象（包括伴生对象）或者「top-level 顶层」中，因为常量是静态的。
//Kotlin 新增了修饰常量的 const 关键字
// Kotlin 中只有基本类型和 String 类型可以声明成常量
const val CONSTT = 1


fun main() {
    println(name?.length) // 根据空条件调用
//    print(name!!.length)  // 强制调用

    // 定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
    val a:Int = 0

    println(maxS(3,9))

    var student = Student()
    println(student.name)
    student.name = "lala"
    println(student.name)

    println(student.age)

    // =========================================
    // 变量
    var number: Int = 1 // 👈还有 Double Float Long Short Byte 都类似  Int 是否装箱根据场合来定：

    /**
     * var a: Int = 1 // unbox
     * var b: Int? = 2 // box
     * var list: List<Int> = listOf(1, 2) // box
     */

    var c: Char = 'c'
    var b: Boolean = true
    var array: IntArray = intArrayOf(1, 2) // 👈类似的还有 FloatArray DoubleArray CharArray 等，intArrayOf 是 Kotlin 的 built-in 函数
    var str: String = "string"
    println("Hi ${str.length}")

    sayHi()
    sayHi("haha")

    sayhi(duo = "duoyu")


    val name = "world"
    val myName = "kotlin"
//    👇
    val text = """
      Hi $name!
    My name is $myName.\n
"""
    println(text)

    // trimMargin() 去除掉默认 | 前的
    val text2 = """
     | Hi $name!
    |My name is $myName.\n
""".trimMargin()
    println(text2)


}

// 函数简化
fun maxS(a:Int,b:Int) = if (a>b) a else b

// 参数默认值：实现了java 中的方法重载
fun sayHi(va:String = "hi")= println(va)

// 命名参数
fun sayhi(va:String="hi",duo:String) = println("$va $duo")

// 嵌套函数 -- 本地函数
fun login(user: String, password: String, illegalStr: String) {
    // 嵌套函数中可以访问在它外部的所有变量或常量
    fun validate(value: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(illegalStr)
        }
    }
    validate(user)
    validate(password)
}


class Student{
    // lateinit 不能修饰基本数据类型
    lateinit var sex:String

    // get set
    var name = "huahua"
        get() {
            return field+"!!!"
        }
        set(value) {
            field = value
        }

    // val 只能有get
    val age = 10
        get() {
            return field+2
        }

    //== ：可以对基本数据类型以及 String 等类型进行内容比较，相当于 Java 中的 equals
    //=== ：对引用的内存地址进行比较，相当于 Java 中的 ==
}



