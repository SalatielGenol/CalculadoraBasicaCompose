package es.genol.empezandocompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
Composable que imita un display de una calculadora con dos lineas de texto con diferentes
tamaños.
 */

@Composable
fun Display(historico: String, numActual: String){

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20))
            .background(Color.DarkGray)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        val separacion = 15.dp
        Text(text = historico,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(end = separacion))
        Text(
            text = numActual,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 50.sp,
            color = Color.White,
            modifier = Modifier.padding(end = separacion)
        )
    }
}