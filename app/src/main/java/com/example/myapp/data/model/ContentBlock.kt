package com.example.myapp.data.model

sealed class ContentBlock {
    data class TextBlock(val text: String) : ContentBlock()
    data class ExampleBlock(val heading: String, val body: String) : ContentBlock()
}
