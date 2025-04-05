package com.example.techexactly.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.techexactly.model.dataclass.User
import com.example.techexactly.view.home.HomeScreen
import com.example.techexactly.view.user.UserDetailsScreen
import kotlin.reflect.typeOf


/**
 * Sets up the navigation graph for the application.
 *
 * This function defines the composable structure for navigating between different screens in the app.
 * It uses a [NavHost] to manage the navigation stack and defines routes for the [HomeScreen] and
 * [UserDetailsScreen].
 *
 * @param navController The [NavHostController] responsible for managing navigation within the app.  This controller
 *                      is typically created in the main activity or a higher-level composable and passed down to this function.
 */
@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController, startDestination = Dest.HomeScreen
    ) {
        composable<Dest.HomeScreen> {
            HomeScreen(
                onUserClicked = { user ->
                    navController.navigate(Dest.UserDetailsScreen(user))
                })
        }
        composable<Dest.UserDetailsScreen>(
            typeMap = mapOf(
                typeOf<User>() to CustomNavType.UserType
            )
        ) {
            val args = it.toRoute<Dest.UserDetailsScreen>()
            UserDetailsScreen(
                user = args.user, onBackClicked = { navController.popBackStack() })
        }
    }
}