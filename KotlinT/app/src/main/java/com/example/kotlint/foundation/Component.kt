package com.example.kotlint.foundation

// 解构

//Tool --> kotlin --> show kotlin byteCode -- DeCompile

// 1. 使用dataclass
data class Point (var x:Int,var y:Int){

}
// 2. 自定义
class Triangle(var pointOne:Point,var pointTwo:Point,var pointThree:Point){
    operator fun component1(): Point {
        return this.pointOne
    }

    operator fun component2(): Point {
        return this.pointTwo
    }

    operator fun component3(): Point {
        return this.pointThree
    }

}

fun main() {
    val point = Point(1,2)
    val (x,y) = point

    val pointO = Point(1,2)
    val pointTwo = Point(5,2)
    val pointThree = Point(5,6)

    val triangle = Triangle(pointO,pointTwo,pointThree)
    val (one,two,three) = triangle
}