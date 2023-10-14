package com.camihruiz24.bookshelf.fake

import com.camihruiz24.bookshelf.data.BookshelfRepository
import com.camihruiz24.bookshelf.data.domain_model.Book
import retrofit2.HttpException
import java.io.IOException

class FakeNetworkBookshelfRepository : BookshelfRepository {

    private val fakeGoogleBooksApiService = FakeGoogleBooksApiService()

    override suspend fun getBooksBySearch(search: String): Result<List<Book>> =
        try {
            Result.success(
                fakeGoogleBooksApiService.getAllBooksBySearch("fake").toDomainModel()
            )
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: coil.network.HttpException) {
            Result.failure(e)
        }

    override suspend fun getSingleBookById(id: String): Result<Book> =
            try {
                Result.success(fakeGoogleBooksApiService.getSingleBookById(id).toDomainModel())
            } catch (e: IOException) {
                Result.failure(e)
            } catch (e: HttpException) {
                Result.failure(e)
            } catch (e: coil.network.HttpException) {
                Result.failure(e)
            }
}