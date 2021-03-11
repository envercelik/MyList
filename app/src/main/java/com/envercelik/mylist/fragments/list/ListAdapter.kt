package com.envercelik.mylist.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.envercelik.mylist.R
import com.envercelik.mylist.model.User
import kotlinx.android.synthetic.main.layout_user_item.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView ) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_user_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentUser = userList[position]

        holder.itemView.text_view_id.text = currentUser.uid.toString()
        holder.itemView.text_view_first_name.text = currentUser.firstName
        holder.itemView.text_view_last_name.text = currentUser.lastName
        holder.itemView.text_view_age.text = currentUser.age.toString()

        holder.itemView.layout_user_row.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentUser)
            holder.itemView.findNavController().navigate(action)
        }


    }


    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}