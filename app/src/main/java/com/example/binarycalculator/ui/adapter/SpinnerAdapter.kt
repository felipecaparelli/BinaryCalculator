package com.example.binarycalculator.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.binarycalculator.R
import com.example.binarycalculator.model.BaseItem

class SpinnerAdapter(context: Context, items: List<BaseItem>) : ArrayAdapter<BaseItem>(context, R.layout.base_item, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val item = getItem(position)
        (view as TextView).text = item?.label
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val item = getItem(position)
        (view as TextView).text = item?.label
        return view
    }
}
