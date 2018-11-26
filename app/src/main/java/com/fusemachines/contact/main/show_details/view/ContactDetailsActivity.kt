package com.fusemachines.contact.main.contact_List.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.fusemachines.contact.R
import com.fusemachines.contact.main.contact_List.model.AddContactDetails
import com.fusemachines.contact.main.contact_List.presenter.ContactDetailsPresenter
import com.fusemachines.contact.main.show_details.ContactDetailsContract
import kotlinx.android.synthetic.main.activity_contact_detail.*

open class ContactDetailsActivity : AppCompatActivity(), ContactDetailsContract.ContactDetailView {
    private lateinit var contactDetailPresenter: ContactDetailsContract.ContactDetailsPresenter
    private lateinit var contactObject: AddContactDetails
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        toolbar = findViewById(R.id.toolbar)

        contactObject = intent.getParcelableExtra<AddContactDetails>(ContactListView.CONTACT_OBJECT)
        toolbar.title = contactObject.fname + " " + contactObject.lname
        contactDetailPresenter = ContactDetailsPresenter(this)
        contactDetailPresenter.setAdapter()
    }

    override fun getContactObject(): ArrayList<String> {
        var contactNumberList = ArrayList<String>()
        contactNumberList.add(contactObject.mNum)
        contactNumberList.add(contactObject.hmNum)
        contactNumberList.add(contactObject.offNum)
        return contactNumberList
    }

    override fun recyclerViewObject(): RecyclerView {
        return rv_contactdetail
    }

    override fun getContext(): Context {
        return this
    }

    override fun getActivity(): Activity {
        return this
    }

}
