package com.group1.server;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class XuLyServer {
    static class HttpRequestGet extends AsyncTask<String,String,String> {

        private Context context;

        public HttpRequestGet(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                StringBuffer dataout = new StringBuffer();
                if(http.getResponseCode()==HttpURLConnection.HTTP_OK){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    String inline = "";
                    while ((inline=bufferedReader.readLine()) != null){
                        dataout.append(inline.replace("<br>","\n"));
                    }
                    return dataout.toString();
                }else {
                    Toast.makeText(context, "Code: "+http.getResponseCode()+" | Message: "+http.getResponseMessage(), Toast.LENGTH_SHORT).show();
                    return "Error";
                }
            } catch (MalformedURLException e) {
                Toast.makeText(context, "Lỗi kêt nối internet", Toast.LENGTH_SHORT).show();
                return "Error";
            } catch (IOException e) {
                Toast.makeText(context, "Lỗi đọc reponsive", Toast.LENGTH_SHORT).show();
                return "error";
            }
        }
    }
    static class HttpRequestPost extends AsyncTask<String,String,String> {

        private Context context;

        public HttpRequestPost(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.setDoOutput(true);
                http.setRequestMethod("POST");
                String content_type = "application/x-www-form-urlencoded";
                if(!strings[2].isEmpty() && strings[2] != null)
                    content_type = strings[2];
                http.setRequestProperty("Content-Type",content_type);
                try(OutputStreamWriter stream = new OutputStreamWriter(http.getOutputStream())){
                    stream.write(strings[1]);
                }catch (Exception ex){
                    Toast.makeText(context, "Lỗi gửi Post", Toast.LENGTH_SHORT).show();
                    return "Error";
                }
                StringBuffer dataout = new StringBuffer();
                if(http.getResponseCode()==HttpURLConnection.HTTP_OK){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    String inline = "";
                    while ((inline=bufferedReader.readLine()) != null){
                        dataout.append(inline.replace("<br>","\n"));
                    }
                    return dataout.toString();
                }else {
                    Toast.makeText(context, "Code: "+http.getResponseCode()+" | Message: "+http.getResponseMessage(), Toast.LENGTH_SHORT).show();
                    return "Error";
                }
            } catch (MalformedURLException e) {
                Toast.makeText(context, "Lỗi kêt nối internet", Toast.LENGTH_SHORT).show();
                return "Error";
            } catch (IOException e) {
                Toast.makeText(context, "Lỗi đọc reponsive", Toast.LENGTH_SHORT).show();
                return "error";
            }
        }
    }
    public static String Get(Context context,String url){
        HttpRequestGet httpRequest = new HttpRequestGet(context);
        try {
            String a = httpRequest.execute(url).get();
           return  a;
        } catch (ExecutionException e) {

            e.printStackTrace();
            return "Error";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error";
        }
    }
    public static String Post(Context context,String url,String postData){
        HttpRequestPost httpRequest = new HttpRequestPost(context);
        try {
            String a = httpRequest.execute(url,postData).get();
            return  a;
        } catch (ExecutionException e) {

            e.printStackTrace();
            return "Error";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error";
        }
    }

}
