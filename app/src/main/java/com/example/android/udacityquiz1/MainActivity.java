package com.example.android.udacityquiz1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{


    private static final String NAME_KEY = "name";
    private static final String EMAIL_KEY = "email";
    private static final String ABOUT_KEY = "about";

    private EditText mName,mEmail,mAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.et_name);
        mEmail = (EditText) findViewById(R.id.et_email);
        mAbout = (EditText) findViewById(R.id.et_about);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(NAME_KEY)) {
                mName.setText(savedInstanceState.getCharSequence(NAME_KEY));
            }
            if (savedInstanceState.containsKey(EMAIL_KEY)) {
                mEmail.setText(savedInstanceState.getCharSequence(EMAIL_KEY));
            }
            if (savedInstanceState.containsKey(ABOUT_KEY)) {
                mAbout.setText(savedInstanceState.getCharSequence(ABOUT_KEY));
            }
        }

        //setupSharedPreferences();

    }
    public void submit(View v) {

        Context context = MainActivity.this;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(NAME_KEY,mName.getText().toString());
        editor.putString(EMAIL_KEY,mEmail.getText().toString());
        editor.putString(ABOUT_KEY,mAbout.getText().toString());

        editor.commit();

        Class destinationClass = SecondActivity.class;

        Intent startActivityIntent = new Intent(context,destinationClass);

        startActivity(startActivityIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemThatWasClicked = item.getItemId();

        if (itemThatWasClicked == R.id.action_move) {

            Context context = MainActivity.this;

            Class destinationClass = SecondActivity.class;

            Intent startActivityIntent = new Intent(context,destinationClass);

            startActivity(startActivityIntent);

            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        String nameEditTextContent = mName.getText().toString();
        String emailEditTextContent = mEmail.getText().toString();
        String aboutEditTextContent = mAbout.getText().toString();

        outState.putCharSequence(NAME_KEY,nameEditTextContent);
        outState.putCharSequence(EMAIL_KEY,emailEditTextContent);
        outState.putCharSequence(ABOUT_KEY,aboutEditTextContent);

    }

//    private void setupSharedPreferences() {
//        // Get all of the values from shared preferences to set it up
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//
//
//        mName.setText(sharedPreferences.getString(NAME_KEY,getResources().getString(R.string.name_hint)));
//        mEmail.setText(sharedPreferences.getString(EMAIL_KEY,getResources().getString(R.string.email_hint)));
//        mAbout.setText(sharedPreferences.getString(ABOUT_KEY,getResources().getString(R.string.about_hint)));
//
//        // Register the listener
//        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
//    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NameOfShared", "Value");

        if (s.equals(NAME_KEY)) {
            editor.putString(s,mName.getText().toString());
        }
        else if (s.equals(EMAIL_KEY)) {
            editor.putString(s,mEmail.getText().toString());
        }
        else if (s.equals(ABOUT_KEY)) {
            editor.putString(s,mAbout.getText().toString());
        }

        editor.commit();
    }
}
