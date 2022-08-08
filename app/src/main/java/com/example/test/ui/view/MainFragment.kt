package com.example.test.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testGrupoSti.databinding.FragmentUniversityBinding
import com.example.test.data.model.UniversityModel
import com.example.test.ui.view.adapter.UniversityAdapter
import com.example.test.ui.viewmodel.UniversityViewModel

private const val ARG_PARAM1 = "param1"

class MainFragment : Fragment() {
    private var param1: String? = null


    private val universityViewModel: UniversityViewModel by viewModels()
    private lateinit var adapter: UniversityAdapter
    private lateinit var binding: FragmentUniversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentUniversityBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        universityViewModel.onCreate()
        universityViewModel.universityModel.observe(this, Observer {
            loadData(it)
        })
        universityViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

    }

    private fun loadData(arrayList: ArrayList<UniversityModel>) {
        adapter = UniversityAdapter(arrayList)
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = adapter
    }


}