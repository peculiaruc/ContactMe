package com.peculiaruc.contactme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.peculiaruc.contactme.R
import com.peculiaruc.contactme.adapter.CategoryAdapter
import com.peculiaruc.contactme.data.Categories
import com.peculiaruc.contactme.databinding.ActivityCategoryBinding
import com.peculiaruc.contactme.databinding.ActivityContactsBinding
import java.util.*

class CategoryActivity() : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    private val adapter  = CategoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryRecyclerView.adapter = adapter

        setUpData(binding)
    }
    private fun setUpData(binding: ActivityCategoryBinding){
        val categories = mutableListOf<Categories>()

        categories.add(Categories(R.drawable.family, "Family"))
        categories.add(Categories(R.drawable.colleague, "Colleagues"))
        categories.add(Categories(R.drawable.company, "Company"))
        categories.add(Categories(R.drawable.modern_tutor, "School"))
        categories.add(Categories(R.drawable.sports, "Sports"))
        categories.add(Categories(R.drawable.comm, "Community"))

        title = "Categories"
        binding.categoryRecyclerView.adapter = adapter
        binding.categoryRecyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter.setUpCategories(categories)
    }


    override fun onDestroy() {
        super.onDestroy()
        binding
    }
}

private fun Toolbar.setTitle(collapsingToolbarLayout: Any) {
    TODO("Not yet implemented")
}
