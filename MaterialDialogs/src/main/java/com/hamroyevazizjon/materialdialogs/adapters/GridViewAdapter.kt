package com.hamroyevazizjon.materialdialogs.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.hamroyevazizjon.materialdialogs.R
import com.hamroyevazizjon.materialdialogs.databinding.ColorPickerItemBinding

class GridViewAdapter(var list: List<String>) : BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): String = list[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val binding = ColorPickerItemBinding.bind(
            p1 ?: LayoutInflater.from(p2?.context).inflate(R.layout.color_picker_item, p2,false)
        )
        binding.card.setCardBackgroundColor(Color.parseColor(list[p0]))
        return binding.root
    }

}