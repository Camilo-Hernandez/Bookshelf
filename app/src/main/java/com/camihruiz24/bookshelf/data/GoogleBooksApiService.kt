package com.camihruiz24.bookshelf.data

import com.camihruiz24.bookshelf.data.remote_model.BooksListResponseDto
import com.camihruiz24.bookshelf.data.remote_model.SingleBookResponseDto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

interface GoogleBooksApiService {
    @GET("volumes")
    suspend fun getAllBooksBySearch(@Query("q") q: String): BooksListResponseDto

    @GET("volumes/{id}")
    suspend fun getSingleBookById(@Path("id") id: String): SingleBookResponseDto

    companion object {

        //show Network information in to the logcat
        val intercepter = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(intercepter)
            // time out setting
            .connectTimeout(3,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(25,TimeUnit.SECONDS)
            .build()

        private const val BASE_URL = "https://www.googleapis.com/books/v1/"

        private val json = Json { ignoreUnknownKeys = true }

        private val retrofitObject: Retrofit = Retrofit.Builder()
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .client(client)
            .build()

        val googleBooksApiService: GoogleBooksApiService by lazy {
            retrofitObject.create(GoogleBooksApiService::class.java)
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AnalyticsModule {
    @Provides
    @Singleton
    fun provideGoogleBooksApiService(): GoogleBooksApiService =
        GoogleBooksApiService.googleBooksApiService
}
