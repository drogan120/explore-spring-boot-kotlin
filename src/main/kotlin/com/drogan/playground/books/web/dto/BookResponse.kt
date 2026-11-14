package com.drogan.playground.books.web.dto

import com.drogan.playground.books.domain.Book
import java.util.UUID

data class BookResponse(
    val id: UUID,
    val title: String,
    val author: String,
    val status: Book.Status,
)