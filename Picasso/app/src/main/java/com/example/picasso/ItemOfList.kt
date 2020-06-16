package com.example.picasso

import java.io.Serializable

class ItemOfList(val imageURL: String): Serializable{
    companion object{
        fun getAndroidVersionList(): List<ItemOfList>{
            val versionList = ArrayList<ItemOfList>()
            versionList.clear()
            versionList.add(ItemOfList("https://raw.githubusercontent.com/AndroidCodility/Picasso-RecyclerView/master/images/Froyo.jpg"))
            versionList.add(ItemOfList("https://raw.githubusercontent.com/AndroidCodility/Picasso-RecyclerView/master/images/Ice-Cream-Sandwitch.png"))
            versionList.add(ItemOfList("https://raw.githubusercontent.com/AndroidCodility/Picasso-RecyclerView/master/images/cup_cake.png"))
            versionList.add(ItemOfList("https://raw.githubusercontent.com/AndroidCodility/Picasso-RecyclerView/master/images/donut.png"))
            versionList.add(ItemOfList("https://raw.githubusercontent.com/AndroidCodility/Picasso-RecyclerView/master/images/eclair.png"))
            return versionList
        }
    }
}