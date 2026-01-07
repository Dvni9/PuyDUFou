package com.example.puydufou.ui.shows.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.puydufou.R
import com.example.puydufou.data.model.Show

class ShowsAdapter(
    private val shows: List<Show>,
    private val onItemClick: (Show) -> Unit
) : RecyclerView.Adapter<ShowsAdapter.ShowViewHolder>() {

    class ShowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.showName)
        val schedule: TextView = view.findViewById(R.id.showSchedule)
        val duration: TextView = view.findViewById(R.id.showDuration)
        val zone: TextView = view.findViewById(R.id.showZone)
        val favoriteIcon: ImageView = view.findViewById(R.id.favoriteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_show, parent, false)
        return ShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val show = shows[position]

        holder.name.text = show.name
        holder.schedule.text = "Horarios: ${show.schedule}"
        holder.duration.text = "Duración: ${show.duration}"
        holder.zone.text = "Zona: ${show.zone}"

        // Mostrar/ocultar icono de favorito
        holder.favoriteIcon.visibility = if (show.isFavorite) View.VISIBLE else View.GONE

        // Configurar clic
        holder.itemView.setOnClickListener { onItemClick(show) }
    }

    override fun getItemCount() = shows.size
}