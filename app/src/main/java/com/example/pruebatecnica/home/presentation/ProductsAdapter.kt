package com.example.pruebatecnica.home.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica.R
import com.example.pruebatecnica.databinding.ItemProductListBinding
import com.example.pruebatecnica.home.data.remote.response.Productos

class ProductsAdapter(
    private val products: List<Productos>,
    private val productsEvents: ProductsEvents
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder =
        ProductsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_list, parent, false)
        )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        with(holder) {
            val myProduct = products[position]
            binding.apply {
                productName.text = myProduct.nombre
                productPrice.text = myProduct.precioFinal.toString()
            }
            holder.itemView.setOnClickListener {
                productsEvents.moveToProductDetail(myProduct)
            }
        }
    }

    override fun getItemCount(): Int = products.size

    class ProductsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemProductListBinding.bind(view)
    }
}