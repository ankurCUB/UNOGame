package com.example.unogame.gameScreen.data;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

public class DatabaseManager {
    public String login(String username, String password) throws IOException {
        URL url = new URL(String.format("https://fifth-glider-366721.uc.r.appspot.com/login/%1$s/%2$s", username, password));
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String data = readStream(in);
            return data;
        } finally {
            urlConnection.disconnect();
        }
    }

    private String readStream(InputStream in) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = in.read();
            while(i != -1) {
                bo.write(i);
                i = in.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
//    @Inject
//    public DatabaseManager(){
//
//    }
}
