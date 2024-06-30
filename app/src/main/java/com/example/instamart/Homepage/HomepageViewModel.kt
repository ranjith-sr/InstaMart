package com.example.instamart.Homepage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.instamart.Homepage.model.BottomBarInfo
import com.example.instamart.Homepage.model.BottomBarItem
import com.example.instamart.R

class HomepageViewModel : ViewModel() {
    val bottomBarInfo = listOf(
        BottomBarInfo( BottomBarItem.HOME , R.drawable.home),
        BottomBarInfo( BottomBarItem.EXPLORE , R.drawable.explorer),
        BottomBarInfo( BottomBarItem.WISH_LIST , R.drawable.heart),
        BottomBarInfo( BottomBarItem.PROFILE , R.drawable.profile),
    )
    var currentItem by mutableStateOf(BottomBarItem.HOME)
}