package com.kcg.trytojudge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.koushikdutta.ion.*;

public class myinfo extends Activity {

    private ImageView my_picture;
    private TextView my_name;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        String myId = getIntent().getStringExtra("my_id");
        String myName = getIntent().getStringExtra("my_name");

        my_picture = (ImageView)findViewById(R.id.profileImg);
        my_name = (TextView)findViewById(R.id.profileName);

        Ion.with(my_picture)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .load("http://graph.facebook.com/" + myId + "/picture?type=large");

        my_name.setText(myName);

    }

    public void LogoutButtonClick(View v) {

        Intent facebookIntent = new Intent(this, facebook.class);
        facebookIntent.putExtra("status", 1);
        this.finish();
        startActivity(facebookIntent);

    }

}
