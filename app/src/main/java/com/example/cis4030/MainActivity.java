package com.example.cis4030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;

    /* SET PASSWORD HERE PLEASE */
    public static final String PASSWORD = "SET PASSWORD HERE";

    public String getHash(String password) {
        MessageDigest digest=null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        digest.reset();
        return bin2hex(digest.digest(password.getBytes()));
    }

    static String bin2hex(byte[] data) {
        return String.format("%0" + (data.length*2) + "X", new BigInteger(1, data));
    }

    //The goal of the exercise is to call the post request
    //body = { password : hash }
    //response = { status : 200, message : "Secret message" }
    public void postPromoCode(String password) throws JSONException {

        String url = "https://mobile-computing-weather-app.herokuapp.com/api/store/fungi/promo";
        RequestQueue queue = Volley.newRequestQueue(this);

        //Move this into the API call and update with the message field
        tvMessage.setText("Replace this with the secret message");

        //uncomment this to add API call to
        //queue.add(objRequest);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = findViewById(R.id.tvMessage);
        try {
            postPromoCode(getHash(PASSWORD));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
