package com.example.lista4podejscie2.data

import com.example.lista4podejscie2.data.model.Exercise
import com.example.lista4podejscie2.data.model.ExerciseList
import com.example.lista4podejscie2.data.model.Subject
import kotlin.random.Random

object DataProvider {

    val listaZadan = mutableListOf<ExerciseList>()
    var liczbaPrzedmiotowLiczby:List<Int> = generateListOfIntegers()
    val przedmioty = mutableListOf(
        Subject("Matematyka"),
        Subject("Pum"),
        Subject("fizyka"),
        Subject("elektronik"),
        Subject("algorytmy")
    )

    //ExerciseList(zadania, przedmiot,5)

    fun generateListOfIntegers(): List<Int> {
        val resultList = mutableListOf<Int>()
        var remainingSum = 20

        for (i in 1 until 5) {
            // Generate a random number between 1 and the remaining sum, with a maximum of (remainingSum - (5 - i)).
            val randomValue = Random.nextInt(1, minOf(remainingSum - (5 - i) + 1,7))
            resultList.add(randomValue)
            remainingSum -= randomValue
        }
        // The last item in the list is the remaining sum to ensure the total is 20.
        resultList.add(remainingSum)
        return resultList
    }

    fun generateData()
    {



        var temp = ExerciseList(emptyList<Exercise>(), Subject("tempNazwa"),1.0,0)
        var LiczbaZadan =0


        var pojedynczeZadanie = Exercise("tresc",1)
        var zadaniaWPojedynczejLiscie = mutableListOf<Exercise>()
        var przedmiot = Subject("a")
        for(i in 0..4)
        {

            for (j in 1..liczbaPrzedmiotowLiczby[i])
            {
                zadaniaWPojedynczejLiscie = mutableListOf<Exercise>()

                LiczbaZadan = Random.nextInt(1,11) //od 1 do 10
                for (k in 1 .. LiczbaZadan)
                {
                    pojedynczeZadanie = Exercise("tresc zadania nr $k",Random.nextInt(1,11))
                    zadaniaWPojedynczejLiscie.add(pojedynczeZadanie)
                   // println("przedmiot $i lista $j zadanie $k")
                }
                przedmiot = przedmioty[i] //tutaj jest cos co crashuje apke
                temp = ExerciseList(zadaniaWPojedynczejLiscie, przedmiot,Random.nextInt(6,11)/2.0,j)

                listaZadan.add(temp)
            }
        }
    }

    init {
        generateData()
    }



}