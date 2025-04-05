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