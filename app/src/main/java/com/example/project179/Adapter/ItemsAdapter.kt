package com.example.project179.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project179.Activity.DetailActivity
import com.example.project179.Adapter.ItemsAdapter.Viewholder
import com.example.project179.Domain.PropertyDomain
import com.example.project179.databinding.ViewholderItemBinding

class ItemsAdapter(var items: ArrayList<PropertyDomain>) : RecyclerView.Adapter<Viewholder>() {
    var context: Context? = null
    var binding: ViewholderItemBinding? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        binding = ViewholderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return Viewholder(binding!!)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        binding!!.titleTxt.text = items[position].title
        binding!!.priceTxt.text = "$" + items[position].price
        binding!!.typeTxt.text = items[position].type
        binding!!.addressTxt.text = items[position].address
        binding!!.scoreTxt.text = "" + items[position].score
        binding!!.bedTxt.text = "" + items[position].bed
        binding!!.bathTxt.text = "" + items[position].bath
        val drawableResourceId = holder.itemView.resources
            .getIdentifier(
                items[position].pickPath,
                "drawable",
                holder.itemView.context.packageName
            )
        Glide.with(context!!)
            .load(drawableResourceId)
            .into(binding!!.pic)
        holder.itemView.setOnClickListener { v: View? ->
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(binding: ViewholderItemBinding) : RecyclerView.ViewHolder(binding.root)
}
