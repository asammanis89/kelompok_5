package com.example.project179.Activity

import android.R
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project179.Adapter.ItemsAdapter
import com.example.project179.Domain.PropertyDomain
import com.example.project179.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private val adapterRecommeneded: RecyclerView.Adapter<*>? = null
    private val adapterNearby: RecyclerView.Adapter<*>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initLocation()
        initList()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun initList() {
        val items = ArrayList<PropertyDomain>()
        items.add(
            PropertyDomain(
                "Apartment",
                "Royal Apartment",
                "LosAngles LA",
                "house_1",
                1500,
                2,
                3,
                350,
                true,
                4.5,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        items.add(
            PropertyDomain(
                "House",
                "House with Great View",
                "Newyork NY",
                "house_2",
                800,
                1,
                2,
                500,
                false,
                4.9,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        items.add(
            PropertyDomain(
                "Villa",
                "Royal Villa",
                "LosAngles La",
                "house_3",
                999,
                2,
                1,
                400,
                true,
                4.7,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        items.add(
            PropertyDomain(
                "House",
                "beauty house",
                "Newyork NY",
                "house_4",
                1750,
                3,
                2,
                1100,
                true,
                4.3,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        binding!!.recommendedView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding!!.recommendedView.adapter = ItemsAdapter(items)
        val itemsNear = ArrayList<PropertyDomain>()
        itemsNear.add(
            PropertyDomain(
                "House",
                "beauty house",
                "Newyork NY",
                "house_4",
                1750,
                3,
                2,
                1100,
                true,
                4.3,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        itemsNear.add(
            PropertyDomain(
                "Villa",
                "Royal Villa",
                "LosAngles La",
                "house_3",
                999,
                2,
                1,
                400,
                true,
                4.7,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        itemsNear.add(
            PropertyDomain(
                "House",
                "House with Great View",
                "Newyork NY",
                "house_2",
                800,
                1,
                2,
                500,
                false,
                4.9,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        itemsNear.add(
            PropertyDomain(
                "Apartment",
                "Royal Apartment",
                "LosAngles LA",
                "house_1",
                1500,
                2,
                3,
                350,
                true,
                4.5,
                "This 2 bed /1 bath home boasts an enormous,open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings. "
            )
        )
        binding!!.nearView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding!!.nearView.adapter = ItemsAdapter(itemsNear)
    }

    private fun initLocation() {
        val items = arrayOf("LosAngles, USA", "NewYork, USA")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding!!.locationSpin.adapter = adapter
    }
}