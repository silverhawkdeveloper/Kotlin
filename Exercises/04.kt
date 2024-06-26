package com.example.ejercicios

fun main() {
    val yourSong = Song("Your Song", "Elton John", 1970, 77_000_000)
    yourSong.printDescription()
    println(yourSong.isPopular)
}

class Song(
    private val title: String,
    private val artist: String,
    private val yearPublished: Int,
    private val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, interpretada por $artist, se lanzó en $yearPublished.")
    }
}