package com.example.hobo.mycontacts.restApi.model;

import com.example.hobo.mycontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/20/2017.
 */

public class ContactResponse {
    ArrayList<Contact> contacts;

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
