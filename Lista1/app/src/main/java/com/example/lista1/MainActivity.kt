package com.example.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.Vector


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    var wynik = 0;
    var numerPytania: Int =0;
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
    var numerPoprawnejOdpowiedzi = listOf(2, 3, 4, 1, 1, 4,2,3,1,3)

    var pytaniaKolejnosc = (0..9).toList().shuffled()
    fun buttonClick(view: android.view.View?)
    {
        wynik = 0
        numerPytania = 0;
        setContentView(R.layout.pytania)
        pytaniaKolejnosc =  (0..9).toList().shuffled()
        ustawPytanie()
        //println("buttonClicked") //println daje output do "Logcat", ta linijka dziala jak sie wciska przycisk
    }

    fun ustawPytanie()
    {




        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = numerPytania *10;

        val numerPytaniaTextBox = findViewById<TextView>(R.id.textView2)
        numerPytaniaTextBox.text = "Pytanie "+(numerPytania+1)+"/10"
        val pytanieTextBox = findViewById<TextView>(R.id.pytanie)
        pytanieTextBox.text = pytania[pytaniaKolejnosc[numerPytania]]

        val odp1Button = findViewById<RadioButton>(R.id.odp1)
        val odp2Button = findViewById<RadioButton>(R.id.odp2)
        val odp3Button = findViewById<RadioButton>(R.id.odp3)
        val odp4Button = findViewById<RadioButton>(R.id.odp4)

        odp1Button.text = odpowiedzi[pytaniaKolejnosc[numerPytania]][0]
        odp2Button.text = odpowiedzi[pytaniaKolejnosc[numerPytania]][1]
        odp3Button.text = odpowiedzi[pytaniaKolejnosc[numerPytania]][2]
        odp4Button.text = odpowiedzi[pytaniaKolejnosc[numerPytania]][3]

    }

    fun nastepnePytanie(view: android.view.View?) //te funkcje powinno się wywołać kiedy urzytkownik wcisnie przycisk "Następne"
    {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        numerPytania++

        if(numerPytania<10)
        {

            if(radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.checkedRadioButtonId)) == numerPoprawnejOdpowiedzi[numerPytania]-1 ) //numer poprawnej odpowiedzi jest większy o 1 od indeksu ponieważ w tej liście numery zaczynam od 1
            {
                //println("poprawna odpowiedz debug")
                wynik++
            }

            ustawPytanie()
        }
        else
        {
            setContentView(R.layout.wynik)
            val wynikTextView = findViewById<TextView>(R.id.wynik)

            wynikTextView.text = "Zdobyłeś "+wynik*10+" pkt"
        }
    }

}