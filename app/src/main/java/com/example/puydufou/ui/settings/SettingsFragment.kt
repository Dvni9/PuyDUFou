package com.example.puydufou.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.puydufou.databinding.FragmentSettingsBinding
import com.example.puydufou.utils.SharedPreferencesHelper

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = SharedPreferencesHelper(requireContext())

        setupListeners()
        loadCurrentSettings()
    }

    private fun setupListeners() {
        binding.buttonLanguage.setOnClickListener {
            Toast.makeText(context, "Idioma cambiado", Toast.LENGTH_SHORT).show()
        }

        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.setNotificationsEnabled(isChecked)
            Toast.makeText(context, "Notificaciones: ${if (isChecked) "ON" else "OFF"}", Toast.LENGTH_SHORT).show()
        }

        binding.buttonTheme.setOnClickListener {
            Toast.makeText(context, "Tema cambiado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadCurrentSettings() {
        binding.switchNotifications.isChecked = sharedPreferences.areNotificationsEnabled()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}