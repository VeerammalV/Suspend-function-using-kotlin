package com.example.suspendfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)

//        lifecycleScope.launch {
//            delay(3000)
//            textView1.text = firstName()
//            textView2.text = secondName()
//        }
//    }
//}
//
//    suspend fun firstName(): String {
//        delay(3000)
//        return "Hello World"
//    }
//
//    suspend fun secondName(): String{
//        delay(6000)
//        return "Hi"
//    }



// runCatching

        fun main() {
            runCatching {
                val randomNumber = Random.nextInt(0,2)
                if (randomNumber == 0) {
                    throw RuntimeException("Random number is zero!")
                } else {
                    randomNumber
                }
            }.onSuccess { value ->
                println("Success.. Result: $value")
            }.onFailure { exception ->
                println("Failure... ${exception.message}")
            }
        }
        main()
    }
}


//runBlocking


//
//        runBlocking {
//            println("Run blocking: ${Thread.currentThread().name}")
//
//            doTask()
//        }
//        println("MainAcitvity: ${Thread.currentThread().name}")
//    }
//
//    private suspend fun doTask() {
//        delay(2000)
//        println("DoTask: ${Thread.currentThread().name}")
//
//    }
//}


// Join


//        runBlocking {
//            val job = launch {
//                delay(3000)
//                println("First launch")
//            }
//            job.join()
//            launch {
//                println("Second Launch")
//            }
//        }
//    }
//}


// Job and Cancel

//        runBlocking {
//            println ("Before first launch")
//
//            val job = launch {
//                delay(3000)
//                println("First launch")
//            }
//            job.cancel()
//            launch {
//                println("Second launch")
//            }
//        }
//    }
//}


//Lightweight

//        repeat(50_000) {
//            thread {
//                Thread.sleep(1000)
//                println("*")
//            }
//        }
//    }
//}
