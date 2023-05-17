package com.cursofinal.example.recyclerviewoscar.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cursofinal.example.recyclerviewoscar.R
import com.cursofinal.example.recyclerviewoscar.SuperHero
import com.cursofinal.example.recyclerviewoscar.databinding.ItemSuperheroBinding

class SuperHeroViewHolder (val view: View): RecyclerView.ViewHolder(view){

    //Variable para utilizar binding, por detras kotlin reconoce el item_superhero y lo renombra
    //con ItemSuperheroBinding
    val binding = ItemSuperheroBinding.bind(view)
                                          // * funcion lambda
    fun render (superHeroModel: SuperHero, onClickListener: (SuperHero)-> Unit){

        //se asignan las propiedades del objeto en las vistas predispuestas
        binding.tvSuperHeroName.text = superHeroModel.superHero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        //para usar Glide se tienen que implementar dos librerias y permiso para acceder a internet
        //Glide muestra la imagen que se paso como string
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)

       //mostrar mensaje cuando se de click en la imagen
        binding.ivSuperHero.setOnClickListener{

        }

        //itemView es toda la celda del RecyclerView
        itemView.setOnClickListener {
            //*llamamos a la funcion lambda y le pasamos el objeto superHeroModel
            onClickListener(superHeroModel)

        }

    }
}