package com.wnadeem.animelist.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceFragmentCompat
import com.wnadeem.animelist.R
import com.wnadeem.animelist.databinding.FragmentSettingsBinding

class SettingsFragment : PreferenceFragmentCompat() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        setHasOptionsMenu(true)
//        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
//        binding.apply {
//            settingsDoneButton.setOnClickListener {
//                findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToNavigationHome())
//            }
//        }
//        return binding.root
//    }


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_fragment, rootKey)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}
