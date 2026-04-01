package com.example.myapp.data.model

data class Option(val id: String, val text: String)

data class Question(
    val id: String,
    val questionText: String,
    val options: List<Option>,
    val correctOptionId: String,
    val explanation: String
)
