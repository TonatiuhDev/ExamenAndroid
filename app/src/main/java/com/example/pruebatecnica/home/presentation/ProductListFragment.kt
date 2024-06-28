package com.example.pruebatecnica.home.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.FragmentProductListBinding
import com.example.pruebatecnica.home.HomeViewModel
import com.example.pruebatecnica.home.data.remote.response.Productos
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment(), ProductsEvents {
    private lateinit var binding: FragmentProductListBinding

    private val homeViewModel: HomeViewModel by activityViewModels()

    private fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = initViewBinding(inflater, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        binding.progressBar.visibility = View.VISIBLE
        homeViewModel.getProducts.observe(viewLifecycleOwner) { result ->
            result?.getProductsResponse?.let {
                initProductsRecycler(it.resultado.productos)
            }
            result?.error?.let {
                //FLujo de error
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun initProductsRecycler(products: ArrayList<Productos>) {
        if (products.isNotEmpty()) {
            binding.progressBar.visibility = View.GONE
            binding.productRecycler.adapter = ProductsAdapter(products,this)
            binding.productRecycler.layoutManager = LinearLayoutManager(
                requireActivity(), LinearLayoutManager.VERTICAL, false
            )
        }
    }

    override fun moveToProductDetail(productDetail: Productos) {
        homeViewModel.myProduct.value = productDetail
        requireActivity().findNavController(R.id.navHomeFragmentApp)
            .navigate(R.id.productDetailFragment)
    }
}