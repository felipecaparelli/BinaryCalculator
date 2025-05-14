package com.example.binarycalculator.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.binarycalculator.databinding.FragmentDashboardBinding
import com.example.binarycalculator.model.BaseItem
import com.example.binarycalculator.ui.adapter.SpinnerAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val numberInput: EditText = binding.numberInput
        val baseSpinner: Spinner = binding.baseSpinner
        val convertButton: Button = binding.calculate
        val convertedNumber: TextView = binding.convertedNumber

        val bases = listOf(
            BaseItem("Binary", 2),
            BaseItem("Base 4", 4),
            BaseItem("Base 6", 6),
            BaseItem("Base 8", 8)
        )
        val adapter = SpinnerAdapter(this.requireContext(), bases)
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        baseSpinner.adapter = adapter

        dashboardViewModel.numberInput.observe(viewLifecycleOwner) {
            numberInput.setText(it.toString())
        }

        convertButton.setOnClickListener {
            val selectedBase = baseSpinner.selectedItem as BaseItem
            val result = convertNumber(numberInput.text.toString(), selectedBase.value)
            convertedNumber.text = result
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun convertNumber(number: String, base: Int): String {
         return try {
            Integer.toString(number.toInt(), base)

             val convertedNumber = Integer.toString(number.toInt(), base)
              if (base == 2) {
                convertedNumber.padStart(4, '0')
              } else {
                convertedNumber
              }
         } catch (e: NumberFormatException) {
            "Invalid number"
         }
    }
}