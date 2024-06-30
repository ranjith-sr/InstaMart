package com.example.instamart.Homepage.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instamart.Homepage.model.BottomBarInfo
import com.example.instamart.Homepage.model.BottomBarItem

@Composable
fun  BottomBar(bottomBarInfo: List<BottomBarInfo> , currentItem : BottomBarItem , onClick: (BottomBarItem) -> Unit){
    BottomAppBar (
        containerColor = Color.Transparent,
        modifier = Modifier.height(80.dp),
        contentColor = Color.Gray
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            bottomBarInfo.forEach { barInfo->
                BottomAction(bottomBarInfo = barInfo , currentItem){ barItem->
                    onClick(barItem)
                }
            }
        }
    }
}

@Composable
fun BottomAction( bottomBarInfo: BottomBarInfo , currentItem : BottomBarItem , onClick :(BottomBarItem)->Unit) {
    val tint = if(currentItem == bottomBarInfo.item) Color.Blue else MaterialTheme.colorScheme.primary
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            onClick(bottomBarInfo.item)
        }
    ) {
        Icon(
            painter = painterResource(id = bottomBarInfo.painter),
            contentDescription = "Icon",
            modifier = Modifier.size(23.dp),
            tint = tint
        )
        Text(
            text = bottomBarInfo.item.getName() ,
            fontSize = 12.sp ,
            color = tint
        )
    }
}