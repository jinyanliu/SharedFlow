package org.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    main1()
    //main2()
    //main3()
    //main4()
}

private suspend fun main1(): Unit = coroutineScope {
    val mutableSharedFlow = MutableSharedFlow<Char>()

    launch {
        for (c in 'A'..'E') {
            delay(300)
            mutableSharedFlow.emit(c)
        }
    }

    //Finished in 1500
    delay(2000)

    launch {
        mutableSharedFlow.collect {
            delay(1000)
            println("second $it")
        }
    }
}

private suspend fun main2(): Unit = coroutineScope {
    val mutableSharedFlow = MutableSharedFlow<Char>()

    launch {
        for (c in 'A'..'E') {
            delay(300)
            println("emitting $c")
            mutableSharedFlow.emit(c)
            println("$c emitted")
        }
    }

    launch {
        println("Start listening 1")
        mutableSharedFlow.collect {
            println("first $it")
            delay(1000)
            println("first $it after delay")
        }
    }

    delay(2000)

    launch {
        println("Start listening 2")
        mutableSharedFlow.collect {
            println("second $it")
            delay(1000)
            println("second $it after delay")
        }
    }
}

private suspend fun main3(): Unit = coroutineScope {
    val mutableSharedFlow = MutableSharedFlow<Char>()

    launch {
        for (c in 'A'..'E') {
            delay(300)
            println("emitting $c")
            mutableSharedFlow.emit(c)
            println("$c emitted")
        }
    }

    launch {
        println("Start listening 1")
        mutableSharedFlow.collect {
            println("first $it")
            delay(1000)
            println("first $it after delay")
        }
    }

    delay(2000)

    launch {
        println("Start listening 2")
        mutableSharedFlow.collect {
            println("second $it")
            delay(1000)
            println("second $it after delay")
        }
    }

    delay(4000) //Finished in 5300 (2000+3300)

    launch {
        println("Start listening 3")
        mutableSharedFlow.collect {
            println("third $it")
            delay(1000)
            println("third $it after delay")
        }
    }
}

private suspend fun main4(): Unit = coroutineScope {
    val mutableSharedFlow = MutableSharedFlow<Char>()

    launch {
        for (c in 'A'..'E') {
            delay(300)
            println("emitting $c")
            mutableSharedFlow.emit(c)
            println("$c emitted")
        }
    }

    launch {
        println("Start listening 1")
        mutableSharedFlow.collect {
            println("first $it")
            delay(1000)
            println("first $it after delay")
        }
    }

    delay(2000)

    launch {
        println("Start listening 2")
        mutableSharedFlow.collect {
            println("second $it")
            delay(2000)
            println("second $it after delay")
        }
    }

    delay(4000)

    launch {
        println("Start listening 3")
        mutableSharedFlow.collect {
            println("third $it")
            delay(1000)
            println("third $it after delay")
        }
    }
}

