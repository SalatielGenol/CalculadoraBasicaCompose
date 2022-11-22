package es.genol.empezandocompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/*
Composable que define el pulsador y al que se le puede modificar el color de fondo, del texto,
el propio texto, y se le puede pasar un modificador completo si fuese necesario.
 */

@Composable
fun Pulsador(
    simbolo: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Yellow,
    colorFuente: Color = Color.Black,
    onClick: () -> Unit //Evento al que se le pasará una lambda
){
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(30))
        .background(color)
        .clickable { onClick() }
        .then(modifier),
        contentAlignment = Alignment.Center) {
        Text(
            text = simbolo,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            color = colorFuente
        )
    }
}