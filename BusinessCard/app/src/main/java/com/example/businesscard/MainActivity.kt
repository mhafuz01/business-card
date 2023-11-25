package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.business_bg_color)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier.background(colorResource(id = R.color.business_bg_color))
    ) {
        BasicInfo(
            img = painterResource(id = R.drawable.ic_account_100),
            name = "Nafi Mhafuz",
            title = "Android App Dev"
        )
        ContactInfo(
            phone = "01302674163",
            domain = "@AndroidDev",
            email = "ssnake485@gmail.com",
            modifier = Modifier.align(Alignment.CenterStart)
        )
    }
}

@Composable
fun BasicInfo(img: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        Image(
            painter = img,
            contentDescription = null,
        )
        Text(
            text = name,
            fontSize = 48.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInfo(phone: String, domain: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)

    ) {
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = null,
                tint = colorResource(id = R.color.icon_color)
            )
            Text(
                text = phone,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = null,
                tint = colorResource(id = R.color.icon_color)
            )
            Text(
                text = domain,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = colorResource(id = R.color.icon_color)
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}