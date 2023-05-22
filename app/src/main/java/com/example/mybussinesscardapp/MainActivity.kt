package com.example.mybussinesscardapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybussinesscardapp.ui.theme.MyBussinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBussinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val logo = painterResource(id = R.drawable.artboard_6100)
    val background = painterResource(id = R.drawable.off_white_paper_texture_useful_as_background_off_white_paper_texture_background_116758334)

    Box(modifier.fillMaxSize()) {
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = logo,
                contentDescription = "Logo",
                modifier = Modifier
                    .size(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tuong Pham",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "FPV Drone Pilot",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            ContactInfoItem(
                icon = painterResource(id = R.drawable.ic_phone),
                text = "+1 205-532-6730"
            )

            ContactInfoItem(
                icon = painterResource(id = R.drawable.ic_instagram),
                text = "@troypham_"
            )

            ContactInfoItem(
                icon = painterResource(id = R.drawable.ic_email),
                text = "phamminhtuong@yahoo.com"
            )
        }
    }
}

@Composable
fun ContactInfoItem(icon: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyBussinessCardAppTheme {
        BusinessCard()
    }
}


