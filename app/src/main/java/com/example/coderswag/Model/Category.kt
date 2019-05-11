package com.example.coderswag.Model

class Category(val title:String, val image: String) {
    override fun toString(): String {
        // deleted super.toString() to title---over riding the default listing.
        return title
    }
}