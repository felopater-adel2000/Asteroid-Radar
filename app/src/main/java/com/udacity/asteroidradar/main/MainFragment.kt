package com.udacity.asteroidradar.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this

        val viewModelFactory = MainViewModelFactory(requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.viewModel = viewModel

        val adapter = AsteroidAdapter(OnAsteroidClickListener {
            Log.i("Felo", "OnClickItem")
            viewModel.onNavigationToDetails(it)
        })
        binding.asteroidRecycler.adapter = adapter
        viewModel.filterationAsteroid.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
        })

        viewModel.navigationToAsteroidDetails.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                val action = MainFragmentDirections.actionShowDetail(it)
                findNavController().navigate(action)
                viewModel.onCompleteNavigation()
            }
        })


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.show_today_asteroid -> viewModel.filterAsteroidsData(Constants.TODAY_ASTEROID)
            R.id.show_week_asteroid -> viewModel.filterAsteroidsData(Constants.WEEK_ASTEROID)
            R.id.show_saved_asteroid -> viewModel.filterAsteroidsData(Constants.SAVED_ASTEROID)
        }
        return true
    }
}
