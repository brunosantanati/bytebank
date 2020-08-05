fun main() {
    println("Bem vindo ao Bytebank")

    var i = 0
    while (i < 5){

        i++

        if(i == 3){
            continue
            //break
        }

        val titular: String = "Bruno $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular: $titular")
        println("número da conta: $numeroConta")
        println("saldo da conta: $saldo")
        println()
    }

    //for (i in 1..5) {
    //for(i in 5 downTo 1 step 2){
    /*for(i in 5 downTo 1){

        val titular: String = "Bruno $i"
        val numeroConta: Int = 1000 + i
        var saldo = i + 10.0

        println("titular: $titular")
        println("número da conta: $numeroConta")
        println("saldo da conta: $saldo")
        println()

        //testaCondicoes(saldo)
    }*/

    testaLoopAninhado()
}

fun testaLoopAninhado() {
    loopExterno@ for (i in 1..100) {
        println("i $i")
        for (j in 1..100) {
            println("j $j")
            if (j == 5) break@loopExterno
        }
    }
}

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> {
            println("conta é positiva")
        }
        saldo == 0.0 -> {
            println("conta é neutra")
        }
        else -> {
            println("conta é negativa")
        }
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}