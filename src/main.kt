fun main() {
    println("Bem vindo ao Bytebank")

    val contaAlex = Conta("Alex", 1000)
    contaAlex.deposita(200.0)

    val contaFran = Conta(numero = 1001, teste = 500, titular = "Fran") //se usar label pode mudar a ordem dos parametros
    contaFran.deposita(300.0)

    println()

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)
    println(contaAlex.teste)

    println()

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)
    println(contaFran.teste)

    println()

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(500.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")
    if(contaFran.transfere(valor = 100.0, destino = contaAlex)){
        println("Transferência sucedida")
    }else{
        println("Falha na transferência")
    }

    println("Saldo Alex ${contaAlex.saldo}")
    println("Saldo Fran ${contaFran.saldo}")
}

class Conta(
        var titular: String,
        val numero: Int,
        val teste: Int = 10 //valor default se não for fornecido o numero, deixa esse argumento como opcional
) {
    var saldo = 0.0
        private set

//    constructor(titular: String, numero: Int){
//        this.titular = titular
//        this.numero = numero
//    }

    init {
        println("Testando init $this")
    }

    fun deposita(valor: Double){
        if(valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double){
        if(saldo >= valor){
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean{
        if(saldo >= valor){
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }
}

fun testaValorEReferencia(){
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 2000)
    var contaMaria = contaJoao
    contaMaria.titular = "Maria"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos() {
    var i = 0
    while (i < 5) {

        i++

        if (i == 3) {
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