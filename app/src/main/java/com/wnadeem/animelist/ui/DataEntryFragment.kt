package com.wnadeem.animelist.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.wnadeem.animelist.Anime
import com.wnadeem.animelist.databinding.FragmentDataEntryBinding
import com.wnadeem.animelist.R


private const val TAG = "AddItemDialog"

class DataEntryFragment : Fragment(){

    private val sharedViewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentDataEntryBinding? = null
    private val binding get() = _binding!!
    private var newAnime = Anime()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View {

        _binding = FragmentDataEntryBinding.inflate(inflater, container, false)

        binding.apply {

//            ArrayAdapter.createFromResource(
//                pronounsid.context,
//                R.array.pronouns,
//                android.R.layout.simple_spinner_item
//            ).also { adapter ->
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//                pronounsid.adapter = adapter
//            }




            submitbtn.setOnClickListener {

                var anime = Anime()
                anime.animePicTitle = animePic.text.toString()
                anime.animeNameTitle = firstnameid.text.toString()
                anime.friendNameTitle = lastnameid.text.toString()
                anime.categoryTitle = nicknameid.text.toString()
                anime.scoreTitle = commentid.text.toString()
                anime.notes = notesid.text.toString()
                sharedViewModel.addAnime(anime)
                itemaddAlert(anime)

                findNavController().navigate(R.id.action_dataEntryFragment_to_navigation_notifications)
                context?.hideKeyboard(it)
            }
            Cancelbtn.setOnClickListener {

                findNavController().navigate(R.id.action_dataEntryFragment_to_navigation_notifications)
                context?.hideKeyboard(it)
            }

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun itemaddAlert(anime: Anime) {
        val msg = resources.getString(R.string.AlertDialog) + " " +  anime.animeNameTitle
        val builder = AlertDialog.Builder(context)
        with(builder) {
            setTitle(R.string.AlertDialog)
            setMessage(msg)
            setPositiveButton(R.string.ok, null)
            show()
        }
    }





}


fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

