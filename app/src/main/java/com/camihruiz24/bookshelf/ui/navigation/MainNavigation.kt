package com.camihruiz24.bookshelf.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.camihruiz24.bookshelf.ui.screens.BookDetailsScreen
import com.camihruiz24.bookshelf.ui.screens.BookDetailsViewModel
import com.camihruiz24.bookshelf.ui.screens.FavoritesList
import com.camihruiz24.bookshelf.ui.screens.HomeScreen
import com.camihruiz24.bookshelf.ui.screens.HomeViewModel

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
) {
    val startDestination: String = Route.ListScreen.route
    val navController: NavHostController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = Route.ListScreen.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(uiState = homeViewModel.uiState, retry = { homeViewModel.retry() }) { item ->
                /**
                 * Este composable (ListScreen) envía un argumento al composable Detail.
                 * El nombre del argumento (siendo opcional pues obligatorio no necesita nombre, no más un slash "/")
                 * en la ruta del transmisor debe corresponder con lo que acepta el composable receptor.
                 * Para argumentos nombrados, en lugar de / se pone ``?NombreArgumento=``, y se pone luego el nombre de dicho argumento.
                 * Por automatizar un poco, se ha creado una lista de nombres de argumentos en la clase [NavigationArg] para las pantallas
                 * que reciben argumentos.
                 */
                /**
                 * Este composable (ListScreen) envía un argumento al composable Detail.
                 * El nombre del argumento (siendo opcional pues obligatorio no necesita nombre, no más un slash "/")
                 * en la ruta del transmisor debe corresponder con lo que acepta el composable receptor.
                 * Para argumentos nombrados, en lugar de / se pone ``?NombreArgumento=``, y se pone luego el nombre de dicho argumento.
                 * Por automatizar un poco, se ha creado una lista de nombres de argumentos en la clase [NavigationArg] para las pantallas
                 * que reciben argumentos.
                 */
                navController.navigate(Route.Detail.createNavRoute(item.id))
            }
        }
        composable(
            route = Route.Detail.baseRoute + "?${NavigationArg.ID.key}={${NavigationArg.ID.key}}",
            arguments = Route.Detail.arguments
        ) { navBackStackEntry ->
            val detailsViewModel = hiltViewModel<BookDetailsViewModel>()
            BookDetailsScreen(
                uiState = detailsViewModel.uiState,
                retry = detailsViewModel::retry,
                onAddToFavorites = {
                    navController.navigate(Route.Favorites.route)
                }
            )
        }
        composable(
            route = Route.Favorites.baseRoute,
        ) {
            FavoritesList()
        }
    }
}
