package enzo.tavares.hort.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import enzo.tavares.hort.Data_Receita
import enzo.tavares.hort.R

class AdapterReceita(private val dataList: ArrayList<Data_Receita>): RecyclerView.Adapter<AdapterReceita.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_receita,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size

    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvReceitaImage.setImageResource(currentItem.dataImage)
        holder.rvReceitaNome.text = currentItem.dataTitle
        holder.rvReceitaTempo.text = currentItem.dataTempo
    }

    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvReceitaImage: ImageView = itemView.findViewById(R.id.imageReceita)
        val rvReceitaNome: TextView = itemView.findViewById(R.id.nomeReceita)
        val rvReceitaTempo: TextView = itemView.findViewById(R.id.tempoReceita)
    }


}