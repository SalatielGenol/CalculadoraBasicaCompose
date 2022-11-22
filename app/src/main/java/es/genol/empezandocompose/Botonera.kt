package es.genol.empezandocompose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.genol.empezandocompose.ui.theme.OrangeMine
import kotlin.system.exitProcess

/*
Composable que crea una columna de varias filas donde se generan los diferentes pulsadores de
la calculadora, pasándole los parámetros necesarios.

La función recibe una lambda a la que devuelve un string. En este caso, el símbolo del pulsador.
 */

@Composable
fun Botonera(accionPulsar: (String) -> Unit){
    val simple = 1f
    val doble = 2f
    val colorOperandos = Color.LightGray
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Pulsador(
                simbolo = "OFF",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = Color.Black,
                colorFuente = Color.Yellow
            ) {
                val activity = MainActivity()
                activity.finish()
                exitProcess(0)
            }
            Pulsador(
                simbolo = "DEL",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = Color.Blue
            ) { accionPulsar("DEL") }
            Pulsador(
                simbolo = "AC",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = Color.Red
            ) { accionPulsar("AC") }
            Pulsador(
                simbolo = "÷",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = colorOperandos
            ) { accionPulsar("÷") }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Pulsador(
                simbolo = "7",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("7") }
            Pulsador(
                simbolo = "8",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("8") }
            Pulsador(
                simbolo = "9",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                    /*.aspectRatio(simple),*/
            ) { accionPulsar("9") }
            Pulsador(
                simbolo = "×",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = colorOperandos
            ) { accionPulsar("×") }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Pulsador(
                simbolo = "4",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("4") }
            Pulsador(
                simbolo = "5",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("5") }
            Pulsador(
                simbolo = "6",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("6") }
            Pulsador(
                simbolo = "-",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = colorOperandos
            ) { accionPulsar("-") }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Pulsador(
                simbolo = "1",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("1") }
            Pulsador(
                simbolo = "2",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("2") }
            Pulsador(
                simbolo = "3",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("3") }
            Pulsador(
                simbolo = "+",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
                color = colorOperandos
            ) { accionPulsar("+") }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Pulsador(
                simbolo = "0",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar("0") }
            Pulsador(
                simbolo = ".",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(simple),
            ) { accionPulsar(".") }
            Pulsador(
                simbolo = "=",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(doble),
                color = OrangeMine
            ) { accionPulsar("=") }
        }
    }
}