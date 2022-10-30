package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.databinding.AsteroidElementBinding

class AsteroidAdapter(val clickListener: OnAsteroidClickListener) : ListAdapter<Asteroid, RecyclerView.ViewHolder>(AsteroidDiffUtil())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AsteroidViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        (holder as AsteroidViewHolder).bind(getItem(position), clickListener)
    }

}

class OnAsteroidClickListener(val clickListener: (asteroid: Asteroid) -> Unit)
{
    fun onClick(asteroid: Asteroid)
    {
        clickListener(asteroid)
    }
}

class AsteroidDiffUtil : DiffUtil.ItemCallback<Asteroid>()
{
    override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean
    {
        return oldItem.id == newItem.id
    }

}

class AsteroidViewHolder(val binding: AsteroidElementBinding) : RecyclerView.ViewHolder(binding.root)
{
    companion object{
        fun create(parent: ViewGroup): AsteroidViewHolder
        {
            val infalor = LayoutInflater.from(parent.context)
            val binding = AsteroidElementBinding.inflate(infalor, parent, false)
            return AsteroidViewHolder(binding)
        }
    }

    fun bind(asteroid: Asteroid, clickListener: OnAsteroidClickListener)
    {
        binding.ast = asteroid
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }
}