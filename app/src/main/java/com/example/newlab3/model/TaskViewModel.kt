package com.example.newlab3.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
    var bookList = mutableStateListOf<Task>()

    fun add(newTask: Task){
        bookList.add(newTask)
    }
    fun delete(newTask: Task){
        bookList.remove(newTask)
    }
}