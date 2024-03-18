package com.example.savera.Screens.homeScreen

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.savera.Components.mainContent
import com.example.savera.Navigation.mainScreenNavigation.mainScreen

@Composable
fun homeScreen(selectindex: MutableIntState, mainscreennav: NavHostController, homeScreenViewModel: HomeScreenViewModel = viewModel()) {

    val showDialog by homeScreenViewModel.showDialogState.collectAsState(initial = false)
    val userInput by homeScreenViewModel.userInputState.collectAsState(initial = "")
    LaunchedEffect(Unit) {
        homeScreenViewModel.checkYearInformation()
    }
    BackHandler {
        selectindex.value = 2
       mainscreennav.navigate(route = mainScreen.Dashboard.name)
    }

    val selectIndex = remember { mutableIntStateOf(0) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { homeScreenViewModel.onDialogDismiss() },
            title = { Text(text = "What's your year") },
            text = {
                TextField(
                    value = userInput, // Use the actual value
                    onValueChange = { homeScreenViewModel.onUserInputChange(it) },
                    label = { Text(text = "Year") }
                )
            },
            confirmButton = {
                Button(onClick = {
                    val enteredYear = userInput.toIntOrNull() // Get and validate year
                    if (enteredYear != null) {
                        homeScreenViewModel.onYearEntered(enteredYear) // Pass year to ViewModel
                    } else {
                        // Handle invalid year input (e.g., show error message)

                    }
                }) {
                    Text(text = "OK")
                }
            }
        )
    }

    mainContent()

}