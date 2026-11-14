package com.drogan.playground.books

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Starter contract tests for Task 01.
 *
 * These tests are intentionally red until the Books API is implemented.
 * Add service unit tests and more controller cases as part of the task.
 */
@SpringBootTest
@AutoConfigureMockMvc
class BooksApiContractTest @Autowired constructor(
    private val mockMvc: MockMvc,
) {

    @Test
    fun `creating a book returns created resource and location`() {
        mockMvc.perform(
            post("/api/books")
                .contentType(APPLICATION_JSON)
                .content("""
                    {"title":"Clean Architecture","author":"Robert C. Martin"}
                """.trimIndent()),
        )
            .andExpect(status().isCreated)
            .andExpect(header().exists("Location"))
            .andExpect(jsonPath("$.id").isNotEmpty)
            .andExpect(jsonPath("$.title").value("Clean Architecture"))
            .andExpect(jsonPath("$.author").value("Robert C. Martin"))
            .andExpect(jsonPath("$.status").value("TO_READ"))
    }

    @Test
    fun `blank title is rejected`() {
        mockMvc.perform(
            post("/api/books")
                .contentType(APPLICATION_JSON)
                .content("""{"title":"   ","author":"An Author"}"""),
        )
            .andExpect(status().isBadRequest)
            .andExpect(jsonPath("$.errors").exists())
    }

    @Test
    fun `unknown book returns not found`() {
        mockMvc.perform(get("/api/books/00000000-0000-0000-0000-000000000000"))
            .andExpect(status().isNotFound)
    }
}
