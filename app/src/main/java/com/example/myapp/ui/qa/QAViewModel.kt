package com.example.myapp.ui.qa

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class QAItem(
    val question: String,
    val answer: String?,
    val postedBy: String = "Anonymous"
)

private val dummyQAs = listOf(
    QAItem(
        question = "SQL aur NoSQL mein main difference kya hai?",
        answer = "SQL structured tables use karta hai fixed schema ke saath, jabki NoSQL (jaise MongoDB) flexible documents use karta hai bina fixed schema ke. SQL JOIN operations ke liye better hai, NoSQL rapidly changing data ke liye better hai.",
        postedBy = "Rahul K."
    ),
    QAItem(
        question = "MongoDB free hai ya paid?",
        answer = "MongoDB Community Edition bilkul free aur open-source hai. MongoDB Atlas (cloud version) ka ek generous free tier bhi hai jo beginners ke liye kaafi hai. Paid plans large-scale production use ke liye hote hain.",
        postedBy = "Priya S."
    ),
    QAItem(
        question = "Kya MongoDB mein relationships possible hain?",
        answer = "Haan! MongoDB mein do tarike hain — Embedding (related data ek hi document mein rakhna) aur Referencing (doosre document ka _id store karna). Chhote, closely related data ke liye embedding better hoti hai.",
        postedBy = "Amit V."
    ),
)

class QAViewModel : ViewModel() {

    private val _items = MutableStateFlow(dummyQAs)
    val items: StateFlow<List<QAItem>> = _items

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText

    fun onInputChanged(text: String) {
        _inputText.value = text
    }

    fun onPostQuestion() {
        val text = _inputText.value.trim()
        if (text.isBlank()) return
        _items.value = _items.value + QAItem(question = text, answer = null)
        _inputText.value = ""
    }
}
