package com.example.android.udacityquiz1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mEmail;
    private TextView mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mName =  findViewById(R.id.tv_name);
        mEmail =  findViewById(R.id.tv_email);
        mAbout =  findViewById(R.id.tv_about);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        mName.setText(sharedPreferences.getString(getResources().getString(R.string.name_key),getResources().getString(R.string.name_hint)));
        mEmail.setText(sharedPreferences.getString(getResources().getString(R.string.email_key),getResources().getString(R.string.email_hint)));
        mAbout.setText(sharedPreferences.getString(getResources().getString(R.string.about_key),getResources().getString(R.string.about_hint)));

    }
}
