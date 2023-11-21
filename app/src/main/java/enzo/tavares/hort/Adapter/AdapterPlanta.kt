package enzo.tavares.hort.Adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import enzo.tavares.hort.Model.Planta
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import enzo.tavares.hort.R

class AdapterPlanta(var contexto: Context, var listaPlanta:List<Planta>) : Adapter<AdapterPlanta.MeuViewHolder>() {

    var posicaoClicada:Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        var inflater :LayoutInflater = LayoutInflater.from(contexto)
        var view = inflater.inflate(R.layout.item_planta,parent,false)
        return MeuViewHolder(view,contexto)

    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val planta : Planta = listaPlanta.elementAt(position)
        val nome: TextView = holder.itemView.findViewById(R.id.nomePlanta)
        nome.text = planta.nome

        holder.itemView.setOnClickListener { v->
            posicaoClicada = holder.adapterPosition
            false
        }

    }

    override fun getItemCount(): Int {
        return this.listaPlanta.size
    }

    class MeuViewHolder(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener{

        init {
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo?) {
            var menuInflater: MenuInflater = MenuInflater(contexto)
            menuInflater.inflate(R.menu.menu_plantio,menu)
        }


    }
}