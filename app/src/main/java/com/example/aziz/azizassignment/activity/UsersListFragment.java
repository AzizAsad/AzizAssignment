package com.example.aziz.azizassignment.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aziz.azizassignment.R;
import com.example.aziz.azizassignment.controllers.VolleyController;
import com.example.aziz.azizassignment.model.Product;
import com.example.aziz.azizassignment.utill.ConnectionDetector;
import com.example.aziz.azizassignment.utill.CustomListAdapter;
import com.example.aziz.azizassignment.utill.JsonMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Aziz on 2/3/2017.
 */
public class UsersListFragment extends Fragment {

    ArrayList<Product> arrayList = new ArrayList<>();
    ListView lv;
    LinearLayout loadingPB;
    FragmentManager fragmentManager = null;
    CustomListAdapter adapter = null;

    public UsersListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        loadingPB = (LinearLayout) view.findViewById(R.id.loadingPB);
        fragmentManager = getFragmentManager();

        getData();

        return view;
    }


    /**
     * to get data
     */
    private void getData() {
        String url = "https://randomuser.me/api/?results=50";

        if (ConnectionDetector.getInstance(getActivity()).isConnect()) {
            loadingPB.setVisibility(View.VISIBLE);
            StringRequest arrayRequest = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {

                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject productObject = jsonArray.getJSONObject(i);
                            Product product = JsonMapper.readData(productObject, new TypeReference<Product>() {
                            });
                            arrayList.add(product);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    setAdapter();
                    loadingPB.setVisibility(View.GONE);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            );

            VolleyController.getInstance(getActivity()).addToRequestQueue(arrayRequest, "getData");

        }
    }

    private void setAdapter() {
        adapter = new CustomListAdapter(
                getActivity(), R.layout.custom_list_layout, arrayList
        ) {
            @Override
            public void onClickonProduct(Product product) {
                fragmentManager.beginTransaction().replace(R.id.frameL, new UserDetailsFragment(product), "singleFragment").addToBackStack("singleFragment").commit();

            }
        };
        lv.setAdapter(adapter);
    }


}
