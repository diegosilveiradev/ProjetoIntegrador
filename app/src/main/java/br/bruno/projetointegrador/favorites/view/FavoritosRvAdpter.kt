package br.bruno.projetointegrador.favorites.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.bruno.projetointegrador.favorites.data.ListaDeFavoritos
import br.bruno.projetointegrador.R

class FavoritosRvAdpter(
        var listaDeFavoritos : List<ListaDeFavoritos>
    ) : RecyclerView.Adapter<FavoritosRvAdpter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_fav_list, parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.movieIcon_favList).setImageResource(listaDeFavoritos[position].movieicon)
        holder.itemView.findViewById<TextView>(R.id.movieTittle_favList).text = listaDeFavoritos[position].movieTittle
    }

    override fun getItemCount(): Int = listaDeFavoritos.size
}