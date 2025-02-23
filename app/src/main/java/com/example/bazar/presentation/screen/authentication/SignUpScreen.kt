package com.example.bazar.presentation.screen.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.presentation.common.BazarButton
import com.example.bazar.presentation.common.BazarIconButton
import com.example.bazar.presentation.common.SpacerHeight
import com.example.bazar.presentation.common.SpacerWidth
import com.example.bazar.presentation.common.BazarTextHeadline
import com.example.bazar.util.Dimen.ExtraLargeSpace
import com.example.bazar.util.Dimen.ExtraSmallSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun SignUpScreen() {
    SignUpContent()
}

@Composable
fun SignUpContent() {
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        SpacerHeight(ExtraLargeSpace)
        BazarIconButton (
            icon = R.drawable.icon_arrow_back,
            onClick = { TODO() }
        )
        SpacerHeight(SmallSpace)
        BazarTextHeadline (text = "Sign Up")
        SpacerHeight(SmallSpace)
        Text (
            text = "Create account and choose favorite name",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.secondary_text)
        )
        SpacerHeight(ExtraLargeSpace)
        Text (
            text = "Name",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.primary_text)
        )
        SpacerHeight(ExtraSmallSpace)
        OutlinedTextField (
            modifier = Modifier.fillMaxWidth().background(Color(0xFFF9F9F9)),
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Your name") },
            textStyle = TextStyle (
                color = Color.Black,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
        )
        SpacerHeight(SmallSpace)
        Text (
            text = "Email",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.primary_text)
        )
        SpacerHeight(ExtraSmallSpace)
        OutlinedTextField (
            modifier = Modifier.fillMaxWidth().background(Color(0xFFF9F9F9)),
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Your email") },
            textStyle = TextStyle (
                color = Color.Black,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )
        )
        SpacerHeight(SmallSpace)
        Text (
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.primary_text)
        )
        SpacerHeight(ExtraSmallSpace)
        OutlinedTextField (
            modifier = Modifier.fillMaxWidth().background(Color(0xFFF9F9F9)),
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Your password") },
            textStyle = TextStyle (
                color = Color.Black,
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            ),
            trailingIcon = {
//                BazarIconButton (
//                    icon = R.drawable.password_seen,
//                    onClick = {  }
//                )
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors (
                focusedContainerColor = Color(0xFFFAFAFA),
                unfocusedContainerColor = Color(0xFFFAFAFA),
            )
        )
        SpacerHeight(ExtraLargeSpace)
        BazarButton (
            text = "Register",
            onClick = { TODO() }
        )
        SpacerHeight(ExtraLargeSpace)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = "Have an account?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.secondary_text)
            )
            SpacerWidth(ExtraSmallSpace)
            Text (
                text = "Sign In",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.primary_color)
            )
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text (
                text = "By clicking Register, you agree to our",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.secondary_text)
            )
            Text (
                text = "Terms and Data Policy.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.primary_color)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    SignUpScreen()
}