package com.camihruiz24.bookshelf.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.camihruiz24.bookshelf.R
import com.camihruiz24.bookshelf.data.domain_model.Book


@Composable
fun BookDetailsScreen(
    uiState: UiState<Book>,
    retry: () -> Unit,
    modifier: Modifier = Modifier,
    onAddToFavorites: () -> Unit
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize(),
    ) {
        when (uiState) {
            is UiState.Success -> SuccessDetailsScreen(book = uiState.screenState)
            UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> ErrorScreen(retry = retry, modifier = modifier)
        }
    }
}

@Composable
fun SuccessDetailsScreen(book: Book) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Show book title
        Text(
            text = book.title,
            style = typography.displayMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Show book authors
        Text(
            text = "Authors: ${book.authors.joinToString()}",
            style = typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Show book categories
        Text(
            text = "Categories: ${book.categories.joinToString()}",
            style = typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Show book description
        Text(
            text = book.description,
            style = typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Show book image
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(book.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.books_complete),
            error = painterResource(id = R.drawable.books_complete),
            modifier = Modifier.fillMaxSize(),
        )
    }
}
