package com.example.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Product
import com.example.coderswag.R

/**
created by Arman Hossain 10/12/2018
*/                      // val eleminates the necessity of needing member variable in class.
class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductHolder {

        // this is where we creat the view for the very first time--
        // if there hasnt been any recyclerView views created, we do it here by INFLATING

        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, p0,false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(product.image,"dwawable",context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price

        }
    }
}