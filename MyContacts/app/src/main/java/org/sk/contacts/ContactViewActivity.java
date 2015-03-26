package org.sk.contacts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ContactViewActivity extends ActionBarActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);
        listView = (ListView) findViewById(R.id.lvContacts);

        ArrayAdapter<Contact> adapter;
        adapter = new ArrayAdapter<Contact>(getBaseContext(),android.R.layout.simple_list_item_1, Contact.contactList);

        listView.setAdapter(adapter);
    }






}
