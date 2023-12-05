package com.example.lista3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lista3.ui.theme.Lista3Theme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {

    private var questionCounter by mutableStateOf(false)
    private var corectCounter by mutableStateOf(0)

    var selectedOption = ""

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            Lista3Theme {
                if (questionCounter == false) {
                    mainComposable(
                        selectedOption,
                        onNextQuestion = {
                            questionCounter = true
                            // println("questionNumber: $questionCounter")
                        },
                        funkcja2 = {
                            corectCounter++
                            println(corectCounter)
                        }
                    )
                } else {
                    scoreScreen(corectCounter)
                }
            }
        }
    }
}

@Composable
fun scoreScreen(corectCounter: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Gratulacje",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Card(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = "Zdobyłeś $corectCounter pkt",
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    //.wrapContentHeight()
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun mainComposable(selectedOption: String,onNextQuestion: () -> Unit, funkcja2: () -> Unit)
{
    var questionCounter by remember { mutableStateOf(0) }
    var correctAnswers by remember { mutableStateOf(0) }
    var isSelectedCorrect by remember { mutableStateOf(false) }



    LazyColumn{
        item{
            Greeting(numerPytania = questionCounter+1)
        }
        item{
            Progressbar(wartosc = questionCounter)
        }
        item{
            CardWithQuestions(numerPytania = questionCounter)
        }
        item {CardWithAnswers(
            numerPytania = questionCounter,
            onOptionSelected = { selectedOption -> if(checkAnswer(selectedOption,questionCounter)){isSelectedCorrect = true}else{isSelectedCorrect = false} }
        )
        }
        item {
            NastepnePrzyciks(
                selectedOption = selectedOption,
                onNextQuestion = {

                    if(isSelectedCorrect)
                    {
                        println("TYLKO JAK POPRAWNA")
                        correctAnswers++
                        funkcja2()
                    }


                    if (questionCounter < 9) {
                        questionCounter++
                    } else {
                        onNextQuestion()
                    }


                    println("questionNumber: $questionCounter")
                }
            )




            }

    }
}

fun checkAnswer(selectedAnswer: String, questionCounter: Int): Boolean {
    val numerPoprawnejOdpowiedzi = listOf(2, 3, 4, 1, 1, 4, 2, 3, 1, 3)

    var odpowiedzi = listOf(
        listOf("y", "x", "z", "X Æ A-12"),
        listOf("Netflix", "Apple", "Microsoft", "Lenovo"),
        listOf("2", "32", "Afryka", "10"),
        listOf("4181", "231", "22", "9"),
        listOf("5", "6", "12", "15"),
        listOf("22", "4", "8", "9"),
        listOf("analiza leksykalna", "interpretacja", "optymalizacja kodu wynikowego", "wykonanie poleceń preprocesora"),
        listOf("96 bajtów", "12Gb", "64 bajtów", "2kb"),
        listOf("Tupi", "Fortran","Matlab","C++"),
        listOf("nieweim", "może", "poprawna", "nie"),)


    //println(selectedAnswer + "  "+ questionCounter)
    //println( odpowiedzi[questionCounter][numerPoprawnejOdpowiedzi[questionCounter]-1])
    //println(selectedAnswer == odpowiedzi[questionCounter][numerPoprawnejOdpowiedzi[questionCounter]-1])
     return selectedAnswer == odpowiedzi[questionCounter][numerPoprawnejOdpowiedzi[questionCounter]-1]
}





@Composable
fun Greeting(numerPytania: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Pytanie $numerPytania /10",
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        fontSize = 32.sp,
        textAlign = TextAlign.Center


    )
}
@Composable
fun CardWithQuestions(numerPytania: Int,modifier: Modifier = Modifier) {

    var pytania = listOf("Na jaką nazwę zmienił ostatno twitter?",
        "Jaka firma jest autorem Microsoft Office?",
        "ile to 5+5?",
        "Która z podanych liczb jest liczbą z ciągu fibonacciego?",
        "która liczba jest liczbą pierwszą?",
        "która liczba nie jest parzysta?",
        "który z etapów nie jest etapem kompilacji?",
        "jaką pojemność ma karta perforowana w formacie IBM 96?",
        "Który z języków nie jest językiem programowania?",
        "Która z odpowiedzi jest poprawna?")



    Card(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = pytania[numerPytania],modifier = modifier
            .fillMaxSize(), textAlign = TextAlign.Center)

    }
}



@Composable
fun CardWithAnswers(numerPytania: Int, modifier: Modifier = Modifier, onOptionSelected: (String) -> Unit) {
    var odpowiedzi = listOf(
        listOf("y", "x", "z", "X Æ A-12"),
        listOf("Netflix", "Apple", "Microsoft", "Lenovo"),
        listOf("2", "32", "Afryka", "10"),
        listOf("4181", "231", "22", "9"),
        listOf("5", "6", "12", "15"),
        listOf("22", "4", "8", "9"),
        listOf("analiza leksykalna", "interpretacja", "optymalizacja kodu wynikowego", "wykonanie poleceń preprocesora"),
        listOf("96 bajtów", "12Gb", "64 bajtów", "2kb"),
        listOf("Tupi", "Fortran","Matlab","C++"),
        listOf("nieweim", "może", "poprawna", "nie"),)
    var selectedOption by remember { mutableStateOf(odpowiedzi[numerPytania][0]) }


    //var numerPoprawnejOdpowiedzi = listOf(2, 3, 4, 1, 1, 4,2,3,1,3)





    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            RadioButtonWithText(odpowiedzi[numerPytania][0], selectedOption == odpowiedzi[numerPytania][0]) {
                selectedOption = odpowiedzi[numerPytania][0]
                onOptionSelected(selectedOption)
            }

            RadioButtonWithText(odpowiedzi[numerPytania][1], selectedOption == odpowiedzi[numerPytania][1]) {
                selectedOption = odpowiedzi[numerPytania][1]
                onOptionSelected(selectedOption)
            }

            RadioButtonWithText(odpowiedzi[numerPytania][2], selectedOption == odpowiedzi[numerPytania][2]) {
                selectedOption = odpowiedzi[numerPytania][2]
                onOptionSelected(selectedOption)
            }
            RadioButtonWithText(odpowiedzi[numerPytania][3], selectedOption == odpowiedzi[numerPytania][3]) {
                selectedOption = odpowiedzi[numerPytania][3]
                onOptionSelected(selectedOption)
            }

        }
    }
}

@Composable
fun RadioButtonWithText(text: String, isSelected: Boolean, onSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = { onSelected(text) }, // Update the state with the selected text
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = text)
    }
}

@Composable
fun NastepnePrzyciks(selectedOption: String, onNextQuestion: () -> Unit) {
    Button(onClick = { onNextQuestion() }, modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Text(text = "Następne")
    }
}


@Composable
fun Progressbar(wartosc: Int)
{


    LinearProgressIndicator(

        progress = wartosc.toFloat() / 10.0f,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lista3Theme {
        Greeting(0)
    }
}