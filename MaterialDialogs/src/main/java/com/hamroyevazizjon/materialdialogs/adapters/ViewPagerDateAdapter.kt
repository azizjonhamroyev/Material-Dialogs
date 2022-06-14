package com.hamroyevazizjon.materialdialogs.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamroyevazizjon.materialdialogs.R
import com.hamroyevazizjon.materialdialogs.databinding.ViewPagerDateItemBinding

class ViewPagerDateAdapter : RecyclerView.Adapter<ViewPagerDateAdapter.Vh>() {

    inner class Vh(val itemViewBinding: ViewPagerDateItemBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun onBind(position: Int) {
            if (position == 0) {
                itemViewBinding.datePicker.calendarViewShown = true
                itemViewBinding.datePicker.spinnersShown = false
            } else {
                itemViewBinding.datePicker.calendarViewShown = false
                itemViewBinding.datePicker.spinnersShown = true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ViewPagerDateItemBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_pager_date_item, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = 2;
}