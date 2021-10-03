package com.example.androidsqliteview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataListAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public DataListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.fetch_layout, parent, false);

        TextView NAME = (TextView) convertView.findViewById(R.id.nameHere);
        TextView CONTACT = (TextView) convertView.findViewById(R.id.contactHere);
        TextView EMAIL = (TextView) convertView.findViewById(R.id.emailHere);

        DataProvider dataProvider = (DataProvider) this.getItem(position);
        NAME.setText(dataProvider.getName());
        CONTACT.setText(dataProvider.getContact());
        EMAIL.setText(dataProvider.getEmail());

        return convertView;
    }

}
