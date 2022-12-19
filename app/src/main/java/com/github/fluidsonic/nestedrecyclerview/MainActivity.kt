package com.github.fluidsonic.nestedrecyclerview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)

		val recyclerView = findViewById<RecyclerView>(android.R.id.list)
		recyclerView.adapter = Adapter()
		recyclerView.layoutManager = LinearLayoutManager(this)
	}


	private class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

		private val inputPosition = 8
		private val itemCount = 25


		override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = Unit


		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
			object : RecyclerView.ViewHolder(
				LayoutInflater.from(parent.context)
					.inflate(
						when (viewType) {
							ItemType.dummy -> R.layout.item_dummy
							ItemType.input -> R.layout.item_input
							else -> error("Unknown view type: $viewType")
						},
						parent,
						false
					)
			) {}


		override fun getItemCount() =
			itemCount


		override fun getItemViewType(position: Int) =
			if (position == inputPosition) ItemType.input else ItemType.dummy


		private object ItemType {

			val dummy = 1
			val input = 2
		}
	}
}
