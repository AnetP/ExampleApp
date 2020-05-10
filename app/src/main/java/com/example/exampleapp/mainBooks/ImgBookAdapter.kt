package com.example.exampleapp.mainBooks


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.databinding.GridItemBinding


class ImgBookAdapter(private val onClickListen: onClickListen) : ListAdapter<com.example.exampleapp.Result, ImgVH>(ImgVH.Diffcalld) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgVH {
        return ImgVH(GridItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImgVH, position: Int) {
        var b = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListen.onClick(b)
        }
        return holder.bind(b)
    }

}

class onClickListen(val click: (book:com.example.exampleapp.Result)->Unit){
    fun onClick(book:com.example.exampleapp.Result)= click(book)
}



class ImgVH(private var binding: GridItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(book: com.example.exampleapp.Result) {
            binding.book = book
            binding.executePendingBindings()

    }

    companion object Diffcalld: DiffUtil.ItemCallback<com.example.exampleapp.Result>() {
        override fun areItemsTheSame(oldItem: com.example.exampleapp.Result, newItem: com.example.exampleapp.Result): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: com.example.exampleapp.Result, newItem: com.example.exampleapp.Result): Boolean {
            return oldItem.book==newItem.book
        }
    }
}

