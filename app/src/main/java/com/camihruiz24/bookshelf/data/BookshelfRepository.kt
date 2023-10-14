package com.camihruiz24.bookshelf.data

import com.camihruiz24.bookshelf.data.domain_model.Book
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

interface BookshelfRepository {
    suspend fun getBooksBySearch(search: String): Result<List<Book>>
    suspend fun getSingleBookById(id: String): Result<Book>
}

class NetworkBookshelfRepository @Inject constructor(
    private val service: GoogleBooksApiService
) : BookshelfRepository {
    override suspend fun getBooksBySearch(search: String): Result<List<Book>> =
        try {
            Result.success(service.getAllBooksBySearch(search).toDomainModel())
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: coil.network.HttpException) {
            Result.failure(e)
        }

    override suspend fun getSingleBookById(id: String): Result<Book> =
        try {
            Result.success(service.getSingleBookById(id).toDomainModel())
        } catch (e: IOException) {
            Result.failure(e)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: coil.network.HttpException) {
            Result.failure(e)
        }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBookshelfRepository(
        bookshelfRepositoryImpl: NetworkBookshelfRepository
    ): BookshelfRepository

}
