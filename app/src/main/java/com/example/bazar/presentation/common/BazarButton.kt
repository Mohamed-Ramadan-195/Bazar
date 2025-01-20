package com.example.bazar.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazar.R
import com.example.bazar.util.Dimen.ExtraLargeSpace
import com.example.bazar.util.Dimen.MediumSpace

@Composable
fun BazarButton (
    text: String,
    onClick: () -> Unit
) {
    Button (
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(size = ExtraLargeSpace),
        contentPadding = PaddingValues(all = MediumSpace),
        colors = ButtonDefaults.buttonColors (
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        )
    ) {
        Text (
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BazarTextButton (
    text: String,
    onClick: () -> Unit
) {
    TextButton (
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        contentPadding = PaddingValues(all = 10.dp)
    ) {
        Text (
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.secondary_text)
        )
    }
}

@Composable
fun BazarIconButton (
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    IconButton (
        onClick = onClick
    ) {
        Icon (
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Composable
@Preview(showBackground = true, name = "button")
fun BazarButtonPreview() {
    BazarButton(
        text = "Continue",
        onClick = {}
    )
}

@Composable
@Preview(showBackground = true, name = "text button")
fun BazarTextButtonPreview() {
    BazarTextButton (
        text = "Sign in",
        onClick = {}
    )
}