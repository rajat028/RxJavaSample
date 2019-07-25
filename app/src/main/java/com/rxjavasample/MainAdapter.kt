package com.rxjavasample

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.contact_list_layout.view.*

class MainAdapter(private val contacts: MutableList<ContactPojo>) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        Log.v("CreateViewHolder", "in onCreateViewHolder")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_layout, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {
        Log.v("BindViewHolder", "in onBindViewHolder")
        val contact = contacts[p1]
        holder.name.text = contact.mName
        holder.number.text = contact.number
        holder.addedOn.text = contact.addedOn
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.textView
        val number: TextView = itemView.textView2
        val addedOn: TextView = itemView.textView3
    }
}
