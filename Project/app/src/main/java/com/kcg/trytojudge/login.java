package com.kcg.trytojudge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void LoginButtonClick(View v) {

        Intent facebookIntent = new Intent(this, facebook.class);
        facebookIntent.putExtra("status", 0);
        startActivity(facebookIntent);

    }

}
