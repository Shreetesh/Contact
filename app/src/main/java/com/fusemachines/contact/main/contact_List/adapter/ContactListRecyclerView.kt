package com.fusemachines.contact.main.contact_List.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fusemachines.contact.R
import com.fusemachines.contact.main.contact_List.model.AddContactDetails
import kotlinx.android.synthetic.main.item_contact_list.view.*
import java.util.*

class ContactListRecyclerView() : RecyclerView.Adapter<ContactListRecyclerView.ViewHolder>() {

    private var contactList: ArrayList<AddContactDetails>? = null
    private lateinit var onClickListener: OnClickListener

    constructor(contactList: ArrayList<AddContactDetails>) : this() {
        this.contactList = contactList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactListRecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_contact_list, p0, false))
    }

    override fun getItemCount(): Int {
        return contactList!!.size
    }

    override fun onBindViewHolder(p0: ContactListRecyclerView.ViewHolder, p1: Int) {
        p0?.nameTextView?.text = contactList!!.get(p1).fname + " " + contactList!!.get(p1).lname
        p0?.constraintLayoutContainer?.setOnClickListener {
            onClickListener.itemOnClicked(p1)
        }
    }


    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.textView_contactname
        val constraintLayoutContainer = view.constraint_contactname
    }

    interface OnClickListener {
        fun itemOnClicked(position: Int)
    }
}