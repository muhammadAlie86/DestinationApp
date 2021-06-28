package com.example.destinationapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.destinationapp.databinding.ActivityDetailBinding
import com.example.destinationapp.databinding.ItemListDetailBinding
import com.example.destinationapp.model.Destination
import java.lang.StringBuilder

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ItemListDetailBinding

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val DETAIL_DESTINATION = "Detail Destination"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        detailBinding = activityDetailBinding.detailDestination
        title = DETAIL_DESTINATION
        detailBinding.progressBar.visibility = View.VISIBLE
        showDetailDestination()
    }
    private fun showDetailDestination(){
        val detailDestinationData = intent.getParcelableExtra<Destination>(EXTRA_DATA)

        if (detailDestinationData != null) {
            detailBinding.progressBar.visibility = View.GONE

            detailBinding.tvDetailName.text = detailDestinationData.name
            detailBinding.tvDetailLocation.text = detailDestinationData.location
            detailBinding.detailRatingBar.rating = detailDestinationData.rate
            detailBinding.detailImage.setImageResource(detailDestinationData.image)
            detailBinding.tvDetailDescription.text = StringBuilder("Overview :\n${detailDestinationData.description}")
        }
    }
}