package com.example.labo5_00084417

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_basic.view.*
import java.lang.Exception


const val ARG_TEXT1 = "texto1"
const val ARG_TEXT2 = "texto2"

class FragmentBasic : android.support.v4.app.Fragment() {

    var texto1: String? = null
    var texto2: String? = null
    var toolBox:ListenerToolBox? = null

    //El contexto es el del padre que manda a llamar el fragmentop
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        //verificando si implementa la interfaz de ListenerToolBox
        if(context is ListenerToolBox){
            toolBox = context
        }
        else{
            throw Exception("Se nececita implementar la interfaz ToolBoxListener")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            texto1 = getString("texto1", "")
            texto2 = getString("texto2", "")
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basic, container, false).apply {
            tv1.text = texto1
            tv2.text = texto2
            action_change.setOnClickListener { toolBox?.clickListenerHandler(tv1) }
        }
    }

    override fun onDetach() {
        super.onDetach()
        toolBox = null
    }
    companion object {
        fun newInstance(texto1:String, texto2:String) = FragmentBasic().apply {
            arguments = Bundle().apply {
                putString(ARG_TEXT1,texto1)
                putString(ARG_TEXT2,texto2)
            }
        }

    }
    interface ListenerToolBox{
        fun clickListenerHandler(view: TextView)
    }
}