package com.drogan.playground.books.application

import com.drogan.playground.books.domain.Book
import com.drogan.playground.books.persistence.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun create(book: Book): Book {
        return bookRepository.create(book)
    }
    fun findAll(): List<Book> = bookRepository.findAll()

}
