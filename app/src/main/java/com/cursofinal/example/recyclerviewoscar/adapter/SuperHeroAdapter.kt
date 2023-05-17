package com.cursofinal.example.recyclerviewoscar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cursofinal.example.recyclerviewoscar.R
import com.cursofinal.example.recyclerviewoscar.SuperHero

//* Le pasamos una funcion lambda como argumento para mostrar un mensaje si se le da un clik al Item
class SuperHeroAdapter( private val superheroList:List<SuperHero>, private val onClickListener: (SuperHero)-> Unit): RecyclerView.Adapter<SuperHeroViewHolder>() {

    //Le devuelve un ITEM al ViewHolder por cada elemento que existe en el listado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //retorna una vista(item_superhero) a la clase SuperHeroViewHolder
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        //llamamos a la funcion render por cada item que valla recorriendo
        val item = superheroList[position]
        //En el item_superhero que recibimos proyectamos los datos.
        holder.render(item, onClickListener)
        //* le pasamos la funcion lambda al render y actualizamos sus parametros
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }
}