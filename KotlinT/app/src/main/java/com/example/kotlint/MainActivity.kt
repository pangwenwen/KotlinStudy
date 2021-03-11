package com.example.kotlint

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.kotlint.foundation.disctib
import com.example.kotlint.foundation.topF
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.coroutineContext

//函数如果不加可见性修饰符的话，默认的可见范围和变量一样也是 public 的

class MainActivity : AppCompatActivity() {
    // 伴生对象，
    companion object{
        private const val TAG = "MainActivity"
    }
    var imgStr = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fa2.att.hudong.com%2F27%2F81%2F01200000194677136358818023076.jpg&refer=http%3A%2F%2Fa2.att.hudong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612184849&t=e571369ec7a7256d5983390b52d8bc6c"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn:Button = findViewById(R.id.button)
        var imageView:ImageView = findViewById(R.id.imageView)
        btn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                Log.i(TAG, "onCreate: thread = "+Thread.currentThread())
                var bitmap = getBitmap()
                imageView.setImageBitmap(bitmap)
            }
        }


        // 匿名内部类
//        val onclickListener = object: View.OnClickListener {
//            override fun onClick(v: View?) {
//
//            }
//        }
//        // 转换为lamad表达式
//        val onclickListener2 = View.OnClickListener { }
//
//        var view:View = View(this)
//
//        view.setOnClickListener({ v: View ->
//            //
//        })
//        // 如果是最后一个参数可以把括号放到外边
//        view.setOnClickListener(){ v: View ->
//            //
//        }
//        // 还可以把括号省略
//        view.setOnClickListener{ v: View ->
//            //
//        }
//        // 如果lambda 是单参数，还可以把参数去掉
//        view.setOnClickListener{
//            //
//        }
//
//        print(disctib)
//        topF()

        // 1.
        btn.setOnClickListener(fun(v:View ):Unit{
            //....
        })
        // 2.
        btn.setOnClickListener({v:View ->
            //....
        })
        // 3.如果是最后一个参数可以写在括号的外边
        btn.setOnClickListener(){v:View ->
            //....
        }
        //4.如果是唯一的参数可以把括号去掉
        btn.setOnClickListener{v:View ->
            //....
        }
        //5.如果Lamad 是单参数可以把参数去掉，其参数靠上下文推断得出
        btn.setOnClickListener{
            // 默认参数用it表示
            //....
        }


    }

    suspend fun getBitmap():Bitmap = withContext(Dispatchers.IO){
        Log.i(TAG, "getBitmap: thread = "+Thread.currentThread())
        var url = URL(imgStr)
        val connection = url.openConnection() as HttpURLConnection
        var inputS = connection.inputStream
        return@withContext BitmapFactory.decodeStream(inputS)
    }

    // 匿名类的创建
    var listener = object :View.OnClickListener{
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }
    // 直接协程lamad
    var listener2 = View.OnClickListener { TODO("Not yet implemented") }


}