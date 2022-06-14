package com.hamroyevazizjon.materialdialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hamroyevazizjon.materialdialogs.adapters.ViewPagerDateAdapter
import com.hamroyevazizjon.materialdialogs.databinding.DatePickerBinding

class FragmentDatePicker : DialogFragment() {

    lateinit var binding: DatePickerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DatePickerBinding.inflate(inflater, container, false)
        binding.viewPager2.adapter = ViewPagerDateAdapter()
        TabLayoutMediator(binding.tab, binding.viewPager2) { _, _ -> }.attach()

        return binding.root
    }
}