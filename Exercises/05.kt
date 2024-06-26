package com.example.ejercicios

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val elisabeth = Person("Elisabeth", 28, "climb", amanda)

    amanda.showProfile()
    elisabeth.showProfile()
}

class Person(
    private val name: String,
    private val age: Int,
    private val hobby: String?,
    private val referrer: Person?
) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if (hobby != null) {
            print("Likes to $hobby. ")
        }
        if (referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if (referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            print("Doesn't have a referrer.")
        }
        print("\n\n")
    }
}