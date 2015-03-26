package org.sk.contacts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

 public void addContacts(View view){

     Intent intent = new Intent(getBaseContext(),ContactAddActivity.class);
     startActivity(intent);

 }

    public void viewContact(View view){

        Intent intent = new Intent(getBaseContext(),ContactViewActivity.class);
        startActivity(intent);
    }

}
