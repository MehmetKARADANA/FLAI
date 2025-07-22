package com.mobile.flai.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.flai.domain.FlightInfo

@Composable
fun FlightInfoCard(info: FlightInfo) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Yanıt: ${info.answer}")
            info.gate?.let { Text("Kapı: $it") }
            info.delayStatus?.let { Text("Rötar: $it") }
            info.boardingTime?.let { Text("Biniş Saati: $it") }
        }
    }
}
