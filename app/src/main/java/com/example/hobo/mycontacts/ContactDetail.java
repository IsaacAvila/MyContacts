package com.example.hobo.mycontacts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContactDetail extends AppCompatActivity {

    private static final String EXTRA_URL   = "url";
    private static final String EXTRA_LIKES = "likes";

    private ImageView ivPhotoD;
    private TextView  tvLikesD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_photo);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvLikesD  = (TextView) findViewById(R.id.tvLikesD);
        ivPhotoD = (ImageView) findViewById(R.id.ivPhotoD);

        Bundle extras = getIntent().getExtras();

        String url   = extras.getString(EXTRA_URL);
        String likes = String.valueOf(extras.getInt(EXTRA_LIKES));

        tvLikesD.setText(likes);
        Picasso.with(this).load(url).placeholder(R.drawable.profile).into(ivPhotoD);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide(Gravity.TOP);
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(new Fade());
        }
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent index = new Intent(ContactDetail.this, MainActivity.class);
            startActivity(index);
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }*/
}
