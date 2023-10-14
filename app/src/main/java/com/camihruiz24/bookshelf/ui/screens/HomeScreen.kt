package com.camihruiz24.bookshelf.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.camihruiz24.bookshelf.R
import com.camihruiz24.bookshelf.data.domain_model.Book

@Composable
fun HomeScreen(
    uiState: UiState<List<Book>>,
    retry: () -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToDetail: (Book) -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize(),
    ) {
        when (uiState) {
            is UiState.Success -> SuccessHomeScreen(bookList = uiState.screenState, onNavigateToDetail = onNavigateToDetail)
            UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> ErrorScreen(retry = retry, modifier = modifier)
        }
    }
}

@Composable
fun SuccessHomeScreen(bookList: List<Book>, onNavigateToDetail: (Book) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
        columns = GridCells.Adaptive(150.dp)
    ) {
        items(bookList){
            BookCard(book = it, Modifier.sizeIn(minHeight = 270.dp), onNavigateToDetail = onNavigateToDetail)
        }
    }
}
