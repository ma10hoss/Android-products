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

class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter(){

    // chane p0, p1, p2 was automatically changed to positoin, converView, and parent. i did not do it.

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View
        val holder : ViewHolder

        if (convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
            holder = ViewHolder()
            //Holder instead of val is more efficient
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            //println("I exist for the first time")
//            val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
//            val categoryName : TextView = categoryView.findViewById(R.id.categoryName)

                // setting a unique value to the categoryView, which is the Holder.
            categoryView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            //println("Go green recycle")
        }
                                            // we can null this however we need to remember to select out file after "R"

        // no idea what im doing

        //not needed
        //println("Heavy Computing")

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        /**after adding the else section we need to add Holder infront of caterogyImage---
         ? are added to make it a safe call because they are nullable */

        //this is the binding section equivlant to categoryRecyclerAdapter
        holder.categoryImage?.setImageResource(resourceId)
            //print line not needed
        //println(resourceId)
        holder.categoryName?.text = category.title
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
    // allows us to reuse and recycle our views
    private class ViewHolder{
        var categoryImage:ImageView?= null
        var categoryName: TextView?= null
    }
}