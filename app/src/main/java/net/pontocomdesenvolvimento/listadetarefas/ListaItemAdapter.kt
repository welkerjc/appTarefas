package net.pontocomdesenvolvimento.listadetarefas

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.ParseException
import java.text.SimpleDateFormat

class ListaItemAdapter(private val context: Context, private val itensList: List<ListaItemModel>) :RecyclerView.Adapter<ListaItemAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var listaTexto : TextView = view.findViewById(R.id.texto)
        var listaData : TextView = view.findViewById(R.id.dataAtual)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context)
           .inflate(R.layout.list_item_layout,parent,false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itensList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = itensList[position]

        holder.listaTexto.setText(listItem.listaTexto)
        holder.listaData.text = formataData(listItem.listaData!!)
    }

    private fun formataData(data: String): String{
        try {
            val formatoIni = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val recebeData = formatoIni.parse(data)
            val formatoFim = SimpleDateFormat("d MMM, yyyy")
            return formatoFim.format(recebeData)
        } catch (e: ParseException){
            return ""
        }
    }


}