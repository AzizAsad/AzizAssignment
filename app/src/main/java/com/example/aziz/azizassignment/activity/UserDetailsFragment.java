package com.example.aziz.azizassignment.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aziz.azizassignment.R;
import com.example.aziz.azizassignment.model.Product;
import com.squareup.picasso.Picasso;

/**
 * Created by Aziz on 2/3/2017.
 */
public class UserDetailsFragment extends Fragment {

    private Product product = new Product();

    private ImageView avatar = null;
    private TextView userNameTV = null;
    private TextView phoneTV = null;
    private TextView emailTV = null;
    private TextView locationTV = null;

    @SuppressLint("ValidFragment")
    public UserDetailsFragment(Product product) {
        this.product = product;
    }

    public UserDetailsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single, container, false);
        setReferences(view);
        setUserData();
        return view;
    }

    private void setReferences(View view) {
        avatar = (ImageView) view.findViewById(R.id.avatar);
        userNameTV = (TextView) view.findViewById(R.id.userNameTV);
        phoneTV = (TextView) view.findViewById(R.id.phoneTV);
        emailTV = (TextView) view.findViewById(R.id.emailTV);
        locationTV = (TextView) view.findViewById(R.id.locationTV);

    }

    private void setUserData() {
        Picasso.with(getActivity()).load(product.getPicture().getLarge()).into(avatar);

        userNameTV.setText(product.getName().getTitle() + " " + product.getName().getFirst() + " " + product.getName().getLast());
        phoneTV.setText(product.getPhone());
        emailTV.setText(product.getEmail());
        locationTV.setText(product.getLocation().getCity() + " " + product.getLocation().getStreet());
    }

}
