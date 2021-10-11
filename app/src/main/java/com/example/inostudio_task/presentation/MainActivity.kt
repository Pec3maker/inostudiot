package com.example.inostudio_task.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inostudio_task.presentation.film_list.FilmListScreen
import com.example.inostudio_task.presentation.film_review.FilmReviewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.FilmListScreen.route
                ) {
                    composable(
                        route = Screen.FilmListScreen.route
                    ) {
                        FilmListScreen(navController)
                    }
                    composable(
                        route = Screen.FilmReviewScreen.route + "/{movie_id}"
                    ) {
                        FilmReviewScreen()
                    }
                }
            }

        }
    }
}

