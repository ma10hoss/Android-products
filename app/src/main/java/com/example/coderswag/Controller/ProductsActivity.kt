package com.example.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import com.example.coderswag.Adapters.ProductsAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType= intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType) )

        //this is a check for orientation and number of columbs.
        var spanCount = 2
                                    //this returns an integer number, 1- portrate 2- landscape
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        // this is a check for differnt size.

        val screenSize = resources.configuration.screenWidthDp
        // extra large screens start at 720dp
        if (screenSize > 720){
            spanCount = 3
        }

        val layoutManage = GridLayoutManager(this,  spanCount)
        productListView.layoutManager = layoutManage
        productListView.adapter = adapter
    }
}
