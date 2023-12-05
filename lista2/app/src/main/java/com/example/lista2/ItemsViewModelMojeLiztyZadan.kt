package com.example.lista2

data class Exercise(var content:String,var points:Int)
{

}

data class ItemsViewModelMojeLiztyZadan(var przedmiot:String, var numerListy: Int, var liczbaZadan: Int, var ocena: Double, var exerciseList: List<Exercise>)
{

}
