package org.sk.contacts;

import android.text.Editable;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by sk on 25-03-2015.
 */
public class Contact {

    static ArrayList<Contact> contactList = new ArrayList<Contact>();
    private String name;
    private String number;
    private ImageView img;

    public void setName(String name){
        this.name=name;
    }

    public void setNumber(String number){
        this.number=number;
    }

    public void setImg(ImageView img){
        this.img = img;
    }

    public String getName(){
        return name;
    }


    public String toString(){
        return name;
    }

}
