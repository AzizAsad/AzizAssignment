package com.example.aziz.azizassignment.utill;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
/**
 * Created by Aziz on 2/3/2017.
 */
public class ConnectionDetector {

    private static Context context;


    public ConnectionDetector(Context context) {
        this.context = context;
    }

    public static ConnectionDetector getInstance(Context context) {
        return new ConnectionDetector(context);

    }

    /**
     * Checking for all possible internet providers
     **/
    private static boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        // return connectivity.getActiveNetworkInfo() != null
                        // && connectivity.getActiveNetworkInfo()
                        // .isConnectedOrConnecting();
                        return true;
                    }
        }
        return false;
    }


    /**
     * To check if Internet present , from fragment
     *
     * @return true or false
     */
    public static boolean isConnect() {
        try {
            if (!isConnectingToInternet()) {
                // Internet Connection is not present
                Toast.makeText(context, "Please Check your connection", Toast.LENGTH_LONG).show();
                return false;
            }
        } catch (Exception e) {

        }
        return true;
    }

}
