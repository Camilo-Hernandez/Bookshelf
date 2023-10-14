package com.camihruiz24.bookshelf.data.remote_model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class proof(
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
    val accessInfo: AccessInfo = AccessInfo()
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
        @SerialName("printedPageCount")
        val printedPageCount: Int = 0,
        @SerialName("dimensions")
        val dimensions: Dimensions = Dimensions(),
        @SerialName("printType")
        val printType: String = "",
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
        val canonicalVolumeLink: String = ""
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
        data class Dimensions(
            @SerialName("height")
            val height: String = "",
            @SerialName("width")
            val width: String = "",
            @SerialName("thickness")
            val thickness: String = ""
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
            val thumbnail: String = "",
            @SerialName("small")
            val small: String = "",
            @SerialName("medium")
            val medium: String = "",
            @SerialName("large")
            val large: String = "",
            @SerialName("extraLarge")
            val extraLarge: String = ""
        )
    }

    @Serializable
    data class SaleInfo(
        @SerialName("country")
        val country: String = "",
        @SerialName("saleability")
        val saleability: String = "",
        @SerialName("isEbook")
        val isEbook: Boolean = false
    )

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
            val isAvailable: Boolean = false
        )

        @Serializable
        data class Pdf(
            @SerialName("isAvailable")
            val isAvailable: Boolean = false
        )
    }
}