package com.fusemachines.contact.main.contact_List.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fusemachines.contact.R
import com.fusemachines.contact.main.add_details.AddContactDetailsContract
import com.fusemachines.contact.main.add_details.AddContactDetailsContract.AddContactDetails
import com.fusemachines.contact.main.contact_List.presenter.AddContactDetailPresenter
import kotlinx.android.synthetic.main.activity_add_contact_view.*

class AddContactDetailsActivity : AppCompatActivity(), AddContactDetailsContract.ACView {

    private lateinit var addContactDetailsPresenter: AddContactDetailsContract.AddContactDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact_view)

        addContactDetailsPresenter = AddContactDetailPresenter(this)
        btn_addcontact_done.setOnClickListener {
        addContactDetailsPresenter.retrurnNewContact()
        }
    }

    override fun getContext(): Context {
        return this
    }

    override fun newContactObject(): com.fusemachines.contact.main.contact_List.model.AddContactDetails {
        var fname = et_addcontact_name.text.toString()
        var lastName = et_addcontact_lastname.text.toString()
        var mobileNumber = et_addcontact_mobilenumber.text.toString()
        var homeNumber = et_addcontact_homenumber.text.toString()
        var officeNumber = et_addcontact_officenumber.text.toString()

        var addContactModel = com.fusemachines.contact.main.contact_List.model.AddContactDetails(fname, lastName, mobileNumber, homeNumber, officeNumber)

        return addContactModel
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun onBackPressed() {
       addContactDetailsPresenter.retrurnNewContact()
    }
}


