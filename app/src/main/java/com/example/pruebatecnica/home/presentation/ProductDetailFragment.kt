package com.example.pruebatecnica.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pruebatecnica.R
import com.example.pruebatecnica.commons.setImage
import com.example.pruebatecnica.databinding.FragmentProductDetailBinding
import com.example.pruebatecnica.home.HomeViewModel
import com.example.pruebatecnica.home.data.remote.response.Productos
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding

    private val homeViewModel: HomeViewModel by activityViewModels()

    private fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = initViewBinding(inflater, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnClickListeners()
        initObservers()
    }

    private fun initOnClickListeners() {
        binding.getProductsButton.setOnClickListener{
            homeViewModel.getProducts()
            requireActivity().findNavController(R.id.navHomeFragmentApp)
                .navigate(R.id.productListFragment)
        }
    }

    private fun initObservers() {
        homeViewModel.myProduct.observe(viewLifecycleOwner){
            showProductSelected(it)
        }
    }

    private fun showProductSelected(product: Productos) {
        binding.productCard.apply {
            root.visibility = View.VISIBLE
            productImage.setImage(product.urlImagenes[0])
            productName.text = product.nombre
            val price = "$ ${product.precioFinal}"
            productPrice.text = price
            productCategory.text = product.codigoCategoria
        }
    }
}