package com.camihruiz24.bookshelf.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camihruiz24.bookshelf.R
import com.camihruiz24.bookshelf.data.domain_model.Book

@Composable
fun BookCard(book: Book, modifier: Modifier = Modifier, onNavigateToDetail: (Book) -> Unit) {

    var expanded: Boolean by remember { mutableStateOf(false) }
    val itemColor by animateColorAsState(
        targetValue = when (expanded) {
            true -> MaterialTheme.colorScheme.tertiary
            false -> MaterialTheme.colorScheme.primary
        },
        label = "Card Expansion"
    )

    Card(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow,
                )
            ),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(color = itemColor)
                .clickable { onNavigateToDetail(book) }
        ) {
            BookImage(book, Modifier.fillMaxSize())
            Text(
                text = "${book.title}\n(${book.authors[0].replaceFirstChar { it.uppercase() }})",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
            if (expanded)
                Text(
                    text = book.categories[0],
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
                )
        }
    }
}

@Preview
@Composable
fun BookItemPreview() {
    val book = Book(
        id = "",
        title = "Great Basin Spadefoot",
        description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
        categories = listOf("Toad"),
        authors = emptyList(),
        imageUrl = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png",
    )
    BookCard(
        book = book,
        onNavigateToDetail = {}
    )
}
