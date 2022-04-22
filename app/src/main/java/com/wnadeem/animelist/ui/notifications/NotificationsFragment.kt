package com.wnadeem.animelist.ui.notifications

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wnadeem.animelist.AnimeAdapter
import com.wnadeem.animelist.R
import com.wnadeem.animelist.databinding.FragmentNotificationsBinding
import com.wnadeem.animelist.ui.MainViewModel

class NotificationsFragment : Fragment() {

    private val sharedViewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentNotificationsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val animeAdapter = AnimeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {

            idFABAddAnime.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_notifications_to_dataEntryFragment)
            }
            idRVAnime.run {
                layoutManager = LinearLayoutManager(context)
                adapter = animeAdapter
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.allAnime.observe(viewLifecycleOwner) {
            animeAdapter.updateWords(it)
        }

        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ) = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val thisFriend = animeAdapter.getWordAtPosition(viewHolder.adapterPosition)
//                    context?.toast("Deleted: ${thisWord.title}")
                    //itemDeletedAlert(thisFriend)


                    val msg = resources.getString(R.string.deletion_alert)
                    val builder = AlertDialog.Builder(context)
                    with(builder) {
                        setTitle(R.string.alert)
                        setMessage(msg)

                        setPositiveButton(R.string.yes) { _, _ ->
                            sharedViewModel.deleteAnime(thisFriend)
                        }
                        setNegativeButton(R.string.no) { _, _ ->
                            animeAdapter.notifyDataSetChanged()
                        }
                        show()
                    }

                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.idRVAnime)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}