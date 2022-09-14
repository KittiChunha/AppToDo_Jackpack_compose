package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapp.domain.util.Routes
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.presentation.add_edit_todo.AddEditToDoScreen
import com.example.todoapp.presentation.todo_list.ToDoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.TODO_LIST,
                ) {
                    composable(Routes.TODO_LIST) {
                        ToDoListScreen(onNavigate = {
                            navController.navigate(it.route)
                        })
                    }
                    composable(
                        Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                        listOf(
                            navArgument(name = "todoId") {
                                type = NavType.StringType
                                defaultValue = ""
                            }
                        )
                    ) {
                        AddEditToDoScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}
