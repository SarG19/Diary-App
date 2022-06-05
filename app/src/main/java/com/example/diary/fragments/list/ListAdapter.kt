package com.example.diary.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diary.R
import com.example.diary.model.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.myDate.text = currentItem.Date
        holder.itemView.item_title.text = currentItem.Title
        holder.itemView.item_note.text = currentItem.Note

        /**holder.itemView.rowLayout.setOnClickListener {
        val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
        holder.itemView.findNavController().navigate(action)
        }*/
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}