package com.oddeven.solution.service;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/**
 * Created by Parvesh on 22-07-2016.
 */
public class listAdapter extends BaseAdapter {




       LayoutInflater inflater;
     Context context;
     listAdapter(Context context){
             this.context=context;
         try {
             inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;

        if(view==null)
            view=inflater.inflate(R.layout.list_adapter,null);
        return view;
    }
}
