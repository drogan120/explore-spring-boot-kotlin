package com.drogan.playground.books.persistence

import com.drogan.playground.books.domain.Book
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class InMemoryBookRepository: BookRepository {
    val books = mutableMapOf<UUID, Book>()

    override fun create(book: Book): Book {
        books[book.id] = book
        return book
    }

    override fun find(bookId: UUID): Book? {
        return books[bookId]
    }

    override fun findAll(): List<Book> {
        return books.values.toList()
    }
}
