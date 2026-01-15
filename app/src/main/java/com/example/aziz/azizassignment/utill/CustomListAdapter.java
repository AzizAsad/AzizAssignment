package com.example.aziz.azizassignment.utill;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aziz.azizassignment.R;
import com.example.aziz.azizassignment.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Aziz on 2/3/2024.
 */
public abstract class CustomListAdapter extends ArrayAdapter<Product> {

    ArrayList<Product> products;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);

        }
        final Product product = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewUser);
        Picasso.with(context).load(product.getPicture().getThumbnail()).into(imageView);

        TextView txtGender = (TextView) convertView.findViewById(R.id.txtName);
        txtGender.setText(product.getName().getTitle() + " " + product.getName().getFirst() + " " + product.getName().getLast());

        TextView txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
        txtEmail.setText(product.getEmail());

        LinearLayout LL = (LinearLayout) convertView.findViewById(R.id.LL);
        LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to second activity

                onClickonProduct(product);

            }
        });

        return convertView;
        
    }

    abstract public void onClickonProduct(Product product);
}
