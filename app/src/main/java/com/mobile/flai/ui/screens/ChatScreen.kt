package com.mobile.flai.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import com.mobile.flai.ui.components.FlightInfoCard
import com.mobile.flai.viewmodels.ChatViewModel
//fun ChatScreen(viewModel: ChatViewModel = hiltViewModel()) {
@Composable
fun ChatScreen(viewModel: ChatViewModel) {
    val context = LocalContext.current
    var query by remember { mutableStateOf("") }
    val flightInfo = viewModel.state

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Uçuşla ilgili sorunuzu yazın") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Button(onClick = { viewModel.onQuerySubmit(query) }) {
            Text("Gönder")
        }

        Spacer(Modifier.height(16.dp))
        flightInfo?.let {
            FlightInfoCard(info = it)
        }
    }
}
