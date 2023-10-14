package com.camihruiz24.bookshelf.fake

import com.camihruiz24.bookshelf.data.BookshelfRepository
import com.camihruiz24.bookshelf.data.NetworkBookshelfRepository
import com.camihruiz24.bookshelf.data.GoogleBooksApiService
import com.camihruiz24.bookshelf.data.domain_model.Book
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class NetworkBookshelfRepositoryTest {

    private lateinit var fakeRepository: BookshelfRepository

    @BeforeTest
    fun setUp() {
        fakeRepository = NetworkBookshelfRepository(FakeGoogleBooksApiService())
    }

    // Successful retrieval of amphibians' information
    @Test
    fun test_successful_retrieval_of_amphibians_information() {
        // Arrange
        val realRepository = NetworkBookshelfRepository(GoogleBooksApiService.googleBooksApiService)

        // Act
        val result = runBlocking { realRepository.getBooksBySearch("jazz+history") }

        // Assert
        assertTrue(result.isSuccess)
        assertNotNull(result.getOrNull())
    }

    @Test
    fun `When calling the list service, if successful, the service returns a Success Result List of Books`() =
        runTest {
            val expectedResult: Result<List<Book>> =
                Result.success(FakeDataSource.booksListResponseDto.toDomainModel())
            assertEquals(expectedResult, fakeRepository.getBooksBySearch("fake"))
        }

    @Test
    fun `When calling the single book service, if successful, the service returns a Success book by its id`() =
        runTest {
            val expectedResult: Result<Book> =
                Result.success(FakeDataSource.book1.toDomainModel())
            assertEquals(expectedResult, fakeRepository.getSingleBookById("12345"))
        }

    @Test
    fun `If IOException occurs when calling the remote service, Result failure is returned from method`() =
        runTest {
            // TODO: Hacer test del camino de error
        }
}