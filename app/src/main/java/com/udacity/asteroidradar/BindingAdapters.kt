package com.udacity.asteroidradar

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.udacity.asteroidradar.database.PictureEntity

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
        val imageDescription = imageView.context.getString(R.string.potentially_hazardous_asteroid_image)
        imageView.contentDescription = imageDescription
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
        val imageDescription = imageView.context.getString(R.string.not_hazardous_asteroid_image)
        imageView.contentDescription = imageDescription
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous)
    {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
        imageView.contentDescription = imageView.context.getString(R.string.potentially_hazardous_asteroid_image)
    }
    else
    {
        imageView.setImageResource(R.drawable.asteroid_safe)
        imageView.contentDescription = imageView.context.getString(R.string.not_hazardous_asteroid_image)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}

@BindingAdapter("pictureOfDate")
fun bindPictureUrl(imageView: ImageView, picture: PictureEntity?)
{
    if(picture != null)
    {
        val imgUrl = picture.url.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUrl)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image))
            .into(imageView)
        imageView.contentDescription = String.format(imageView.resources.getString(R.string.nasa_picture_of_day_content_description_format), picture.title)
        Log.i("Felo", picture.title)
    }
}
