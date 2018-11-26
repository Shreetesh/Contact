package com.fusemachines.contact.main.add_details

import android.app.Activity
import android.content.Context
import com.fusemachines.contact.main.contact_List.model.AddContactDetails

class AddContactDetailsContract {

    interface  ACView  {


        fun getContext(): Context
        fun getActivity(): Activity
        fun newContactObject() : com.fusemachines.contact.main.contact_List.model.AddContactDetails

    }

    interface AddContactDetails{

    }

    interface AddContactDetailsPresenter{
        fun retrurnNewContact()
    }

}