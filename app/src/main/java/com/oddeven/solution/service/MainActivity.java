package com.oddeven.solution.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.security.KeyStore;
import java.security.KeyStoreException;

public class MainActivity extends AppCompatActivity {



     ListView listView;
     listAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  startService(new Intent(getBaseContext(),Service_.class));

        adapter=new listAdapter(getApplicationContext());

        listView=(ListView)findViewById(R.id.keyList);
        View listHeader=View.inflate(getApplicationContext(),R.layout.list_header,null);
        listView.addHeaderView(listHeader);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        try {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
