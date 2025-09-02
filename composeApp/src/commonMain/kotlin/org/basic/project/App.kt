package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.basic.project.bottomBar.BottomBarScreen


@Composable
fun App() {
    MaterialTheme {
        Navigator(
            screen = MainScreen()
        )
    }
}

class MainScreen: Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        var name: String by remember { mutableStateOf("") }
        var surname: String by remember { mutableStateOf("") }

        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name,
                onValueChange = {
                    name = it
                }
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            AnimatedVisibility(name.isNotEmpty()) {
                Text(
                    text = "Version animada 1: $name",
                    fontSize = 20.sp
                )
            }

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            TextField(
                value = surname,
                onValueChange = {
                    surname = it
                }
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            AnimatedVisibility(surname.isNotEmpty()) {
                Text(
                    text = "Vesión animada 2: $surname",
                    fontSize = 20.sp
                )
            }
            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    navigator.push(SecondScreen())
                }
            ) {
                Text(
                    text = "navegando"
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    navigator.push(ThirdScreen())
                }
            ) {
                Text(
                    text = "navegar a tercera pantalla"
                )
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Button(
                onClick = {
                    navigator.push(BottomBarScreen())
                }
            ) {
                Text(
                    text = "Bottom Bar"
                )
            }
        }
    }
}

class SecondScreen: Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow

        Column (
            modifier = Modifier
                .background(Color.Red)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "segunda pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Volver"
                )
            }
        }
    }
}

class ThirdScreen: Screen {
    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "tercera pantalla",
                fontSize = 30.sp,
                color = Color.Blue
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "volver a la primera pantalla"
                )
            }
        }
    }
}