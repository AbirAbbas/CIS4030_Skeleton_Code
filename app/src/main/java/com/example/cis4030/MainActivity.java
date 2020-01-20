package com.example.cis4030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;

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
    public String postPromoCode(String password) {

        //call post API here and return the message within this

        return "Replace this message";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = (TextView)findViewById(R.id.tvMessage);
        tvMessage.setText(postPromoCode(getHash("mushroompromo")));
    }
}
