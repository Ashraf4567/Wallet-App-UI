package com.example.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {

    Text(
        modifier = Modifier.padding(horizontal =  22.dp),
        text = "Spending Breakdown",
        fontFamily = Font(R.font.play).toFontFamily(),
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))

    SpendingList(modifier)
}

@Composable
fun SpendingList(modifier: Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        itemsIndexed(spendingItems){index, item ->
            SpendingItem(spendingItem = item)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun SpendingItem(modifier: Modifier = Modifier , spendingItem: SpendingItem) {
    ElevatedCard(
        modifier = modifier
            .size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .background(spendingItem.color)
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = spendingItem.icon),
                contentDescription = "Icon",
                tint = Color.Black.copy(alpha = 0.8f),
                modifier = Modifier.size(33.dp)
            )
            Text(
                text = spendingItem.name,
                color = Color.Black.copy(alpha = 0.8f),
                fontSize = 15.sp,
                fontFamily = Font(R.font.play).toFontFamily()
            )
            Text(
                text = spendingItem.amount.toString(),
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = Font(R.font.play).toFontFamily(),
                fontWeight = FontWeight.Bold
            )

        }

    }
}

val spendingItems = listOf(
    SpendingItem(
        name = "Food",
        amount = 123f,
        color = randomColor(),
        icon = R.drawable.ic_restaurant
    ),
    SpendingItem(
        name = "Shopping",
        amount = 166f,
        color = randomColor(),
        icon = R.drawable.baseline_shopping_bag_24
    ),
    SpendingItem(
        name = "Subscriptions",
        amount = 84f,
        color = randomColor(),
        icon = R.drawable.round_airplay_24
    ),
    SpendingItem(
        name = "Health",
        amount = 140f,
        color = randomColor(),
        icon = R.drawable.baseline_directions_run_24
    )
)

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: Int
)