package com.example.tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Gestion> {
    List<Gestion> gestion;
    LayoutInflater inflater;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Gestion> objects) {
        super(context, resource, objects);
        gestion = new ArrayList<Gestion>(objects);
        inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_view, parent, false);
        }
        Gestion ges = gestion.get(position);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        image.setImageResource(ges.getImage());
        TextView text = (TextView) convertView.findViewById(R.id.textView);
        text.setText(ges.getMethode());
        return convertView;
    }
}
