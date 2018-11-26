package com.fusemachines.contact.main.contact_List.presenter

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fusemachines.contact.main.contact_List.ContactListContract
import com.fusemachines.contact.main.contact_List.adapter.ContactListRecyclerView
import com.fusemachines.contact.main.contact_List.view.AddContactDetailsActivity
import com.fusemachines.contact.main.contact_List.view.ContactDetailsActivity
import com.fusemachines.contact.main.contact_List.view.ContactListView


class ContactListPresenter() : ContactListContract.ContactListPresenter, ContactListRecyclerView.OnClickListener {

    lateinit var contactListView: ContactListContract.ContactListView

    constructor(contactListView: ContactListContract.ContactListView) : this() {
        this.contactListView = contactListView
    }

    override fun setAdapter() {
        contactListView.recyclerViewObject().layoutManager = LinearLayoutManager(contactListView.getContext())
                as RecyclerView.LayoutManager?
        var adapter = ContactListRecyclerView(contactListView.setContactList())
        adapter.setOnClickListener(this)
        contactListView.recyclerViewObject().adapter = adapter
    }

    override fun redirectToAddContactActivity() {
        contactListView.getActivity().startActivityForResult(Intent(contactListView.getContext(),
                AddContactDetailsActivity::class.java), ContactListView.REQUEST_CODE)

    }

    override fun refreshAdapter() {
        contactListView.recyclerViewObject().adapter!!.notifyDataSetChanged()
    }

    override fun itemOnClicked(position: Int) {
        var intent = Intent(contactListView.getContext(), ContactDetailsActivity::class.java)
        intent.putExtra(ContactListView.CONTACT_OBJECT, contactListView.setContactList()[position])
        contactListView.getContext().startActivity(intent)
    }
}
