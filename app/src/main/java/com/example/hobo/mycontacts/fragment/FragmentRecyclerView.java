package com.example.hobo.mycontacts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hobo.mycontacts.presenter.FragmentRecycleViewPresenter;
import com.example.hobo.mycontacts.presenter.IFragmentRecyclerViewPresenter;
import com.example.hobo.mycontacts.R;
import com.example.hobo.mycontacts.adapter.ContactAdapter;
import com.example.hobo.mycontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/11/2017.
 */

public class FragmentRecyclerView extends Fragment implements IFragmentRecyclerViewView {
    private RecyclerView contactList;
    private IFragmentRecyclerViewPresenter iFragmentRecyclerViewPresenter;
    private SwipeRefreshLayout srl1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recylcer_view, container, false);
        srl1 = (SwipeRefreshLayout) view.findViewById(R.id.srl1);
        contactList = (RecyclerView) view.findViewById(R.id.rvContact);
        iFragmentRecyclerViewPresenter = new FragmentRecycleViewPresenter(this, getContext());
        srl1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
        return view;
    }


    @Override
    public void generateGridLayout() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        contactList.setLayoutManager(manager);
    }

    @Override
    public ContactAdapter createAdapter(ArrayList<Contact> contacts) {
        return new ContactAdapter(contacts, getActivity());
    }

    @Override
    public void startAdapter(ContactAdapter adapter) {
        contactList.setAdapter(adapter);
    }

    @Override
    public void refreshContent() {
        iFragmentRecyclerViewPresenter = new FragmentRecycleViewPresenter(this, getContext());
        srl1.setRefreshing(false);
    }
}
