package com.fusemachines.contact.main.show_details

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView

class ContactDetailsContract {

    interface ContactDetailView {
        fun recyclerViewObject(): RecyclerView
        fun getContext(): Context
        fun getActivity(): Activity
        fun getContactObject(): ArrayList<String>
    }

    interface ContactDetailsModel{

    }

    interface ContactDetailsPresenter {
        fun setAdapter()
    }

}