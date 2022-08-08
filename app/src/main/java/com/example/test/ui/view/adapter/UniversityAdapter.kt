package com.example.test.ui.view.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.testGrupoSti.R
import com.example.test.data.model.UniversityModel
import com.example.testGrupoSti.databinding.ListUniversityBinding


class UniversityAdapter(var university: ArrayList<UniversityModel> = ArrayList()) :
    RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {


    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListUniversityBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = university[position]
        return holder.bind(item)
    }

    override fun getItemCount() = university.size

    class ViewHolder(private val binding: ListUniversityBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: UniversityModel) {
            binding.tvname.text = item.name
           // binding.tvcountry.text = item.country


            itemView.setOnClickListener {
                var params = Bundle()
                params.putString("UniName", item.name,)
                params.putString("Country",item.country)
                params.putString("WebPage",item.web_pages.toString())
                params.putString("AlphaCode",item.alpha_two_code)
                params.putString("Domians", item.domains.toString())
                Navigation.findNavController(itemView)
                    .navigate(R.id.action_mainFragment_to_detailFragment, params)
            }
        }


    }

}