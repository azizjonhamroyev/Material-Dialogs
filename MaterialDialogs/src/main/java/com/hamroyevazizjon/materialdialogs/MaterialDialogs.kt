package com.hamroyevazizjon.materialdialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator
import com.hamroyevazizjon.materialdialogs.adapters.ViewPagerAdapter
import com.hamroyevazizjon.materialdialogs.databinding.ColorPickerBinding
import com.hamroyevazizjon.materialdialogs.databinding.WifiConnectorBinding

class MaterialDialogs(var context: Context) : MaterialDialogsHelper {
    override fun googleLocationServicePermission() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Use Google's Location Services?")
        builder.setMessage("Let Google help apps determine location. This means sending anonymous location dats to Google, even when no apps are running.")
        builder.setPositiveButton("agree") { a, _ -> a.dismiss() }
        builder.setNegativeButton("disagree") { a, _ -> a.dismiss() }
        builder.create().show()
    }

    override fun showSocialNetworkPickers() {
        val builder = AlertDialog.Builder(context)
        builder.setMultiChoiceItems(
            arrayOf("Twitter", "Google+", "Instagram", "Facebook"),
            booleanArrayOf(false, false, false, false)
        ) { _, _, _ -> }
        builder.setTitle("Social Networks")
        builder.setPositiveButton("choose") { it, _ -> it.dismiss() }
        builder.show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun showDataAndTimePicker() {
        val datePickerDialog = DatePickerDialog(context)
        datePickerDialog.setTitle("Show date and time")
        datePickerDialog.show()
    }

    override fun wifiConnector() {
        val bottomDialog = BottomSheetDialog(context)
        val binding = WifiConnectorBinding.bind(
            LayoutInflater.from(context).inflate(R.layout.wifi_connector, null, false)
        )

        bottomDialog.setContentView(binding.root)
        binding.showPassword.setOnCheckedChangeListener { _, b ->
            if (b) binding.password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            else binding.password.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            binding.password.setSelection(binding.password.length())
        }
        binding.connectBtn.setOnClickListener {
            bottomDialog.dismiss()
        }
        binding.cancel.setOnClickListener { bottomDialog.dismiss() }
        bottomDialog.show()
    }

    override fun showColorPicker() {
        var lastSelected: View? = null
        val dialog = BottomSheetDialog(context)
        val binding = ColorPickerBinding.bind(
            LayoutInflater.from(context).inflate(
                R.layout.color_picker,
                null,
                false
            )
        )

        val colors = listOf(
            listOf(
                "#000000",
                "#be0027",
                "#cf8d2e",
                "#e4e932",
                "#2c9f45",
                "#371777",
                "#52325d",
                "#511378",
                "#008080",
                "#0000FF",
                "#000080",
                "#FF00FF",
                "#800080",
                "#EB984E",
                "#D5D8DC",
                "#1C2833"
            ),
            listOf(
                "#ff0000",
                "#fbb034",
                "#ffdd00",
                "#c1d82f",
                "#00a4e4",
                "#8a7967",
                "#6a737b",
                "#a51890",
                "#55FF33",
                "#E333FF",
                "#33C4FF",
                "#7733FF",
                "#FF337A",
                "#D4E6F1",
                "#EDBB99",
                "#3498DB"
            )
        )
        dialog.setContentView(binding.root)
        binding.viewPager2.adapter = ViewPagerAdapter(colors, object : ViewPagerAdapter.OnClicks {
            override fun itemClick(view: View) {
                binding.selectBtn.setTextColor(Color.parseColor("#FF6200EE"))
                if (lastSelected == null) {
                    lastSelected = view
                    view.setBackgroundResource(R.drawable.color_picker_item_selected_background)
                } else {
                    lastSelected?.setBackgroundResource(R.drawable.color_picker_item_design)
                    lastSelected = view
                    view.setBackgroundResource(R.drawable.color_picker_item_selected_background)
                }
            }

        })
        TabLayoutMediator(
            binding.tab, binding.viewPager2
        ) { _, _ -> }.attach()
        binding.selectBtn.setOnClickListener { dialog.dismiss() }
        binding.cancel.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

}