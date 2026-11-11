package com.example.listcompose

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.listcompose.navigation.AppNavHost
import com.example.listcompose.ui.theme.ListComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListComposeTheme {
                AppNavHost()
            }
        }
    }
}