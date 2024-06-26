package com.example.ejercicios

fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    var ticketPrice: Int

    when(age){
        in 0 .. 12 -> ticketPrice = 15
        in 13 .. 60 -> {
            ticketPrice = 30
            if(isMonday) ticketPrice -= 5
        }
        in 61 .. 100 -> ticketPrice = 20
        else -> ticketPrice = -1
    }
    return ticketPrice
}