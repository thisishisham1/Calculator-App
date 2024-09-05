package com.example.calculatorapp

sealed class Destinations(val route: String) {
    data object Home : Destinations("home")
    data object Slash : Destinations("Slash")
}
