package com.example.kotlint.foundation

// 「参数或者返回值为函数类型的函数」，在 Kotlin 中就被称为「高阶函数」

// 在kotlin 中，匿名函数的lambda 表达式都是对象； kotlin中的lamad表达式是实实在在的函数类型的对象
fun funPa(param: (Int)->Unit){
   param(2)
}

fun a(a:Int){
    println(a+3)
}

fun c(param:(Int)->String){
    param(3)
}

//// 匿名函数  不可以了
//c(fun(param: Int): String {
//    return param.toString()
//})

val d = fun(param: Int): String {
    return param.toString()
}

fun main() {
    // :: 将函数转换为对象
//    funPa(::a)
//
//    // 或者
//    var  b = ::a
//    funPa(b)
//
//    a(2)
//    (::a)(2)


    aa(fun (param: Int): String {
        return param.toString()
    });
    val d = fun (param: Int): String {
        return param.toString()
    }

    // 另外 Lambda 的返回值不是用 return 来返回，而是直接取最后一行代码的值：
    // 如果使用了return 则直接跳出外层循环了
    val b: (Int) -> String = {
        it.toString() // it 可以被推断出是 Int 类型
    }
}

// ============== 演变 ================
fun aa(param:(Int)->String){
    param(10)
}


