package com.fusemachines.contact.main.contact_List.presenter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fusemachines.contact.main.contact_List.adapte.ContactDetailRecyclerView
import com.fusemachines.contact.main.show_details.ContactDetailsContract


class ContactDetailsPresenter : ContactDetailsContract.ContactDetailsPresenter {

    private lateinit var contactDetailsActivity: ContactDetailsContract.ContactDetailView

    constructor(contactDetailsActivity: ContactDetailsContract.ContactDetailView) {
        this.contactDetailsActivity = contactDetailsActivity
    }

    override fun setAdapter() {
        contactDetailsActivity.recyclerViewObject().layoutManager = LinearLayoutManager(contactDetailsActivity.getContext())
                as RecyclerView.LayoutManager?
        var adapter = ContactDetailRecyclerView(contactDetailsActivity.getContactObject())
        contactDetailsActivity.recyclerViewObject().adapter = adapter
    }
}
