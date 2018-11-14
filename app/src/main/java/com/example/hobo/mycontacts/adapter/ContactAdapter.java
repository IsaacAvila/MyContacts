package com.example.hobo.mycontacts.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hobo.mycontacts.pojo.Contact;
import com.example.hobo.mycontacts.ContactDetail;
import com.example.hobo.mycontacts.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/7/2017.
 */

public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<Contact> contacts;
    private Activity activity;

    public ContactAdapter(ArrayList<Contact> contacts, Activity activity) {
        this.contacts = contacts;
        this.activity = activity;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contact, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        final Contact contact = contacts.get(position);
        Picasso.with(activity).load(contact.getUrlPhoto()).placeholder(R.drawable.profile).into(holder.ivPhotoCV);
        String likesText = String.valueOf(contact.getLikes()) + " Likes";
        holder.tvLikes.setText(likesText);

        holder.ivPhotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show = new Intent(activity, ContactDetail.class);
                show.putExtra("url", contact.getUrlPhoto());
                show.putExtra("likes", contact.getLikes());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(
                            show,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(
                                    activity,
                                    v,
                                    activity.getString(R.string.transition_name)
                            ).toBundle()
                    );
                } else {
                    activity.startActivity(show);
                }
            }
        });

        //For set a context menu
        activity.registerForContextMenu(holder.ivPhotoCV);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView   ivPhotoCV;
        private TextView    tvLikes;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivPhotoCV = (ImageView)   itemView.findViewById(R.id.ivPhotoCV);
            tvLikes   = (TextView)    itemView.findViewById(R.id.tvLikes);
        }
    }
}
