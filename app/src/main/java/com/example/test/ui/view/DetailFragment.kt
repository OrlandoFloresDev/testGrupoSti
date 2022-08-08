package com.example.test.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testGrupoSti.databinding.FragmentDetailBinding

private const val ARG_PARAM1 = "UniName"
private const val ARG_PARAM2 = "WebPage"
private const val ARG_PARAM3 = "AlphaCode"
private const val ARG_PARAM4 = "Domians"
private const val ARG_PARAM5 = "Country"


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    private var param5: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
            param5 = it.getString(ARG_PARAM5)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.TextTitulo.text = param1
        binding.textWeb.text = param2
        binding.textAlfha.text = param3
        binding.textDomians.text = param4
        binding.textCountry.text = param5


    }

}

