package com.fusemachines.contact.main.contact_List.presenter

import android.content.Intent
import com.fusemachines.contact.main.add_details.AddContactDetailsContract
import com.fusemachines.contact.main.contact_List.view.AddContactDetailsActivity
import com.fusemachines.contact.main.contact_List.view.ContactListView

class AddContactDetailPresenter() : AddContactDetailsContract.AddContactDetailsPresenter{

    private lateinit var addContactDetailsActivity: AddContactDetailsContract.ACView

    constructor(addContactDetailsActivity: AddContactDetailsContract.ACView) : this(){
        this.addContactDetailsActivity = addContactDetailsActivity
    }

    override fun retrurnNewContact() {
        var intent = Intent()
        intent.putExtra(ContactListView.CONTACT_OBJECT,addContactDetailsActivity.newContactObject())
        addContactDetailsActivity.getActivity().setResult(ContactListView.REQUEST_CODE, intent)
        addContactDetailsActivity.getActivity().finish()
    }
}



