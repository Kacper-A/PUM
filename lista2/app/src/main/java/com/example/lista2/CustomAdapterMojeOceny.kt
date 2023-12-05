package com.example.lista2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterMojeOceny(private var mList: List<ItemsViewModelOceny>) : RecyclerView.Adapter<CustomAdapterMojeOceny.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var textViewPrzedmiot: TextView = itemView.findViewById(R.id.przedmiotTextViewOceny)
        var textViewSrednia: TextView = itemView.findViewById(R.id.Srednia)
        var textViewliczbaList: TextView = itemView.findViewById(R.id.liczbaList)

        var exerciseList: List<Exercise> = listOf(Exercise("tresc",1))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.oceny_itemview, parent, false)

        return CustomAdapterMojeOceny.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapterMojeOceny.ViewHolder, position: Int) {

        var ItemsViewModel = mList[position]

        holder.textViewPrzedmiot.text = ItemsViewModel.przedmiot.toString()


        holder.textViewSrednia.text = "średnia : "+ String.format("%.3f",ItemsViewModel.srednia)
        holder.textViewliczbaList.text = "Liczba list: "+ ItemsViewModel.liczbaList.toString()



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
}