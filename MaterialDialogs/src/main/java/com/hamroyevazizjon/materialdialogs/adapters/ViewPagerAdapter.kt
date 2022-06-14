package com.hamroyevazizjon.materialdialogs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamroyevazizjon.materialdialogs.R
import com.hamroyevazizjon.materialdialogs.databinding.PageColorPickerBinding

class ViewPagerAdapter(var list: List<List<String>>, var onClicks: OnClicks) :
    RecyclerView.Adapter<ViewPagerAdapter.Vh>() {

    inner class Vh(var itemViewBinding: PageColorPickerBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun onBind(list: List<String>) {
            itemViewBinding.grid.adapter = GridViewAdapter(list)
            itemViewBinding.grid.setOnItemClickListener { adapterView, view, i, l ->
                onClicks.itemClick(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.page_color_picker, parent, false)
        return Vh(PageColorPickerBinding.bind(view))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnClicks {
        fun itemClick(view: View)
    }
}