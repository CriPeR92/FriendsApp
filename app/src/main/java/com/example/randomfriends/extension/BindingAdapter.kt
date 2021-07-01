package com.example.randomfriends.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.io.IOException
import java.io.InputStream
import java.net.URL


/**
 * Function to loadImage into imageView
 * start a background thread for networking, download the image and edit the view in the UI thread
 */
@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Thread {
        try {
            val drawable = Drawable.createFromStream(URL(imageUrl).content as InputStream, "src")
            view.post { view.setImageDrawable(drawable) }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }.start()
}

/**
 * Function to set adapter in recyclerView and set recyclerView features
 */
@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
    this.setHasFixedSize(true)
    this.adapter = adapter
}

/**
 * bind to know when to hide or show a view
 */
@BindingAdapter("app:hideIfSaved")
fun hideIfSaved(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}
