package com.zestworks.androidrepository

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.listing_fragment.*
import org.koin.android.architecture.ext.viewModel


class ListingFragment : Fragment() {

    private val listingViewModel: ListingViewModel by viewModel()
    lateinit var onsharedPreferenceChangeListener: SharedPreferences.OnSharedPreferenceChangeListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.listing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        count_text.text = "count: "+context?.getSharedPreferences("THANDAM",Context.MODE_PRIVATE)?.getInt("COUNT",0)?.toString()
        hello_button.setOnClickListener {
            listingViewModel.editSharedPref()
        }
        onsharedPreferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            val count = sharedPreferences.getInt("COUNT", 0)
            count_text.text = "count: $count"
        }
        context?.getSharedPreferences("THANDAM",Context.MODE_PRIVATE)?.registerOnSharedPreferenceChangeListener(onsharedPreferenceChangeListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        context?.getSharedPreferences("THANDAM",Context.MODE_PRIVATE)?.unregisterOnSharedPreferenceChangeListener(onsharedPreferenceChangeListener)
    }

}
