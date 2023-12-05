package com.example.lista2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterZadania(private var mList: List<ItemsViewModelZadania>): RecyclerView.Adapter<CustomAdapterZadania.ViewHolder>() {


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        var textViewNrZadania: TextView = itemView.findViewById(R.id.NrZadania)
        var textViewIloscPunktow: TextView = itemView.findViewById(R.id.IloscPunktow)
        var textViewTrescZadania: TextView = itemView.findViewById(R.id.TrescZadania)

        /*
        var textViewPrzedmiot: TextView = itemView.findViewById(R.id.przedmiotTextView)
        var textViewNumerListy: TextView = itemView.findViewById(R.id.numerListyTextView)
        var textViewLiczbaZadan: TextView = itemView.findViewById(R.id.liczbaZadan)
        var textViewOcena: TextView = itemView.findViewById(R.id.ocena)
        var exerciseList: List<Exercise> = listOf(Exercise("tresc", 1))*/

    }

    //override fun onClick(v: View?) {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapterZadania.ViewHolder {

        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.zadania_itemview, parent, false)

        return CustomAdapterZadania.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapterZadania.ViewHolder, position: Int) {

        println("CzyTutaj Jest crash????????")
        var ItemsViewModel = mList[position]




        holder.textViewNrZadania.text = "Zadanie: "+ ItemsViewModel.przedmiotZadania.toString()
        holder.textViewIloscPunktow.text = "pkt: "+ ItemsViewModel.tresc[0].points.toString()
        holder.textViewTrescZadania.text = ItemsViewModel.tresc[0].content.toString()

            /*
        holder.textViewLiczbaZadan.text = "Liczba zadań: "+ ItemsViewModel.liczbaZadan.toString()
        holder.textViewNumerListy.text = "Lista "+ ItemsViewModel.numerListy.toString()
        holder.textViewOcena.text = "Ocena: "+ItemsViewModel.ocena.toString()
        holder.textViewPrzedmiot.text = ItemsViewModel.przedmiot.toString()
        */

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

}