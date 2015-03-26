package org.sk.contacts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ContactAddActivity extends ActionBarActivity {


    EditText etName;
    EditText etNum;
    ImageView img;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);
        etName = (EditText) findViewById(R.id.etName);
        etNum = (EditText) findViewById(R.id.etNum);
        img = (ImageView) findViewById(R.id.img);
        tv = (TextView) findViewById(R.id.tvInfo);
    }


    public void addImage(View view){

        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camIntent, 1);
  }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
        }
    }

    public void addNewContact(View view){

        try{

          if(etName.getText().toString().equals("")|| etNum.getText().toString().equals("")){
                Toast.makeText(getBaseContext(),"you have empty fields",Toast.LENGTH_LONG).show();
            }else {
                Contact contact = new Contact();
                contact.setName(etName.getText().toString());
                contact.setNumber(etNum.getText().toString());
                contact.setImg(img);

                Contact.contactList.add(contact);

                Toast.makeText(getBaseContext(), "contact added successfully", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }

        }catch(Exception e){

            Toast.makeText(getBaseContext(),"failed..provide proper information",Toast.LENGTH_LONG).show();
        }

    }



}
