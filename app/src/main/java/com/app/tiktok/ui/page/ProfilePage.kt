package com.app.tiktok.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.tiktok.R

@Composable
fun ProfilScreen() {
    Column(
        Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        TopAppBar(name = "Aryo Wibisono")
        Spacer(modifier = Modifier.height(15.dp))
        PhotoUser(imageUser = painterResource(id = R.drawable.aryo_fix), "@aryo_dedeo")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            informasiSection(count = "16", text = "Mengikuti")
            informasiSection(count = "899,20k", text = "Pengikut")
            informasiSection(count = "200M", text = "Suka")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth() // Make the Row take up the full width of the screen
                .padding(end = 5.dp),
            horizontalArrangement = Arrangement.Center, // Center the content horizontally
            verticalAlignment = Alignment.CenterVertically // Align the content vertically in the center
        ) {
            ButtonFollow(initialColor = Color.Red)
            Spacer(modifier = Modifier.width(8.dp)) // Optional: add some space between buttons
            ButtonTT()
            Spacer(modifier = Modifier.width(8.dp)) // Optional: add some space between buttons
            ButtonDropDown()
        }
        Spacer(modifier = Modifier.height(5.dp))
        BioSection(bio = "Hallo nama saya aryo\n" +
                "ini cuma akun gabur hehe")

    }
}

@Composable
fun TopAppBar(name: String) {
    val fontStyle = FontFamily.SansSerif
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back"
        )
        Box(modifier = Modifier.background(Color.Transparent))
        Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp, fontFamily = fontStyle)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "notif"
            )
            Spacer(
                modifier = Modifier
                    .width(15.dp)
                    .height(5.dp)
            )
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "share"
            )
        }
    }
}

@Composable
fun PhotoUser(imageUser: Painter, username: String) {
    val fontStyle = FontFamily.SansSerif
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imageUser,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(130.dp)
                .border(1.dp, Color.Transparent)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = username,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontStyle
        )
    }
}

@Composable
fun informasiSection(count: String, text: String) {
    val fontStyle = FontFamily.SansSerif
    Row(
        modifier = Modifier.padding(end = 25.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = count,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = fontStyle
            )
            Text(
                text = text,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = fontStyle
            )
        }
    }
}

@Composable
fun ButtonFollow(initialColor: Color) {
    val fontStyle = FontFamily.SansSerif
    var colorState by remember { mutableStateOf(initialColor) }
    var text by remember { mutableStateOf("Follow") }
    var textColor by remember { mutableStateOf(Color.White) }
    Button(
        onClick = {
            colorState = Color.LightGray
            text = " Followed"
            textColor= Color.Black
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorState
        ), modifier = Modifier.padding(5.dp)
    ) {
        Text(text = text, color = textColor, fontFamily = fontStyle)
    }
}

@Composable
fun ButtonTT() {
    val fontStyle = FontFamily.SansSerif
    var text by remember { mutableStateOf("Message") }

    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray
        ), modifier = Modifier.padding(5.dp)
    ) {
        Text(text = text, color = Color.Black, fontFamily = fontStyle)
    }
}

@Composable
fun ButtonDropDown() {
    Button(
        onClick = { }, Modifier.width(60.dp), colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray
        )
    ) {
        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Black)
    }
}

@Composable
fun BioSection(bio:String){
    val fontStyle = FontFamily.SansSerif
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()){
        Text(text = bio, fontWeight = FontWeight.Normal, fontFamily = fontStyle, textAlign = TextAlign.Center, fontSize = 14.sp)
    }
}





