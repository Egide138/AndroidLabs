package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                    Myapp("Android")
                }
        }
    }
}

@Composable
fun Myapp(name2: String) {
    var myphoto by remember { mutableStateOf(false) }
    var name1 by remember { mutableStateOf(value = "") }
    var name by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(start = 10.dp)) {
        Mytextfield(name = name, changed = {name=it})
        Mybutton({
            name1=name
            myphoto=!myphoto
        })
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
       // displayImage()
        if(myphoto)
        {
            displayImage(R.drawable.image2)
        }
        else
        {
            displayImage(R.drawable.egide)
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        showText(name1)

    }
    }
@Composable
fun Mybutton(clicked: ()->Unit)
{
    Button(onClick = clicked)
    {
        Text(stringResource(id = R.string.button))
    }
}



@Composable
fun Mytextfield(name:String,changed :(String)->Unit) {
    Column() {
        OutlinedTextField(
            value = name,
            onValueChange = changed,
            label = { Text(text = stringResource(id = R.string.label)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 10.dp, bottom = 2.dp)
        )
    }
}
@Composable
fun displayImage(photo: Int)
{
    Surface(modifier = Modifier.padding(start = 75.dp)) {
        Image(painter = painterResource(id = photo) , contentDescription = stringResource(
            id = R.string.photo
        ), modifier = Modifier
            .clip(CircleShape)
            .size(150.dp))
    }
}
@Composable
fun showText(newText:String)
{
    Surface(modifier = Modifier
        .background(color = Color.Blue)
        .padding(horizontal = 10.dp, vertical = 10.dp))
    {
        Text(
            stringResource(id = R.string.outputText)+" "+newText,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab2Theme {
        Myapp("Android")
    }
}