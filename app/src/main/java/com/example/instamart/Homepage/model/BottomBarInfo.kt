package com.example.instamart.Homepage.model

data class BottomBarInfo(
    var item : BottomBarItem ,
    var painter: Int
)

enum class BottomBarItem{
    HOME , EXPLORE , WISH_LIST , PROFILE;
    fun getName() : String {
        return when(this){
            HOME->"Home"
            EXPLORE-> "Explore"
            WISH_LIST-> "WishList"
            PROFILE-> "Profile"
        }
    }
}
