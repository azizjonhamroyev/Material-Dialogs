package com.hamroyevazizjon.materialdialogs

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager

internal interface MaterialDialogsHelper {

    fun googleLocationServicePermission()

    fun showSocialNetworkPickers()

    fun showDataAndTimePicker()

    fun wifiConnector()

    fun showColorPicker()
}