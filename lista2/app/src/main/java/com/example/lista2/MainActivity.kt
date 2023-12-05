package com.example.lista2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random
import androidx.navigation.ui.NavigationUI
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SharedViewModel : ViewModel() {
    var data = mutableListOf<ItemsViewModelMojeLiztyZadan>()
    var dataOceny = mutableListOf<ItemsViewModelOceny>()
    var dataZadania = mutableListOf<ItemsViewModelZadania>()
}

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


var data = mutableListOf<ItemsViewModelMojeLiztyZadan>()
var dataOceny = mutableListOf<ItemsViewModelOceny>()
var dataZadania = mutableListOf<ItemsViewModelZadania>()


class MainActivity : AppCompatActivity(), CustomAdapterMojeListyZadan.ItemClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)


        //var fragmentContainer = findViewById<View>(R.id.main_container)
        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView2)
        var navController = Navigation.findNavController(this, R.id.main_container)



        NavigationUI.setupWithNavController(bottomNavigation , navController)


        var recyclerView = findViewById<RecyclerView>(R.id.recycleViewMojeListyZadan)
        recyclerView.layoutManager = LinearLayoutManager(this)



        var adapter = CustomAdapterMojeListyZadan(data,this)

        recyclerView.adapter = adapter

        var liczbaPrzedmiotowLiczby:List<Int> = generateListOfIntegers()



        for(i in 0..4)
        {

            for (j in 1..liczbaPrzedmiotowLiczby[i])
            {
                var liczbaZadan = Random.nextInt(1,10)
                var exerciseList = mutableListOf<Exercise>()

                for (k in 1..liczbaZadan)
                {
                    var exercise = Exercise("treść zadania nr "+k.toString(),Random.nextInt(1,10))
                    exerciseList.add(exercise)
                }


                var item = ItemsViewModelMojeLiztyZadan("przedmiot",1,1,3.0,exerciseList)
                when(i)
                {
                    0 -> item.przedmiot = "matematyka"
                    1 -> item.przedmiot = "pum"
                    2 -> item.przedmiot = "fizyka"
                    3 -> item.przedmiot = "elektronika"
                    4 -> item.przedmiot = "algorytmy"

                }
                item.liczbaZadan = exerciseList.size
                item.ocena = 3.0 + 0.5 * Random.nextInt(0,4)
                item.numerListy = j

                data.add(item)
            }


        }


        sharedViewModel.data.addAll(data) //tutaj wysylam data związany z "Listy_Fragment" niżej zrobie data dla "Oceny_Fragment"

        for(i in 0..4) {
            var item = ItemsViewModelOceny("przedmiot",1.0,5)
            var liczbaList = 0
            var srednia = 0.0
            when(i)
            {
                0 -> item.przedmiot = "matematyka"
                1 -> item.przedmiot = "pum"
                2 -> item.przedmiot = "fizyka"
                3 -> item.przedmiot = "elektronika"
                4 -> item.przedmiot = "algorytmy"

            }
            val predicate: (ItemsViewModelMojeLiztyZadan) -> Boolean = {it.przedmiot == item.przedmiot} //wiem że jest to liczone wcześniej ALE do kolejnego kroku i tak muszę tego urzyć więc tu jest kolejny przykład jak tego można użyć i co to robi
            liczbaList = data.count(predicate)
            item.liczbaList = liczbaList

            val predicate2: (ItemsViewModelMojeLiztyZadan) -> Double = { if(it.przedmiot==item.przedmiot){it.ocena}else{0.0} }

            srednia = data.sumOf(predicate2)/liczbaList
            item.srednia = srednia

            dataOceny.add(item)

        }
        sharedViewModel.dataOceny.addAll(dataOceny)
        //poniżej data do zadania fragment
        for(i in 0..19)
        {
            var item = ItemsViewModelZadania("przedmiot", listOf<Exercise>())

            item.przedmiotZadania = data[i].przedmiot
            item.tresc = data[i].exerciseList
            dataZadania.add(item)
        }
        sharedViewModel.dataZadania.addAll(dataZadania)





    }

    override fun onItemClick(position: Int) {
        println("Item at position $position clicked")
        var zadaniaNrINazwa = findViewById<TextView>(R.id.ZadaniaNrINazwa)

        //zadaniaNrINazwa.text = data[position].przedmiot.toString() + "\nLista "+data[position].numerListy.toString()
    }
}