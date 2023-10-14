package com.camihruiz24.bookshelf

import com.camihruiz24.bookshelf.data.GoogleBooksApiService
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.camihruiz24.bookshelf.data.remote_model.BooksListResponseDto
import com.camihruiz24.bookshelf.ui.navigation.MainNavigation
import com.camihruiz24.bookshelf.ui.screens.BookshelfTopAppBar
import com.camihruiz24.bookshelf.ui.screens.HomeScreen
import com.camihruiz24.bookshelf.ui.screens.HomeViewModel
import com.camihruiz24.bookshelf.ui.theme.BookshelfTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.URLEncoder

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { BookshelfTopAppBar() },
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        color = MaterialTheme.colorScheme.tertiaryContainer
                    ) {
                        MainNavigation()
                    }
                }
            }
        }
    }
}

