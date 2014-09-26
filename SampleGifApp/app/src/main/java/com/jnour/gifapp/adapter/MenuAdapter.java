package com.jnour.gifapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jnour.gifapp.R;

import java.util.ArrayList;

/**
 * Created by njabal on 26/09/2014.
 */
public class MenuAdapter extends ArrayAdapter {
    private final Context mContext;
    private String[] mListTitles;
    private String[] mListDescTitles;

    public MenuAdapter(Context context, String[] listTitles, String[] listDescTitles) {
        super(context,0, listTitles);
        this.mContext = context;
        this.mListTitles = listTitles;
        this.mListDescTitles = listDescTitles;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = convertView;


        rowView = inflater.inflate(R.layout.adapter_main_list_2, null);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.adapter_title);
        txtTitle.setText(mListTitles[position]);


//        TextView txtDesc = (TextView) rowView.findViewById(R.id.adapter_desc);
//        txtDesc.setText(mListDescTitles[position]);




        return rowView;
    }




}
