package com.fusemachines.contact.main.contact_List.model

import android.os.Parcel
import android.os.Parcelable

data class AddContactDetails (val fname: String, val lname : String, var mNum : String, var hmNum : String, var offNum : String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(mNum)
        parcel.writeString(hmNum)
        parcel.writeString(offNum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddContactDetails> {
        override fun createFromParcel(parcel: Parcel): AddContactDetails {
            return AddContactDetails(parcel)
        }

        override fun newArray(size: Int): Array<AddContactDetails?> {
            return arrayOfNulls(size)
        }
    }
}
