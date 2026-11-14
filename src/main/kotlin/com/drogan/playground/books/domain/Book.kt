package com.drogan.playground.books.domain

import java.util.UUID

data class Book(
    val id: UUID,
    val title: String,
    val author: String,
    val status: Status
) {
    enum class Status {
        TO_READ,
        READ,
    }
}