package com.fusemachines.contact.main.contact_List.adapte

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fusemachines.contact.R
import kotlinx.android.synthetic.main.item_contact_detail.view.*



class ContactDetailRecyclerView() : RecyclerView.Adapter<ContactDetailRecyclerView.ViewHolder>() {

    private lateinit var contactList: ArrayList<String>

    constructor(contactList: ArrayList<String>) : this() {
        this.contactList = contactList
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactDetailRecyclerView.ViewHolder {

        return ContactDetailRecyclerView.ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_contact_detail, p0, false))
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(p0: ContactDetailRecyclerView.ViewHolder, p1: Int) {
        when (p1) {
            0 -> {
                p0?.title?.text = "MOBILE"
                p0?.icon?.setImageResource(R.mipmap.ic_mobile)
            }
            1 -> {
                p0?.title?.text = "HOME"
                p0?.icon?.setImageResource(R.mipmap.ic_home)
            }
            2 -> {
                p0?.title?.text = "OFFICE"
                p0?.icon?.setImageResource(R.mipmap.ic_office)
            }
        }
        p0?.number?.text = contactList.get(p1)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tv_contactdetail_title
        val number = view.tv_contactdetail_number
        val icon = view.img_contactdetail
    }
}