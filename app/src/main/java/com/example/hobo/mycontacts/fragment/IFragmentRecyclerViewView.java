package com.example.hobo.mycontacts.fragment;

import com.example.hobo.mycontacts.adapter.ContactAdapter;
import com.example.hobo.mycontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/17/2017.
 */

public interface IFragmentRecyclerViewView {

    public void generateGridLayout();

    public ContactAdapter createAdapter (ArrayList<Contact> contacts);

    public void startAdapter (ContactAdapter adapter);

    public void refreshContent ();

}
