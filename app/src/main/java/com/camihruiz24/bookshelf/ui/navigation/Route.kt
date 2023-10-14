package com.camihruiz24.bookshelf.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

enum class NavigationArg(val key: String, val navType: NavType<*>, val defaultValue: Any) {
    // Solamente la pantalla de Detail tiene un argumento que es el ID del item
    ID(key = "itemId", navType = NavType.StringType, defaultValue = "C1MI_4nZyD4C"); // TODO: Extraer el valor por defecto para que sea parametrizable
}

sealed class Route(
    val baseRoute: String,
    private val navigationArgs: List<NavigationArg> = emptyList(),
) {

    // Constructor of default navigation arguments
    val route : String = run {
        val argKeys = navigationArgs.map {
            it.key
        }
        listOf(baseRoute)
            .plus("{$argKeys}=$argKeys")
            .joinToString("?")
    }

    val arguments : List<NamedNavArgument> = navigationArgs.map {
        navArgument(it.key) {
            type = it.navType
            defaultValue = it.defaultValue
        }
    }

    data object ListScreen : Route(baseRoute = "list")

    data object Detail : Route(baseRoute = "detail", listOf(NavigationArg.ID)){
        fun createNavRoute(itemId: String) = "$baseRoute?${NavigationArg.ID.key}=$itemId"
    }

    data object Favorites: Route(baseRoute = "favorites")
}