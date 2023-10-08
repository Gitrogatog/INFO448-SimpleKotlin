package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(x: Any) : String {
    val message = when(x){
        "Hello" -> "world"
        is String -> "Say what?"
        0 -> "zero"
        1 -> "one"
        in 2..10 -> "low number"
        is Int -> "a number"
        else -> "I don't understand"
    }
    return message
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(x: Int, y: Int) : Int {
    return x + y
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(x: Int, y: Int) : Int {
    return x - y
}
// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(x: Int, y: Int, f: (Int, Int) -> Int) : Int {
    return f(x, y)
}
// write a class "Person" with first name, last name and age
class Person(var firstName : String, var lastName : String, var age : Int) {
    val debugString : String
        get() = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money {
    public var amount : Int = 0
        set(value) {
            if(value >= 0) {
                field = value
            }
            else{
                throw IllegalArgumentException()
            }
        }
    public var currency : String = "USD"
        set(value) {
            when (value){
                "USD", "EUR", "CAN", "GBP" -> field = value
                else -> throw IllegalArgumentException()
            }
        }
    constructor(amount: Int, currency: String) {
        this.amount = amount
        this.currency = currency
    }
    public fun convert(curr : String) : Money {
        //Convert to USD
        var conversion = (toUSD(currency) * fromUSD(curr))
        var a = conversion * amount.toDouble()
        return Money(a.toInt(), curr)
    }
    private fun toUSD(curr: String) : Double {
        var value : Double = when(curr) {
            "EUR" -> 2.0 / 3.0
            "GBP" -> 2.0
            "CAN" -> 4.0 / 5.0
            else -> 1.0
        }
        return value
    }
    private fun fromUSD(curr: String) : Double {
        var value: Double = when(curr) {
            "EUR" -> 1.5 //3 / 2
            "GBP" -> 0.5 //1 / 2
            "CAN" -> 5.0 / 4.0
            else -> 1.0
        }

        return value
    }
    operator fun plus (b: Money) : Money {
        var conversion = (toUSD(b.currency) * fromUSD(currency))
        var bAmount = (conversion * b.amount.toDouble())

        return Money(amount + bAmount.toInt(), currency)
    }
}

