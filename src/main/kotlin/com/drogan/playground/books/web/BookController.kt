package com.drogan.playground.books.web

import com.drogan.playground.books.application.BookService
import com.drogan.playground.books.domain.Book
import com.drogan.playground.books.web.dto.BookResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/books")
class BookController(
    private val bookService: BookService
) {
    @GetMapping
    fun index(): List<BookResponse> {
        val books = bookService.findAll()
        return books.map {
            BookResponse(
                id = it.id,
                title = it.title,
                author = it.author,
                status = it.status,
            )
        }
    }
}