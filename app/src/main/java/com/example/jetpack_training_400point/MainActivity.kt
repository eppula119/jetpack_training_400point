package com.example.jetpack_training_400point

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.jetpack_training_400point.ui.theme.Jetpack_training_400pointTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_training_400pointTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(0.dp, 0.dp, 0.dp, 30.dp)
                    ){
                        Text(
                                "目指せ400点!!",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = Color(0xF237C2EC))
                                    .padding(
                                        0.dp, 15.dp
                                    ),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        
                        Image(
                            painter = painterResource(id = R.drawable.zoro),
                            contentDescription = viewModel.showText,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(150.dp)
                                .align(Alignment.CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            viewModel.showText,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xF237C2EC),
                        )

                        Column(
                            modifier = Modifier.padding( 15.dp, 0.dp )
                        ) {
                            // 国語
                            subjectTextField(
                                value = viewModel.japanese,
                                onValueChange = { viewModel.japanese = it },
                                label = "国語",
                                placeholder = "40",
                            )

                            // 算数
                            subjectTextField(
                                value = viewModel.mathematics,
                                onValueChange = {viewModel.mathematics = it },
                                label = "算数",
                                placeholder = "80",
                            )

                            // 理科
                            subjectTextField(
                                value = viewModel.science,
                                onValueChange = { viewModel.science = it },
                                label = "理科",
                                placeholder = "90",
                            )

                            // 社会
                            subjectTextField(
                                value = viewModel.socialStudies,
                                onValueChange = { viewModel.socialStudies = it },
                                label = "社会",
                                placeholder = "50",
                            )
                            
                            Spacer(modifier = Modifier.height(50.dp))
                            
                            // 結果表示ボタン
                            Button(
                                onClick = {
                                    viewModel.subjectTotalAmount()
                                          },
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(0xF237C2EC),
                                    contentColor = Color.White,
                                ),
                                contentPadding = PaddingValues(
                                    start = 60.dp,
                                    top = 30.dp,
                                    end = 60.dp,
                                    bottom = 30.dp
                                ),
                                shape = RoundedCornerShape(100.dp),
                            ) {
                                Text(
                                    text = "結果を見る",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }


                    }



                }
            }
        }
    }
}

@Composable
fun subjectTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String
){
    Spacer(modifier = Modifier.height(30.dp))
    // 国語
    Text(
        label,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xF2A09F9F))
            .padding(10.dp, 10.dp, 0.dp, 10.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
    )
    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xF22577DD),
            unfocusedBorderColor = Color(0xF237C2EC)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}
