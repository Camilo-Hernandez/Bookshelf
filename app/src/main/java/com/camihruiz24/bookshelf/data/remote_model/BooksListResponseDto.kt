package com.camihruiz24.bookshelf.data.remote_model

import com.camihruiz24.bookshelf.data.domain_model.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksListResponseDto(
    @SerialName("kind")
    val kind: String = "",
    @SerialName("totalItems")
    val totalItems: Int = 0,
    @SerialName("items")
    val items: List<Item> = listOf()
) {

    fun toDomainModel() : List<Book> =
        items.map {
            Book(
                id = it.id,
                title = it.volumeInfo.title,
                description = it.volumeInfo.description,
                authors = it.volumeInfo.authors,
                imageUrl = it.volumeInfo.imageLinks.thumbnail.replace("http", "https"),
                categories = it.volumeInfo.categories,
            )
        }

    @Serializable
    data class Item(
        @SerialName("kind")
        val kind: String = "",
        @SerialName("id")
        val id: String = "",
        @SerialName("etag")
        val etag: String = "",
        @SerialName("selfLink")
        val selfLink: String = "",
        @SerialName("volumeInfo")
        val volumeInfo: VolumeInfo = VolumeInfo(),
        @SerialName("saleInfo")
        val saleInfo: SaleInfo = SaleInfo(),
        @SerialName("accessInfo")
        val accessInfo: AccessInfo = AccessInfo(),
        @SerialName("searchInfo")
        val searchInfo: SearchInfo = SearchInfo()
    ) {
        @Serializable
        data class VolumeInfo(
            @SerialName("title")
            val title: String = "",
            @SerialName("authors")
            val authors: List<String> = listOf(),
            @SerialName("publisher")
            val publisher: String = "",
            @SerialName("publishedDate")
            val publishedDate: String = "",
            @SerialName("description")
            val description: String = "",
            @SerialName("industryIdentifiers")
            val industryIdentifiers: List<IndustryIdentifier> = listOf(),
            @SerialName("readingModes")
            val readingModes: ReadingModes = ReadingModes(),
            @SerialName("pageCount")
            val pageCount: Int = 0,
            @SerialName("printType")
            val printType: String = "",
            @SerialName("categories")
            val categories: List<String> = listOf(),
            @SerialName("maturityRating")
            val maturityRating: String = "",
            @SerialName("allowAnonLogging")
            val allowAnonLogging: Boolean = false,
            @SerialName("contentVersion")
            val contentVersion: String = "",
            @SerialName("panelizationSummary")
            val panelizationSummary: PanelizationSummary = PanelizationSummary(),
            @SerialName("imageLinks")
            val imageLinks: ImageLinks = ImageLinks(),
            @SerialName("language")
            val language: String = "",
            @SerialName("previewLink")
            val previewLink: String = "",
            @SerialName("infoLink")
            val infoLink: String = "",
            @SerialName("canonicalVolumeLink")
            val canonicalVolumeLink: String = "",
            @SerialName("subtitle")
            val subtitle: String = "",
            @SerialName("averageRating")
            val averageRating: Int = 0,
            @SerialName("ratingsCount")
            val ratingsCount: Int = 0
        ) {
            @Serializable
            data class IndustryIdentifier(
                @SerialName("type")
                val type: String = "",
                @SerialName("identifier")
                val identifier: String = ""
            )

            @Serializable
            data class ReadingModes(
                @SerialName("text")
                val text: Boolean = false,
                @SerialName("image")
                val image: Boolean = false
            )

            @Serializable
            data class PanelizationSummary(
                @SerialName("containsEpubBubbles")
                val containsEpubBubbles: Boolean = false,
                @SerialName("containsImageBubbles")
                val containsImageBubbles: Boolean = false
            )

            @Serializable
            data class ImageLinks(
                @SerialName("smallThumbnail")
                val smallThumbnail: String = "",
                @SerialName("thumbnail")
                val thumbnail: String = ""
            )
        }

        @Serializable
        data class SaleInfo(
            @SerialName("country")
            val country: String = "",
            @SerialName("saleability")
            val saleability: String = "",
            @SerialName("isEbook")
            val isEbook: Boolean = false,
            @SerialName("listPrice")
            val listPrice: ListPrice = ListPrice(),
            @SerialName("retailPrice")
            val retailPrice: RetailPrice = RetailPrice(),
            @SerialName("buyLink")
            val buyLink: String = "",
            @SerialName("offers")
            val offers: List<Offer> = listOf()
        ) {
            @Serializable
            data class ListPrice(
                @SerialName("amount")
                val amount: Int = 0,
                @SerialName("currencyCode")
                val currencyCode: String = ""
            )

            @Serializable
            data class RetailPrice(
                @SerialName("amount")
                val amount: Int = 0,
                @SerialName("currencyCode")
                val currencyCode: String = ""
            )

            @Serializable
            data class Offer(
                @SerialName("finskyOfferType")
                val finskyOfferType: Int = 0,
                @SerialName("listPrice")
                val listPrice: ListPrice = ListPrice(),
                @SerialName("retailPrice")
                val retailPrice: RetailPrice = RetailPrice()
            ) {
                @Serializable
                data class ListPrice(
                    @SerialName("amountInMicros")
                    val amountInMicros: Long = 0,
                    @SerialName("currencyCode")
                    val currencyCode: String = ""
                )

                @Serializable
                data class RetailPrice(
                    @SerialName("amountInMicros")
                    val amountInMicros: Long = 0,
                    @SerialName("currencyCode")
                    val currencyCode: String = ""
                )
            }
        }

        @Serializable
        data class AccessInfo(
            @SerialName("country")
            val country: String = "",
            @SerialName("viewability")
            val viewability: String = "",
            @SerialName("embeddable")
            val embeddable: Boolean = false,
            @SerialName("publicDomain")
            val publicDomain: Boolean = false,
            @SerialName("textToSpeechPermission")
            val textToSpeechPermission: String = "",
            @SerialName("epub")
            val epub: Epub = Epub(),
            @SerialName("pdf")
            val pdf: Pdf = Pdf(),
            @SerialName("webReaderLink")
            val webReaderLink: String = "",
            @SerialName("accessViewStatus")
            val accessViewStatus: String = "",
            @SerialName("quoteSharingAllowed")
            val quoteSharingAllowed: Boolean = false
        ) {
            @Serializable
            data class Epub(
                @SerialName("isAvailable")
                val isAvailable: Boolean = false,
                @SerialName("acsTokenLink")
                val acsTokenLink: String = ""
            )

            @Serializable
            data class Pdf(
                @SerialName("isAvailable")
                val isAvailable: Boolean = false,
                @SerialName("acsTokenLink")
                val acsTokenLink: String = ""
            )
        }

        @Serializable
        data class SearchInfo(
            @SerialName("textSnippet")
            val textSnippet: String = ""
        )
    }
}