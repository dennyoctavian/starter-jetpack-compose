package com.dennyoctavian.ppobsimscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dennyoctavian.ppobsimscompose.presentation.navigation.AppNavigation
import com.dennyoctavian.ppobsimscompose.ui.theme.PPOBSIMSComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPOBSIMSComposeTheme {
                AppNavigation()
            }
        }
    }
}
