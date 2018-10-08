package com.example.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.coderswag.Adapters.CategoryAdapter
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

/** Created by Arman Hossain 10/8/2018
 */

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //An ArrayAdapter inherits from a base adapter
        //this was done first.
//        adapter = ArrayAdapter(this,
//                // this is a simple built in list that android has
//                android.R.layout.simple_list_item_1,
//                DataService.categories)
//        categoryListView.adapter = adapter

        //this was added later
        adapter = CategoryAdapter( this, DataService.categories)
        categoryListView.adapter = adapter
    }
}
