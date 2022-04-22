package com.wnadeem.animelist.ui.dashboard

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.wnadeem.animelist.BuildConfig
import com.wnadeem.animelist.R
import com.wnadeem.animelist.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.appname
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

//            buildTimeTextView.text = BuildConfig.BUILD_TIME

            appname.text = resources.getString(R.string.app_name)
            appversion.text = BuildConfig.VERSION_NAME
            copyright.text = resources.getString(R.string.copyright)

//            if (BuildConfig.DEBUG) {
//                debugBuildTextView.visibility = View.VISIBLE
//            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}