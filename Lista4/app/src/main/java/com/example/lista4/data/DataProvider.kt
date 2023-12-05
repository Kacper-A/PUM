package com.example.lista4.data

object DataProvider {

    val listaZadan = mutableListOf<ExerciseList>()

    val ListaListZadań = listOf(
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 1)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 2), Exercise("zadanie 3", 2), Exercise("zadanie 4", 3), Exercise("zadanie 5", 2)),
        listOf(Exercise("zadanie 1",3), Exercise("zadanie 2", 3), Exercise("zadanie 3", 3)),
        listOf(Exercise("zadanie 1",5), Exercise("zadanie 2", 2), Exercise("zadanie 3", 1), Exercise("zadanie 4", 1)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 5)),
        listOf(Exercise("zadanie 1",2), Exercise("zadanie 2", 2), Exercise("zadanie 3", 4)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 3), Exercise("zadanie 3", 1)),
        listOf(Exercise("zadanie 1",3), Exercise("zadanie 2", 2)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 2)),
        listOf(Exercise("zadanie 1",2), Exercise("zadanie 2", 2), Exercise("zadanie 3", 5)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 4), Exercise("zadanie 3", 2), Exercise("zadanie 4", 5), Exercise("zadanie 5", 1)),
        listOf(Exercise("zadanie 1",4), Exercise("zadanie 2", 2), Exercise("zadanie 3", 5), Exercise("zadanie 4", 2)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 3), Exercise("zadanie 3", 3)),
        listOf(Exercise("zadanie 1",2), Exercise("zadanie 2", 2)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 1), Exercise("zadanie 3", 1)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 1), Exercise("zadanie 3", 4), Exercise("zadanie 4", 3), Exercise("zadanie 5", 4)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 2), Exercise("zadanie 3", 3)),
        listOf(Exercise("zadanie 1",4), Exercise("zadanie 2", 1)),
        listOf(Exercise("zadanie 1",1), Exercise("zadanie 2", 2), Exercise("zadanie 3", 2), Exercise("zadanie 4", 2)),
        listOf(Exercise("zadanie 1",2), Exercise("zadanie 2", 2), Exercise("zadanie 3", 1)),
    )
    val przedmioty = listOf(
        Subject("Matematyka"),
        Subject("Pum"),
        Subject("fizyka"),
        Subject("elektronik"),
        Subject("algorytmy")
    )

    //ExerciseList(zadania, przedmiot,5)
    init {

        for( i in 0..19)
        {
            println("test")
        }

    }



}


