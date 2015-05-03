package com.example.zhuxuekui.contactstest;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    ListView contactsView;
    ArrayAdapter<String> adapter;
    List<String> contactsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readContacts();
        contactsView = (ListView)findViewById(R.id.contacts_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        contactsView.setAdapter(adapter);
    }

    private void readContacts()
    {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            while (cursor.moveToNext())
            {
               // String str1 = cursor.getString(cursor.getColumnIndex("ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME"));
              //  String str2 = cursor.getString(cursor.getColumnIndex("ContactsContract.CommonDataKinds.Phone.NUMBER"));
              //  contactsList.add(str1 + "\n" + str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor != null)
                cursor.close();//当游标里面没有数据的时候，我们要关掉它
        }
    }
}
