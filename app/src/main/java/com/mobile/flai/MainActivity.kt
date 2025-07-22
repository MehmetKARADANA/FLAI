package com.mobile.flai

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.mobile.flai.ui.screens.ChatScreen
import com.mobile.flai.ui.theme.FlaiTheme
import com.mobile.flai.viewmodels.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


sealed class DestinationScreen(var route: String) {
    data object chatScreen : DestinationScreen("chat")
}

@HiltAndroidApp
class ThyAssistantApp : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlaiTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    fun AppNavigation() {

        val navController = rememberNavController()
        val chatViewModel  : ChatViewModel = hiltViewModel()


        NavHost(
            navController = navController,
            startDestination = DestinationScreen.chatScreen.route
        ) {

            composable(DestinationScreen.chatScreen.route) {
                ChatScreen(chatViewModel)
            }
        }

    }

}
