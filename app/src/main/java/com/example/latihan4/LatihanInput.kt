package com.example.latihan4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJK by remember { mutableStateOf("") }

    var Nama by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var NoTelepon by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var Jenis by remember { mutableStateOf("") }


    val listJK = listOf("Laki-Laki", "Perempuan")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Biodata",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama")},
            placeholder = { Text("Masukkan Nama Anda")}
        )

        Row {
            listJK.forEach { item ->
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = memilihJK == item,
                            onClick = {
                                memilihJK = item
                            }
                        )

                        Text(item)
                    }
            }
        }

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("Email")},
            placeholder = { Text("Masukkan Email Anda")}
        )

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = noTelepon,
            onValueChange = {noTelepon = it},
            label = { Text("No Telepon")},
            placeholder = { Text("Masukkan No Telepon Anda")}
        )

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukkan Alamat Anda")}
        )

        Button(onClick = {
            Nama = nama
            Email = email
            NoTelepon = noTelepon
            Alamat = alamat
            Jenis = memilihJK
        }) {
            Text(text = "Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
            .fillMaxWidth()
            ) {
            DetailSurat(judul = "Nama", isi = Nama)
            DetailSurat(judul = "Email", isi = Email)
            DetailSurat(judul = "No Telepon", isi = NoTelepon)
            DetailSurat(judul = "Alamat", isi = Alamat)
            DetailSurat(judul = "Jenis Kelamin", isi = Jenis)
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isi: String
) {


        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)

        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isi,
                modifier = Modifier.weight(2f))
        }
    }
