package com.ks_pem01.shopping_list_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ks_pem01.shopping_list_02.dummy.DummyContent;

import java.util.List;

/**
 * Created by katrinschauer on 27.10.15.
 */
public class GroceriesArrayAdapter<D> extends ArrayAdapter<D> {

    private final Context context;
    private final List<D> items;
    private final int layoutResourceId;

    public GroceriesArrayAdapter(Context context, int layoutResourceId, List<D> items) {
        super(context, layoutResourceId, items);

        this.context = context;
        this.items = items;
        this.layoutResourceId = layoutResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layoutResourceId, parent, false);

        TextView firstLine = (TextView) rowView.findViewById(R.id.firstLine);
        TextView secondLine = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        DummyContent.DummyItem item = (DummyContent.DummyItem) getItem(position);

        firstLine.setText(item.getFirstLine());
        secondLine.setText(item.getSecondLine());

        int imageResource = context.getResources().getIdentifier(item.getUri(), null, context.getPackageName());
        imageView.setImageResource(imageResource);


        return rowView;
    }

}
