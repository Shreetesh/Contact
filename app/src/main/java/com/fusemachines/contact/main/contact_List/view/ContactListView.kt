package com.fusemachines.contact.main.contact_List.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.fusemachines.contact.R
import com.fusemachines.contact.main.contact_List.ContactListContract
import com.fusemachines.contact.main.contact_List.adapter.ContactListRecyclerView
import com.fusemachines.contact.main.contact_List.model.AddContactDetails
import com.fusemachines.contact.main.contact_List.presenter.ContactListPresenter
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListView : AppCompatActivity(), ContactListContract.ContactListView, ContactListRecyclerView.OnClickListener {

    private var namesList = ArrayList<AddContactDetails>()
    private lateinit var toolbar: Toolbar

    companion object {
        const val CONTACT_OBJECT = "CONTACT_OBJECT"
        const val REQUEST_CODE = 1
    }

    override fun getActivity(): Activity {
        return this
    }

    private lateinit var contactListPresenter: ContactListContract.ContactListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        contactListPresenter = ContactListPresenter(this)
        contactListPresenter.setAdapter()
    }
    override fun setContactList(): ArrayList<AddContactDetails> {
        return namesList
    }
    override fun recyclerViewObject(): RecyclerView {
        return rv_contact_names
    }
    override fun getContext(): Context {
        return this
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contact_menu_view, menu);
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.button_menu_add -> {
                    contactListPresenter.redirectToAddContactActivity()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            ContactListView.REQUEST_CODE -> {
                namesList.add(data!!.getParcelableExtra<AddContactDetails>(ContactListView.CONTACT_OBJECT))
                contactListPresenter.refreshAdapter()
            }
        }
    }
    override fun itemOnClicked(position: Int) {
        Toast.makeText(this, "Action", Toast.LENGTH_LONG).show()
    }
}

