package com.example.ontapkt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ontapkt.ui.theme.OnTapKTTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController
) {
    var full_name by remember {
        mutableStateOf("")
    }
    var thong_bao by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var user_name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.padding(5.dp),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Lê Hữu Thành - 0306211292",
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )
        })
    { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(painter = painterResource(id = R.drawable.logotruong), contentDescription = null, modifier = Modifier.size(70.dp))
            Text(
                text = "ĐĂNG KÝ TÀI KHOẢN",
                style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )
            Text(thong_bao, textAlign = TextAlign.Center)
            OutlinedTextField(value = full_name,
                onValueChange = {full_name=it},
                modifier = Modifier.padding(top=15.dp),
                label = { Text(text = "FULL NAME", textAlign = TextAlign.Center) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                trailingIcon = { Icon(imageVector = Icons.Rounded.Person, contentDescription = null)}
            )
            OutlinedTextField(value = phone,
                onValueChange = {phone=it},
                modifier = Modifier.padding(top=15.dp),
                label = { Text(text = "PHONE", textAlign = TextAlign.Center) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = { Icon(imageVector = Icons.Rounded.Phone,contentDescription = null)}
            )
            OutlinedTextField(value = user_name,
                onValueChange = {user_name=it},
                modifier = Modifier.padding(top=15.dp),
                label = { Text(text = "USER NAME", textAlign = TextAlign.Center) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                trailingIcon = { Icon(imageVector = Icons.Rounded.Person, contentDescription = null)}
            )
            OutlinedTextField(
                value = password,
                onValueChange = {password=it},
                modifier = Modifier.padding(top=15.dp),
                label = { Text(text = "PASSWORD", textAlign = TextAlign.Center) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = { Icon(imageVector = Icons.Rounded.Lock, contentDescription = null)}
            )
            Button(onClick = {
                if(full_name.isEmpty()||phone.isEmpty()||user_name.isEmpty()||password.isEmpty())
                    thong_bao="Bạn chưa nhập đầy đủ thông tin"
                else if(password.length>7) {
                    thong_bao = "Đăng ký thành công"
                    navController.navigate(Screen.Login.route)
                }},
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Blue
            ),){
                Text(text = "Đăng ký")
            }

            
        }
    }
}