package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R

/**
 * created by Arman Hossain on 10/8/2018l
 */

    // (has error) right click on Caterougy adapter and select implement members, and select all necessary items in that list.

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter(){

    val context = context
    val categories = categories

                        // chane p0, p1, p2 was automatically changed to positoin, converView, and parent. i did not do it.

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View
                                            // we can null this however we need to remember to select out file after "R"

        // no idea what im doing
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName : TextView = categoryView.findViewById(R.id.categoryName)
        println("Heavy Computing")

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceId)
        println(resourceId)
        categoryName.text = category.title
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

}