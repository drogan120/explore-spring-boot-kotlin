package com.drogan.playground.books.persistence

import com.drogan.playground.books.domain.Book
import java.util.UUID

interface BookRepository {
    fun create(book: Book): Book
    fun find(bookId: UUID): Book?
    fun findAll(): List<Book>
}
