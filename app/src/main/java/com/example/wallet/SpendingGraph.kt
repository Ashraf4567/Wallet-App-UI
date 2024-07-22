package com.example.wallet

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Composable
fun SpendingGraph(
    modifier: Modifier
) {
    Text(
        modifier = Modifier.padding(horizontal =  22.dp),
        text = "Spending Statistics",
        fontFamily = Font(R.font.play).toFontFamily(),
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(16.dp))

    Chart(modifier = modifier)
}

@Composable
fun Chart(modifier: Modifier) {
    BarChart(
        modifier = modifier,
        barChartData = BarChartData(spendingByDay),
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            labelValueFormatter = { "${it.toInt()}" },
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
        ),
        labelDrawer = SimpleLabelDrawer(
            drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
            labelTextSize = 10.sp,
        )
    )
}

val spendingByDay = listOf(
    BarChartData.Bar(
        label = "Dec 1",
        value = 130f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 2",
        value = 150f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 3",
        value = 200f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 4",
        value = 50f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 5",
        value = 400f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Dec 6",
        value = 350f,
        color = randomColor(50)
    ),
)