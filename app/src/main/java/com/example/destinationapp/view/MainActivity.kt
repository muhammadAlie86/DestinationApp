package com.example.destinationapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.destinationapp.R
import com.example.destinationapp.adapter.ListDestinationAdapter
import com.example.destinationapp.databinding.ActivityMainBinding
import com.example.destinationapp.model.Destination
import com.example.destinationapp.model.DestinationData
import com.example.destinationapp.utils.DataCallback

class MainActivity : AppCompatActivity(),DataCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listDestinationAdapter: ListDestinationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listDestinationAdapter = ListDestinationAdapter(this)

        binding.progressBar.visibility = View.VISIBLE

        init()
        setupRecyclerView()
    }
    private fun init(){
        val dataDestination = DestinationData.generateDataDestination()
        binding.progressBar.visibility = View.GONE
        listDestinationAdapter.setDestination(dataDestination)
        listDestinationAdapter.notifyDataSetChanged()
    }
    private fun setupRecyclerView(){

        with(binding.rvDestination) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listDestinationAdapter
        }
    }

    override fun setData(destination: Destination) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA,destination)
        startActivity(intent)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
