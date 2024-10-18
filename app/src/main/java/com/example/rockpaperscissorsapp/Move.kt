package com.example.rockpaperscissorsapp

import kotlin.random.Random

enum class Move(val emoji: String) {
    ROCK("🪨"),
    PAPER("📄"),
    SCISSORS("✂️");

    fun beats(opponent: Move): Boolean {
        return when (this) {
            ROCK -> opponent == SCISSORS
            PAPER -> opponent == ROCK
            SCISSORS -> opponent == PAPER
        }
    }

    // Static function
    companion object {
        fun getMove(emoji: String): Move? {
            return entries.find { it.emoji == emoji }
        }

        fun getRandomMove(): Move {
            val moves = entries.toTypedArray()
            val randomIndex = Random.nextInt(moves.size)
            return moves[randomIndex]
        }
    }
}