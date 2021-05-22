package com.peculiaruc.contactme.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.peculiaruc.contactme.data.Categories
import com.peculiaruc.contactme.databinding.ListCategoryItemBinding
import com.peculiaruc.contactme.ui.ContactsActivity

class CategoryAdapter:RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categories: MutableList<Categories> = mutableListOf()

    fun  setUpCategories(categoriesList: List<Categories>) {
        this.categories.addAll(categoriesList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ListCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bindItem(category)
        holder.itemView.setOnClickListener {
            if (position == 0){
                Toast.makeText(holder.itemView.context, "You just clicked Family", Toast.LENGTH_LONG).show()
            }
            if (position == 1){
                Toast.makeText(holder.itemView.context, "You just clicked Friends", Toast.LENGTH_LONG).show()
            }
            if (position == 2){
                Toast.makeText(holder.itemView.context, "You just clicked Work", Toast.LENGTH_LONG).show()
            }
            if (position == 3){
                Toast.makeText(holder.itemView.context, "You just clicked School", Toast.LENGTH_LONG).show()
            }
            val model = categories[position]

            val catName: String = model.contatname
            val catImage: Int = model.contatimage

            val  intent = Intent(holder.itemView.context, ContactsActivity::class.java)
            intent.putExtra("catNAME", catName)
            intent.putExtra("icatLogo", catImage)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return categories.size
    }
    inner class CategoryViewHolder(private val binding:
                                   ListCategoryItemBinding):RecyclerView.ViewHolder(binding.root){

        fun  bindItem(category: Categories){
            binding.imageCat.setImageResource(category.contatimage)
            binding.textCatName.text = category.contatname
        }
    }

//    name?.text = fact?.name
//
//    view?.setOnClickListener {
//        val intent = Intent(parent.context, DetailsActivity::class.java)
//        intent.putExtra(IMAGE_EXTRAS,fact?.image)
//        intent.putExtra(NAME_EXTRAS,fact?.name)
//        intent.putExtra(FACT_EXTRAS,fact?.fact)
//        parent.context.startActivity(intent)
//    }
//    return view!!
//}

companion object{
    val IMAGE_EXTRAS = "image_extras"
    val NAME_EXTRAS = "name_extras"
    val FACT_EXTRAS = "fact_extras"
}

}
