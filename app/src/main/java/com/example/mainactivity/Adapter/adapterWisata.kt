package com.example.mainactivity.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.R
import com.example.mainactivity.model.ModelWisata
import com.example.mainactivity.DetailWisata


class adapterWisata (
    val itemListWisata: List<ModelWisata>
): RecyclerView.Adapter<adapterWisata.MyviewHolder>() {
    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

        var imgwisata : ImageView = itemView.findViewById(R.id.imgWisata)
        var txtnama: TextView = itemView.findViewById(R.id.txtnama)
        var txtdaerah : TextView = itemView.findViewById(R.id.txtdaerah)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlistwisata,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemListWisata.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemListWisata[position]
        holder.imgwisata.setImageResource(currentItem.img)
        holder.txtnama.setText(currentItem.nama)
        holder.txtdaerah.setText(currentItem.daerah)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailWisata::class.java).apply {
                // Mengirim data melalui intent
                putExtra("deskripsi", currentItem.des)
                putExtra("namaWisata",currentItem.nama)
                putExtra("imagewisata", currentItem.img)
                putExtra("latitude", currentItem.latitude)
                putExtra("longitude", currentItem.longitude)
            }
            context.startActivity(intent)
        }


    }


}