package com.example.project179.Activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.project179.Domain.PropertyDomain
import com.example.project179.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    var binding: ActivityDetailBinding? = null
    private var `object`: PropertyDomain? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        bundles
        setVariable()
    }

    private fun setVariable() {
        binding!!.backBtn.setOnClickListener { v: View? -> finish() }
        val drawableResourceID = resources.getIdentifier(
            `object`!!.pickPath,
            "drawable",
            this@DetailActivity.packageName
        )
        Glide.with(this@DetailActivity)
            .load(drawableResourceID)
            .into(binding!!.picDetail)
        binding!!.titleAddressTxt.text = `object`!!.title + " in " + `object`!!.address
        binding!!.typeTxt.text = `object`!!.type
        binding!!.descriptionTxt.text = `object`!!.description
        binding!!.priceTxt.text = "$" + `object`!!.price
        binding!!.bedTxt.text = `object`!!.bed.toString() + " Bedroom"
        binding!!.bathTxt.text = `object`!!.bath.toString() + " Bathroom"
        binding!!.sizeTxt.text = `object`!!.size.toString() + " m2"
        if (`object`!!.isGarage) {
            binding!!.garageTxt.text = "Car Garage"
        } else {
            binding!!.garageTxt.text = "no-Car Garage"
        }
    }

    private val bundles: Unit
        private get() {
            `object` = intent.getSerializableExtra("object") as PropertyDomain?
        }
}