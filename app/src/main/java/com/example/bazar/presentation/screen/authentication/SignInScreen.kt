package com.example.bazar.presentation.screen.authentication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.bazar.util.Dimen.LargeSpace
import com.example.bazar.util.Dimen.MediumSpace
import com.example.bazar.util.Dimen.SmallSpace

@Composable
fun SignInScreen() {
    SignInContent()
}

@Composable
fun SignInContent () {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MediumSpace)
    ) {
        SpacerHeight(ExtraLargeSpace)
        BazarIconButton (
            icon = R.drawable.icon_arrow_back,
            onClick = { TODO() }
        )
        SpacerHeight(8.dp)
        BazarTextHeadline (text = "Welcome Back👋")
        SpacerHeight(8.dp)
        Text (
            text = "Sign to your account",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.secondary_text)
        )
        SpacerHeight(ExtraLargeSpace)
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
        SpacerHeight(LargeSpace)
        Text (
            text = "Forgot Password?",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.primary_color)
        )
        SpacerHeight(ExtraLargeSpace)
        BazarButton (
            text = "Login",
            onClick = { TODO() }
        )
        SpacerHeight(ExtraLargeSpace)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = "Don't have an account?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.secondary_text)
            )
            SpacerWidth(ExtraSmallSpace)
            Text (
                text = "Sign Up",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.primary_color)
            )
        }
        SpacerHeight(ExtraLargeSpace)
        Text (
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Or with",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
        SpacerHeight(ExtraLargeSpace)
        Button (
            modifier = Modifier.fillMaxWidth(),
            onClick = { TODO() },
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(14.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
//            Icon (
//                modifier = Modifier.size(LargeSpace),
//                painter = painterResource(R.drawable.ic_google),
//                contentDescription = "Google",
//                tint = Color.Unspecified
//            )
            SpacerWidth(MediumSpace)
            Text (
                text = "Sign in with Google",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.secondary_text)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignInScreenPreview() {
    SignInScreen()
}