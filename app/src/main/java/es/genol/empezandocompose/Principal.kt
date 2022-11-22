package es.genol.empezandocompose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

/*
Clase principal del programa, donde se inicializan todos los componentes, y se realizan algunas
operaciones simples mediante estados mutables y funciones personalizadas.

La orientación del dispositivo modifica los margenes para que se vea decentemente en cualquier
situación.

La lógica de programación es muy rudimentaria, es algo que he de mejorar.
 */

val numActualSB = StringBuilder()
val numHistoricoSB = StringBuilder()
var operador : Char = ' '
var huboResultado = false

@Composable
fun Principal() {
    var numHistorico by rememberSaveable{ mutableStateOf( "" ) }
    var numActual by rememberSaveable{ mutableStateOf( "" ) }
    val configuration = LocalConfiguration.current

    val modificador: Modifier = when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Modifier.padding(all = 0.dp)
        }
        else -> {
            Modifier.padding(start = 8.dp, end = 8.dp, top = 50.dp, bottom = 50.dp)

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modificador)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Display(historico = numHistorico, numActual = numActual)
            Botonera(accionPulsar = {
                numActual = operacion(pulsador = it)
                numHistorico = historico()
            })
        }
    }
}

fun operacion(pulsador: String): String {
    when (pulsador) {
        "+" -> sumar()
        "-" -> restar()
        "×" -> multiplicar()
        "÷" -> dividir()
        "." -> numActualSB.append(pulsador)
        "=" -> resultado()
        "DEL" -> if (numActualSB.isNotEmpty()) numActualSB.deleteCharAt(numActualSB.lastIndex)
        "AC" -> {
            numActualSB.clear()
            numHistoricoSB.clear()
        }
        else ->  {
            if (huboResultado) {
                numActualSB.clear()
                numActualSB.append(pulsador)
                huboResultado = false
            }else{
                numActualSB.append(pulsador)
            }
        }
    }

    return numActualSB.toString()
}

fun sumar() {
    if (numHistoricoSB.isBlank()) {
        numHistoricoSB.append(numActualSB.toString())
        numActualSB.clear()
        operador = '+'
    }
}

fun restar() {
    if (numHistoricoSB.isBlank()) {
        numHistoricoSB.append(numActualSB.toString())
        numActualSB.clear()
        operador = '-'
    }
}

fun multiplicar() {
    if (numHistoricoSB.isBlank()) {
        numHistoricoSB.append(numActualSB.toString())
        numActualSB.clear()
        operador = '×'
    }
}

fun dividir() {
    if (numHistoricoSB.isBlank()) {
        numHistoricoSB.append(numActualSB.toString())
        numActualSB.clear()
        operador = '÷'
    }
}

fun resultado() {
    var resultado = 0

    if (numActualSB.isNotBlank() && numHistoricoSB.isNotBlank()) {
        when (operador) {
            '+' -> resultado = numHistoricoSB.toString().toInt() + numActualSB.toString().toInt()
            '-' -> resultado = numHistoricoSB.toString().toInt() - numActualSB.toString().toInt()
            '×' -> resultado = numHistoricoSB.toString().toInt() * numActualSB.toString().toInt()
            '÷' -> resultado = numHistoricoSB.toString().toInt() / numActualSB.toString().toInt()
        }
    }

    numHistoricoSB.clear()
    numActualSB.clear()
    huboResultado = true
    numActualSB.append(resultado)
}

fun historico(): String {
    return numHistoricoSB.toString()
}