package com.example.labo5_00084417

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(),FragmentBasic.ListenerToolBox{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obteniendo la instancia
       /* val fragmentBasic :FragmentBasic = FragmentBasic().apply {
            arguments = Bundle().apply {
                putString("texto1","Voy a")
                putString("texto2","sacar 10")
            }
        }*/
        //Obteniendo la instancia
        val fragmentBasic :FragmentBasic = FragmentBasic.newInstance("voy a","sacar 10")
        //Indicando lo que hara el frragmento
        supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_content,fragmentBasic)
                .commit()


    }

    override fun clickListenerHandler(view:TextView) {
        view.text = "dasdsa"
    }

}
