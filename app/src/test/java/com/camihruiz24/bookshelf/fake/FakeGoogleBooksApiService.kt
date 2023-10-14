package com.camihruiz24.bookshelf.fake

import com.camihruiz24.bookshelf.data.GoogleBooksApiService
import com.camihruiz24.bookshelf.data.remote_model.BooksListResponseDto
import com.camihruiz24.bookshelf.data.remote_model.SingleBookResponseDto

class FakeGoogleBooksApiService : GoogleBooksApiService {
    override suspend fun getAllBooksBySearch(q: String): BooksListResponseDto =
        FakeDataSource.booksListResponseDto

    override suspend fun getSingleBookById(id: String): SingleBookResponseDto {
        val books: List<SingleBookResponseDto> = FakeDataSource.run {
            listOf(book1, book2, book3)
        }

        return books.find {
            it.id == id
        }!!
    }
}


object FakeDataSource {
    // Crear una instancia de BooksListResponseDto con tres elementos en la lista items
    val booksListResponseDto = BooksListResponseDto(
        kind = "books#volumes", totalItems = 100, items = listOf(
            BooksListResponseDto.Item(
                kind = "books#volume",
                id = "12345",
                etag = "ETAG123",
                selfLink = "https://example.com/book/12345",
                volumeInfo = BooksListResponseDto.Item.VolumeInfo(
                    title = "Sample Book 1",
                    authors = listOf("Author1", "Author2"),
                    publisher = "Publisher ABC",
                    publishedDate = "2023-01-01",
                    description = "This is a sample book description.",
                    imageLinks = BooksListResponseDto.Item.VolumeInfo.ImageLinks(
                        smallThumbnail = "https://example.com/book/smallthumbnail.jpg",
                        thumbnail = "https://example.com/book/thumbnail.jpg"
                    ),
                    categories = listOf("Fiction", "Mystery"),
                    language = "English",
                    previewLink = "https://example.com/book/preview",
                    infoLink = "https://example.com/book/info",
                    canonicalVolumeLink = "https://example.com/book/canonical",
                    subtitle = "A Sample Subtitle",
                    averageRating = 4,
                    ratingsCount = 50
                ),
                saleInfo = BooksListResponseDto.Item.SaleInfo(
                    country = "US",
                    saleability = "FOR_SALE",
                    isEbook = true,
                    listPrice = BooksListResponseDto.Item.SaleInfo.ListPrice(
                        amount = 999, currencyCode = "USD"
                    ),
                    retailPrice = BooksListResponseDto.Item.SaleInfo.RetailPrice(
                        amount = 1299, currencyCode = "USD"
                    ),
                    buyLink = "https://example.com/book/buy",
                    offers = listOf(
                        BooksListResponseDto.Item.SaleInfo.Offer(
                            finskyOfferType = 1,
                            listPrice = BooksListResponseDto.Item.SaleInfo.Offer.ListPrice(
                                amountInMicros = 999999, currencyCode = "USD"
                            ),
                            retailPrice = BooksListResponseDto.Item.SaleInfo.Offer.RetailPrice(
                                amountInMicros = 1299999, currencyCode = "USD"
                            )
                        )
                    )
                ),
                accessInfo = BooksListResponseDto.Item.AccessInfo(
                    country = "US",
                    viewability = "PARTIAL",
                    embeddable = true,
                    publicDomain = false,
                    textToSpeechPermission = "ALLOWED",
                    epub = BooksListResponseDto.Item.AccessInfo.Epub(
                        isAvailable = true, acsTokenLink = "https://example.com/book/epub/token"
                    ),
                    pdf = BooksListResponseDto.Item.AccessInfo.Pdf(
                        isAvailable = true, acsTokenLink = "https://example.com/book/pdf/token"
                    ),
                    webReaderLink = "https://example.com/book/webreader",
                    accessViewStatus = "SAMPLE_STATUS",
                    quoteSharingAllowed = true
                ),
                searchInfo = BooksListResponseDto.Item.SearchInfo(
                    textSnippet = "This is a sample text snippet."
                )
            ), BooksListResponseDto.Item(
                kind = "books#volume",
                id = "67890",
                etag = "ETAG678",
                selfLink = "https://example.com/book/67890",
                volumeInfo = BooksListResponseDto.Item.VolumeInfo(
                    title = "Sample Book 2",
                    authors = listOf("Author3"),
                    publisher = "Publisher XYZ",
                    publishedDate = "2023-02-01",
                    description = "Another sample book description.",
                    imageLinks = BooksListResponseDto.Item.VolumeInfo.ImageLinks(
                        smallThumbnail = "https://example.com/book/smallthumbnail2.jpg",
                        thumbnail = "https://example.com/book/thumbnail2.jpg"
                    ),
                    categories = listOf("Non-Fiction", "Biography"),
                    language = "Spanish",
                    previewLink = "https://example.com/book/preview2",
                    infoLink = "https://example.com/book/info2",
                    canonicalVolumeLink = "https://example.com/book/canonical2",
                    subtitle = "Sample Subtitle 2",
                    averageRating = 4,
                    ratingsCount = 30
                ),
                saleInfo = BooksListResponseDto.Item.SaleInfo(
                    country = "UK",
                    saleability = "FOR_SALE",
                    isEbook = true,
                    listPrice = BooksListResponseDto.Item.SaleInfo.ListPrice(
                        amount = 799, currencyCode = "GBP"
                    ),
                    retailPrice = BooksListResponseDto.Item.SaleInfo.RetailPrice(
                        amount = 1099, currencyCode = "GBP"
                    ),
                    buyLink = "https://example.com/book/buy2",
                    offers = listOf(
                        BooksListResponseDto.Item.SaleInfo.Offer(
                            finskyOfferType = 1,
                            listPrice = BooksListResponseDto.Item.SaleInfo.Offer.ListPrice(
                                amountInMicros = 799999, currencyCode = "GBP"
                            ),
                            retailPrice = BooksListResponseDto.Item.SaleInfo.Offer.RetailPrice(
                                amountInMicros = 1099999, currencyCode = "GBP"
                            )
                        )
                    )
                ),
                accessInfo = BooksListResponseDto.Item.AccessInfo(
                    country = "UK",
                    viewability = "FULL",
                    embeddable = true,
                    publicDomain = true,
                    textToSpeechPermission = "ALLOWED",
                    epub = BooksListResponseDto.Item.AccessInfo.Epub(
                        isAvailable = true, acsTokenLink = "https://example.com/book/epub2/token"
                    ),
                    pdf = BooksListResponseDto.Item.AccessInfo.Pdf(
                        isAvailable = true, acsTokenLink = "https://example.com/book/pdf2/token"
                    ),
                    webReaderLink = "https://example.com/book/webreader2",
                    accessViewStatus = "SAMPLE_STATUS",
                    quoteSharingAllowed = true
                ),
                searchInfo = BooksListResponseDto.Item.SearchInfo(
                    textSnippet = "This is another sample text snippet."
                )
            ), BooksListResponseDto.Item(
                kind = "books#volume",
                id = "54321",
                etag = "ETAG543",
                selfLink = "https://example.com/book/54321",
                volumeInfo = BooksListResponseDto.Item.VolumeInfo(
                    title = "Sample Book 3",
                    authors = listOf("Author4", "Author5"),
                    publisher = "Publisher DEF",
                    publishedDate = "2023-03-01",
                    description = "Yet another sample book description.",
                    imageLinks = BooksListResponseDto.Item.VolumeInfo.ImageLinks(
                        smallThumbnail = "https://example.com/book/smallthumbnail3.jpg",
                        thumbnail = "https://example.com/book/thumbnail3.jpg"
                    ),
                    categories = listOf("Science Fiction"),
                    language = "French",
                    previewLink = "https://example.com/book/preview3",
                    infoLink = "https://example.com/book/info3",
                    canonicalVolumeLink = "https://example.com/book/canonical3",
                    subtitle = "Sample Subtitle 3",
                    averageRating = 4,
                    ratingsCount = 20
                ),
                saleInfo = BooksListResponseDto.Item.SaleInfo(
                    country = "FR",
                    saleability = "FOR_SALE",
                    isEbook = true,
                    listPrice = BooksListResponseDto.Item.SaleInfo.ListPrice(
                        amount = 699, currencyCode = "EUR"
                    ),
                    retailPrice = BooksListResponseDto.Item.SaleInfo.RetailPrice(
                        amount = 999, currencyCode = "EUR"
                    ),
                    buyLink = "https://example.com/book/buy3",
                    offers = listOf(
                        BooksListResponseDto.Item.SaleInfo.Offer(
                            finskyOfferType = 1,
                            listPrice = BooksListResponseDto.Item.SaleInfo.Offer.ListPrice(
                                amountInMicros = 699999, currencyCode = "EUR"
                            ),
                            retailPrice = BooksListResponseDto.Item.SaleInfo.Offer.RetailPrice(
                                amountInMicros = 999999, currencyCode = "EUR"
                            )
                        )
                    )
                ),
                accessInfo = BooksListResponseDto.Item.AccessInfo(
                    country = "FR",
                    viewability = "FULL",
                    embeddable = true,
                    publicDomain = false,
                    textToSpeechPermission = "ALLOWED",
                    epub = BooksListResponseDto.Item.AccessInfo.Epub(
                        isAvailable = true, acsTokenLink = "https://example.com/book/epub3/token"
                    ),
                    pdf = BooksListResponseDto.Item.AccessInfo.Pdf(
                        isAvailable = true, acsTokenLink = "https://example.com/book/pdf3/token"
                    ),
                    webReaderLink = "https://example.com/book/webreader3",
                    accessViewStatus = "SAMPLE_STATUS",
                    quoteSharingAllowed = true
                ),
                searchInfo = BooksListResponseDto.Item.SearchInfo(
                    textSnippet = "This is yet another sample text snippet."
                )
            )
        )
    )

    // Crear tres objetos de prueba de SingleBookResponseDto
    val book1 = SingleBookResponseDto(
        kind = "books#volume",
        id = "12345",
        etag = "ETAG123",
        selfLink = "https://example.com/book/12345",
        volumeInfo = SingleBookResponseDto.VolumeInfo(
            title = "Sample Book 1",
            authors = listOf("Author1", "Author2"),
            publisher = "Publisher ABC",
            publishedDate = "2023-01-01",
            description = "This is a sample book description.",
            imageLinks = SingleBookResponseDto.VolumeInfo.ImageLinks(
                smallThumbnail = "https://example.com/book/smallthumbnail.jpg",
                thumbnail = "https://example.com/book/thumbnail.jpg",
                small = "https://example.com/book/small.jpg",
                medium = "https://example.com/book/medium.jpg"
            ),
            categories = listOf("Fiction", "Mystery"),
            language = "English",
            previewLink = "https://example.com/book/preview",
            infoLink = "https://example.com/book/info",
            canonicalVolumeLink = "https://example.com/book/canonical"
        ),
        layerInfo = SingleBookResponseDto.LayerInfo(
            layers = listOf(
                SingleBookResponseDto.LayerInfo.Layer(
                    layerId = "layer123", volumeAnnotationsVersion = "v1"
                )
            )
        ),
        saleInfo = SingleBookResponseDto.SaleInfo(
            country = "US", saleability = "FOR_SALE", isEbook = true
        ),
        accessInfo = SingleBookResponseDto.AccessInfo(
            country = "US",
            viewability = "PARTIAL",
            embeddable = true,
            publicDomain = false,
            textToSpeechPermission = "ALLOWED",
            epub = SingleBookResponseDto.AccessInfo.Epub(
                isAvailable = true, acsTokenLink = "https://example.com/book/epub/token"
            ),
            pdf = SingleBookResponseDto.AccessInfo.Pdf(
                isAvailable = true, acsTokenLink = "https://example.com/book/pdf/token"
            ),
            webReaderLink = "https://example.com/book/webreader",
            accessViewStatus = "SAMPLE_STATUS",
            quoteSharingAllowed = true
        )
    )

    val book2 = SingleBookResponseDto(
        kind = "books#volume",
        id = "67890",
        etag = "ETAG678",
        selfLink = "https://example.com/book/67890",
        volumeInfo = SingleBookResponseDto.VolumeInfo(
            title = "Sample Book 2",
            authors = listOf("Author3"),
            publisher = "Publisher XYZ",
            publishedDate = "2023-02-01",
            description = "Another sample book description.",
            imageLinks = SingleBookResponseDto.VolumeInfo.ImageLinks(
                smallThumbnail = "https://example.com/book/smallthumbnail2.jpg",
                thumbnail = "https://example.com/book/thumbnail2.jpg",
                small = "https://example.com/book/small2.jpg",
                medium = "https://example.com/book/medium2.jpg"
            ),
            categories = listOf("Non-Fiction", "Biography"),
            language = "Spanish",
            previewLink = "https://example.com/book/preview2",
            infoLink = "https://example.com/book/info2",
            canonicalVolumeLink = "https://example.com/book/canonical2"
        ),
        layerInfo = SingleBookResponseDto.LayerInfo(
            layers = listOf(
                SingleBookResponseDto.LayerInfo.Layer(
                    layerId = "layer456", volumeAnnotationsVersion = "v2"
                )
            )
        ),
        saleInfo = SingleBookResponseDto.SaleInfo(
            country = "UK", saleability = "FOR_SALE", isEbook = true
        ),
        accessInfo = SingleBookResponseDto.AccessInfo(
            country = "UK",
            viewability = "FULL",
            embeddable = true,
            publicDomain = true,
            textToSpeechPermission = "ALLOWED",
            epub = SingleBookResponseDto.AccessInfo.Epub(
                isAvailable = true, acsTokenLink = "https://example.com/book/epub2/token"
            ),
            pdf = SingleBookResponseDto.AccessInfo.Pdf(
                isAvailable = true, acsTokenLink = "https://example.com/book/pdf2/token"
            ),
            webReaderLink = "https://example.com/book/webreader2",
            accessViewStatus = "SAMPLE_STATUS",
            quoteSharingAllowed = true
        )
    )

    val book3 = SingleBookResponseDto(
        kind = "books#volume",
        id = "54321",
        etag = "ETAG543",
        selfLink = "https://example.com/book/54321",
        volumeInfo = SingleBookResponseDto.VolumeInfo(
            title = "Sample Book 3",
            authors = listOf("Author4", "Author5"),
            publisher = "Publisher DEF",
            publishedDate = "2023-03-01",
            description = "Yet another sample book description.",
            imageLinks = SingleBookResponseDto.VolumeInfo.ImageLinks(
                smallThumbnail = "https://example.com/book/smallthumbnail3.jpg",
                thumbnail = "https://example.com/book/thumbnail3.jpg",
                small = "https://example.com/book/small3.jpg",
                medium = "https://example.com/book/medium3.jpg"
            ),
            categories = listOf("Science Fiction"),
            language = "French",
            previewLink = "https://example.com/book/preview3",
            infoLink = "https://example.com/book/info3",
            canonicalVolumeLink = "https://example.com/book/canonical3"
        ),
        layerInfo = SingleBookResponseDto.LayerInfo(
            layers = listOf(
                SingleBookResponseDto.LayerInfo.Layer(
                    layerId = "layer789", volumeAnnotationsVersion = "v3"
                )
            )
        ),
        saleInfo = SingleBookResponseDto.SaleInfo(
            country = "FR", saleability = "FOR_SALE", isEbook = true
        ),
        accessInfo = SingleBookResponseDto.AccessInfo(
            country = "FR",
            viewability = "FULL",
            embeddable = true,
            publicDomain = false,
            textToSpeechPermission = "ALLOWED",
            epub = SingleBookResponseDto.AccessInfo.Epub(
                isAvailable = true, acsTokenLink = "https://example.com/book/epub3/token"
            ),
            pdf = SingleBookResponseDto.AccessInfo.Pdf(
                isAvailable = true, acsTokenLink = "https://example.com/book/pdf3/token"
            ),
            webReaderLink = "https://example.com/book/webreader3",
            accessViewStatus = "SAMPLE_STATUS",
            quoteSharingAllowed = true
        )
    )

}