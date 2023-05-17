package com.cursofinal.example.recyclerviewoscar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursofinal.example.recyclerviewoscar.adapter.SuperHeroAdapter
import com.cursofinal.example.recyclerviewoscar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    //Creamos funcion para iniciar el RecyclerView y adatpar los datos a la vista
    fun initRecyclerView(){

        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)

        //para agregar mas de un items en la celda (rvSuperHero) sustituimos el manager por:
        // val manager = GridLayoutManager (this, 2) (se cambia el numero, items por fila)

        //Se agrega esta linea para que muestre un elemento por cada celda
        binding.rVSuperHero.layoutManager = manager

        //*las expresiones lambda van fuera de parentesis y si se tiene ya implementada la funcion a
        //ocupar solo se coloca con this::onItemSelected
        binding.rVSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superheroList,this::onItemSelected)


        //para darle espaciado entre Items
        binding.rVSuperHero.addItemDecoration(decoration)
    }

    //*Creamos funcion para utilizar la funcion lambda
     fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this,superHero.superHero, Toast.LENGTH_SHORT).show()
    }
}

//1.- En la ActivityMain colocamos un RecyclerView y como padre FrameLayout
//2.- Creamos nuesto modelo de datos (SuperHero)
//3.- Configuramos nuestro RecyclerView
  //  3.1.- Creamos clase Adapter  <- Se encarga de tomar la info y setearla en el RecyclerView
  //  3.2.- Creamos clase ViewHolder  <- Se encarga de pintar la celdas con cada objeto del listado
  //  3.3.- Creamos layout con el ITEM  que vamos a pintar en el RecyclerView.
//4.-

