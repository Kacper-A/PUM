package com.example.lista2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import java.util.Currency
import kotlin.random.Random

class CustomAdapterMojeListyZadan(private var mList: List<ItemsViewModelMojeLiztyZadan>,
                                  private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<CustomAdapterMojeListyZadan.ViewHolder>() {

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View, private val clickListener: ItemClickListener) : RecyclerView.ViewHolder(ItemView), View.OnClickListener {
        var textViewPrzedmiot: TextView = itemView.findViewById(R.id.przedmiotTextView)
        var textViewNumerListy: TextView = itemView.findViewById(R.id.numerListyTextView)
        var textViewLiczbaZadan: TextView = itemView.findViewById(R.id.liczbaZadan)
        var textViewOcena: TextView = itemView.findViewById(R.id.ocena)
        var exerciseList: List<Exercise> = listOf(Exercise("tresc",1))

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            // Pass the clicked item position to the onItemClick method
            clickListener.onItemClick(adapterPosition)

            // Get the clicked item from the list
            val clickedItem = data[adapterPosition]

            // Assuming you have a NavController instance, you can use it to navigate to the ZadaniaFragment
            val navController = Navigation.findNavController(v!!)

            /*
            val bundle = Bundle()

            bundle.putStringArrayList("tresc", clickedItem.exerciseList)
            bundle.putString()
            bundle.putInt("liczbaZadan", clickedItem.liczbaZadan)
            // Add any other data you want to pass
            */
            // Navigate to ZadaniaFragment
            navController.navigate(R.id.ZadaniaFragment)
        }
    }
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item


        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mojelistyzadan_itemview, parent, false)

        return ViewHolder(view, itemClickListener)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var ItemsViewModel = mList[position]


        holder.textViewLiczbaZadan.text = "Liczba zadań: "+ ItemsViewModel.liczbaZadan.toString()
        holder.textViewNumerListy.text = "Lista "+ ItemsViewModel.numerListy.toString()
        holder.textViewOcena.text = "Ocena: "+ItemsViewModel.ocena.toString()
        holder.textViewPrzedmiot.text = ItemsViewModel.przedmiot.toString()


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }



    interface ItemClickListener {

        fun onItemClick(position: Int)

    }
}