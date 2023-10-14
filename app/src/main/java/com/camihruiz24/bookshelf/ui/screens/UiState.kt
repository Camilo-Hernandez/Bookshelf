package com.camihruiz24.bookshelf.ui.screens

sealed interface UiState<out T> {
    data class Success<out T>(val screenState: T) : UiState<T>
    data class Error(val error: Throwable) : UiState<Nothing>
    data object Loading : UiState<Nothing>
}
