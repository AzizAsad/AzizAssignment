package com.example.aziz.azizassignment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aziz.azizassignment.R;

/**
 * Created by Aziz on 2/3/2017.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameL, new UsersListFragment(), "productFragment").commit();

    }

}
