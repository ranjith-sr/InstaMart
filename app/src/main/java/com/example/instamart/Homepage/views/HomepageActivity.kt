package com.example.instamart.Homepage.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.instamart.Homepage.HomepageViewModel
import com.example.instamart.Homepage.model.BottomBarItem
import com.example.instamart.ui.theme.InstaMartTheme

class HomepageActivity : ComponentActivity() {
    val homepageViewModel : HomepageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaMartTheme {
                val parentNavController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize() ,
                    bottomBar = {
                        BottomBar(
                            bottomBarInfo = homepageViewModel.bottomBarInfo ,
                            currentItem = homepageViewModel.currentItem
                        ){ barItem ->
                            homepageViewModel.currentItem = barItem
                            parentNavController.popBackStack(BottomBarItem.HOME.name , false)
                            if(barItem == BottomBarItem.HOME) return@BottomBar
                            parentNavController.navigate(barItem.name)
                        }
                    }
                ) { innerPadding ->
                    HomepageNavigation( parentNavController , innerPadding)
                }
            }
        }
    }
}