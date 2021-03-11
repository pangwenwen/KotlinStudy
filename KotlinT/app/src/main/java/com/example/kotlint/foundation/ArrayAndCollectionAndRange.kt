package com.example.kotlint.foundation

fun main() {
    // 数组:泛型化，Kotlin 可以给数组增加很多有用的工具函数：
    // 数组不支持协変：子类数组对象不能赋值给父类的数组变量
    val strs:Array<Int> = arrayOf(1,2,3,4,5,6)
    // 遍历
    strs.forEach {
        print(it)
    }
    // 过滤
    val strf = strs.filter {
        it%3==0
    }
    println(strf.size)

    // 为每个元素执行特定的操作
    val stfm = strs.map {
        it+2
    }
    stfm.forEach {
        println(it )
    }

    //flatMap：遍历每个元素，并为每个元素创建新的集合，最后合并到一个集合中
    val array1 = arrayOf("2","3","a")
    val hh = array1.flatMap { i ->
        listOf("${i + 1}", "a") // 👈 生成新集合
    }
    hh.forEach {
        println(it)
    }

   // list 支持协変
    val list1 = listOf(1,2,3,4,5,6)
    var list2= list1
   // set
    val set1 = setOf(1,2,3,1)
    println(set1.size)


    // map
    val mapf = mutableMapOf("haha" to 3)
    println(mapf["haha"])
    mapf["haha"] = 6

    // 条件语句
    //省略了 case 和 break，前者比较好理解，后者的意思是 Kotlin 自动为每个分支加上了 break 的功能，防止我们像 Java 那样写错
    //Java 中的默认分支使用的是 default 关键字，Kotlin 中使用的是 else
    val x = 3;
    when (x) {
            1 -> { println("1") }
            2 -> { println("2") }
            else -> { println("else") }
    }

    // ?: 操作符
    val str: String? = "Hello"
    val length: Int = str?.length ?: -1


    //================================================
    println("==========================================")
    val rn = 1..10 // [1,10] 必须从小到大
    for (i in rn){
        print(i)
    }
    println()

    for (i in rn step 2){
        print(i)
    }
    println()
    // 递减区间
    for (i in 4 downTo 1 step 2){
        print(i)
    }

    //=====================================
    println("========================================== 序列 Sequence 又被称为「惰性集合操作」")
    val sequence = sequenceOf(1, 2, 3, 4)
    val result: Sequence<Int> = sequence
            .map { i ->
                println("Map $i")
                i * 2
            }
            .filter { i ->
                println("Filter $i")
                i % 3  == 0
            }
//    👇
    println(result.first())
    /**
     * 惰性的概念首先就是说在「👇」标注之前的代码运行时不会立即执行，它只是定义了一个执行流程，只有 result 被使用到的时候才会执行

    当「👇」的 println 执行时数据处理流程是这样的：

    取出元素 1 -> map 为 2 -> filter 判断 2 是否能被 3 整除
    取出元素 2 -> map 为 4 -> filter 判断 4 是否能被 3 整除
    ...
    惰性指当出现满足条件的第一个元素的时候，Sequence 就不会执行后面的元素遍历了，即跳过了 4 的遍历

     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>优点
    Sequence 这种类似懒加载的实现有下面这些优点：

    一旦满足遍历退出的条件，就可以省略后续不必要的遍历过程。
    像 List 这种实现 Iterable 接口的集合类，每调用一次函数就会生成一个新的 Iterable，下一个函数再基于新的 Iterable 执行，每次函数调用产生的临时 Iterable 会导致额外的内存消耗，而 Sequence 在整个流程中只有一个。
    因此，Sequence 这种数据类型可以在数据量比较大或者数据量未知的时候，作为流式处理的解决方案。
     */

}
