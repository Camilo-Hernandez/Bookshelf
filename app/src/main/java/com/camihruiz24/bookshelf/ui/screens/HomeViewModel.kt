package com.camihruiz24.bookshelf.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camihruiz24.bookshelf.data.BookshelfRepository
import com.camihruiz24.bookshelf.data.domain_model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookshelfRepository: BookshelfRepository
) : ViewModel() {
    var uiState by mutableStateOf<UiState<List<Book>>>(UiState.Loading)
        private set

    init {
        getRemoteInfo()
    }

    private fun getRemoteInfo(search: String = "jazz+history") {
        viewModelScope.launch {
            bookshelfRepository.getBooksBySearch(search)
                .onSuccess {
                    uiState = UiState.Success(it)
                }
                .onFailure {
                    Log.d("viewModel Exception", "HomeViewModel")
                    uiState = UiState.Error(it)
                }
        }
    }

    fun retry(search: String = "jazz+history") {
        uiState = UiState.Loading
        getRemoteInfo(search)
    }
}