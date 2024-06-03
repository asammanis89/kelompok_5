package com.example.project179.Domain

import java.io.Serializable

class PropertyDomain(
    var type: String,
    var title: String,
    var address: String,
    var pickPath: String,
    var price: Int,
    var bed: Int,
    var bath: Int,
    var size: Int,
    var isGarage: Boolean,
    var score: Double,
    var description: String
) : Serializable
