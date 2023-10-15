package com.camihruiz24.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camihruiz24.bookshelf.data.BookshelfRepository
import com.camihruiz24.bookshelf.data.domain_model.Book
import com.camihruiz24.bookshelf.ui.navigation.NavigationArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BookDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val bookshelfRepository: BookshelfRepository
) : ViewModel() {

    private val bookId: String = checkNotNull(savedStateHandle[NavigationArg.ID.key])

    var uiState by mutableStateOf<UiState<Book>>(UiState.Loading)
        private set

    init {
        getRemoteInfo()
    }

    private fun getRemoteInfo() {
        viewModelScope.launch {
            bookshelfRepository.getSingleBookById(bookId)
                .onSuccess {
                    uiState = UiState.Success(it)
                }
                .onFailure {
                    uiState = UiState.Error(it)
                }
        }
    }

    fun retry() {
        uiState = UiState.Loading
        getRemoteInfo()
    }
}