package enzo.tavares.hort.Adapter

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import enzo.tavares.hort.Model.Receita
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView
import enzo.tavares.hort.R

class AdapterReceita(var contexto: Context, var listaReceita:List<Receita>): Adapter<AdapterReceita.MeuViewHolder>() {

    var posicaoClicada:Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        var inflater :LayoutInflater = LayoutInflater.from(contexto)
        var view = inflater.inflate(R.layout.item_receita,parent,false)
        return MeuViewHolder(view, contexto)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val receita : Receita = listaReceita.elementAt(position)
        val nome: TextView = holder.itemView.findViewById(R.id.nomeReceita)
        val tempoReceita: TextView = holder.itemView.findViewById(R.id.tempoReceita)
        //val imageReceita: ImageView = holder.itemView.findViewById(R.id.imageReceita)
        nome.text = receita.nome
        tempoReceita.text = receita.tempoDePreparo
        //imageReceita.setImageURI(receita.foto)

        holder.itemView.setOnClickListener { v->
            posicaoClicada = holder.adapterPosition
            false
        }

    }

    override fun getItemCount(): Int {
        return listaReceita.size

    }

    class MeuViewHolder(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {

        init {
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            var menuInflater: MenuInflater = MenuInflater(contexto)
            menuInflater.inflate(R.menu.menu_receita,menu)
        }

    }


}