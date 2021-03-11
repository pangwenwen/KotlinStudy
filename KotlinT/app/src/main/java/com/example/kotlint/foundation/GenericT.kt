package com.example.kotlint.foundation

import android.widget.Button
import android.widget.TextView

// java 的泛型具有不可变性,在编译时会进行类型擦除
//List<Button> buttons = new ArrayList<Button>();
//List<TextView> textViews = buttons;  报错,

// 解决上面的问题  ? extends 上界通配符，使java泛型具有协変性
// extends :它的范围不仅是所有直接和间接子类，还包括上界定义的父类本身
//          它还有 implements 的意思，即这里的上界也可以是 interface
//List<Button> buttons = new ArrayList<Button>();
//List<? extends TextView> textViews = buttons;

//List<? extends TextView> textViews = new ArrayList<Button>();
//TextView textView = textViews.get(0); // 👈 get 可以
//textViews.add(textView);  报错


//？ super 下届通配符
//  super 我们在类的方法里面经常用到，这里的范围不仅包括 Button 的直接和间接父类，也包括下界 Button 本身
//  super 同样支持 interface。
//List<? super Button> buttons = new ArrayList<TextView>();

//List<? super Button> buttons = new ArrayList<TextView>();
//Object object = buttons.get(0); // 👈 get 出来的是 Object 类型
//Button button = ...
//buttons.add(button); // 👈 add 操作是可以的


// ============================================================================================
//使用关键字 out 来支持协变，等同于 Java 中的上界通配符 ? extends。
//使用关键字 in 来支持逆变，等同于 Java 中的下界通配符 ? super。

//class Producer<T> {
//    fun produce(): T {
//        //...
//        return Any();
//    }
//}
//
//val producer: Producer<out TextView> = Producer<Button>()
//val textView: TextView = producer.produce() // 👈 相当于 'List' 的 `get`

//class Consumer<T> {
//    fun consume(t: T) {
//        ...
//    }
//}
//
//val consumer: Consumer<in Button> = Consumer<TextView>()
//consumer.consume(Button(context)) // 👈 相当于 'List' 的 'add'

// where 多个边界
//class Monster<T> where T : Animal, T : Food

// reified 关键字用于提供判断是什么类型
//inline fun <reified T> printIfTypeMatch(item: Any) {
//    if (item is T) { // 👈 这里就不会在提示错误了
//        println(item)
//    }
//}


// 总结
//1. Java 里的数组是支持协变的，而 Kotlin 中的数组 Array 不支持协变。
//这是因为在 Kotlin 中数组是用 Array 类来表示的，这个 Array 类使用泛型就和集合类一样，所以不支持协变。
//
//2. Java 中的 List 接口不支持协变，而 Kotlin 中的 List 接口支持协变。
//Java 中的 List 不支持协变，原因在上文已经讲过了，需要使用泛型通配符来解决。
//在 Kotlin 中，实际上 MutableList 接口才相当于 Java 的 List。Kotlin 中的 List 接口实现了只读操作，没有写操作，
// 所以不会有类型安全上的问题，自然可以支持协变。


fun <T> fill(array: Array<in T>, value:T){
    array[0] = value
}

fun <T> copy(from:Array<out T>,to:Array<in T>){
    assert(to.size == from.size)
    for (i in from.indices){
       to[i] = from[i]
    }
}