package com.example.instamart.Homepage.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instamart.Homepage.model.BottomBarItem

@Composable
fun HomepageNavigation(parentNavController : NavHostController , padding : PaddingValues){
    NavHost(navController = parentNavController, startDestination = BottomBarItem.HOME.name){
        composable(BottomBarItem.HOME.name){
            PagePreview(name = "Home", padding = padding)
        }
        composable(BottomBarItem.PROFILE.name){
            PagePreview(name = "Profile", padding = padding)
        }
        composable(BottomBarItem.EXPLORE.name){
            PagePreview(name = "explore", padding = padding)
        }
        composable(BottomBarItem.WISH_LIST.name){
            PagePreview(name = "Wish list", padding = padding)
        }
    }
}

@Composable
fun PagePreview(name : String , padding : PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = name )
    }
}