package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Language

class LanguageAdapter(private val languages: List<Language>, private val onItemClicked: (Language) -> Unit) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    class LanguageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val languageName: TextView = view.findViewById(R.id.languageName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_language, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languages[position]
        holder.languageName.text = language.name
        holder.itemView.setOnClickListener {
            onItemClicked(language)
        }
    }

    override fun getItemCount() = languages.size
}