package com.fusemachines.contact.main.contact_List

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import com.fusemachines.contact.main.contact_List.model.AddContactDetails

class ContactListContract() {

    interface ContactListView {
        fun setContactList(): ArrayList<AddContactDetails>
        fun recyclerViewObject(): RecyclerView
        fun getContext(): Context
        fun getActivity(): Activity
    }

    interface ContactListModel {

    }

    interface ContactListPresenter {
        fun setAdapter()
        fun redirectToAddContactActivity()
        fun refreshAdapter()
    }
}