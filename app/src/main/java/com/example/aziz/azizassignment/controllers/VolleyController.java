package com.example.aziz.azizassignment.controllers;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.aziz.azizassignment.utill.OkHttpStack;

/**
 * Created by Aziz on 2/3/2017.
 */
public class VolleyController extends Application {

    public static final String TAG = VolleyController.class.getSimpleName();

    private OkHttpStack okHttpStack = null;

    private static RequestQueue mRequestQueue;

    private Context context = null;


    public static VolleyController getInstance(Context context) {
        return new VolleyController(context);
    }

    public VolleyController(Context context) {
        this.context = context;
        iniRequestQueue();
    }


    private void iniRequestQueue() {
        try {
            okHttpStack = new OkHttpStack();
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(context, okHttpStack);
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            //showErrorNullToast(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            //  showErrorNullToast(getApplicationContext());
        }
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        try {
            req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
            getRequestQueue().add(req);
        } catch (Exception e) {

        }
    }


}