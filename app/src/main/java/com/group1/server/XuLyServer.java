package com.group1.server;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

public class XuLyServer {
    // CONNECT SERVER INFOR
    public static final String HOST = "http://10.0.3.2/";
    public static final String LOGIN = "login.php";
    public static final String REGISTER = "register_user.php";
    public static final String UPDATE_USER_INFOR = "updateuserinfor.php";
    public static final String BACKUP_VAY = "backupvay.php";
    public static final String BACKUP_CHITIEU = "backupchitieu.php";
    public static final String GET_CHITIEU = "getChiTieu.php";
    public static final String GET_VAY = "getVay.php";
    public static final String UPDATE_CHITIEU = "updateChiTieu.php";
    public static final String UPDATE_VAY = "updateVay.php";
    //POST DATA
    // LOGIN post
    public static String getLoginPost(String nickname,String password){
        if(nickname.isEmpty() || password.isEmpty())
            return null;
        return "nickname="+nickname+"&password="+password;
    }
    // REGISTER post
    public static String getRegisterPost(String nickname,String password,String email,int sex){
        if(nickname.isEmpty() || password.isEmpty() || email.isEmpty() || sex >3 || sex <0){
            return null;
        }
        return "nickname="+nickname+"&password="+password+"&email="+email+"&sex="+sex;
    }
    // UPDATE_USER_INFOR post


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
                    Log.d(getClass().getName(), "doInBackground: "+ http.getResponseCode());
                    return "Error";
                }
            } catch (MalformedURLException e) {
                Log.d(getClass().getName(), "doInBackground: "+ e.getMessage());
                return "Error";
            } catch (IOException e) {
                Log.d(getClass().getName(), "doInBackground: "+ e.getMessage());
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
                Log.d("TAG", "doInBackground: "+strings[1]);
                try(OutputStreamWriter stream = new OutputStreamWriter(http.getOutputStream())){
                    stream.write(strings[1]);
                }catch (Exception ex){
                    Log.d(getClass().getName(), "doInBackground: "+ ex.getMessage());
                    return "Error";
                }
                StringBuffer dataout = new StringBuffer();
                if(http.getResponseCode()==HttpURLConnection.HTTP_OK){
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
                    String inline = "";
                    while ((inline=bufferedReader.readLine()) != null){
                        dataout.append(inline);
                    }
                    return dataout.toString();
                }else {
                    Log.d(getClass().getName(), "doInBackground: " +http.getResponseCode());
                    return "Error";
                }
            } catch (MalformedURLException e) {
                Log.d(getClass().getName(), "doInBackground: "+ e.getMessage());
                return "Error";
            } catch (IOException e) {
                Log.d(getClass().getName(), "doInBackground: "+ e.getMessage());
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
            Log.d("GET", "doInBackground: "+ e.getMessage());
            return "Error";
        } catch (InterruptedException e) {
            Log.d("GET", "doInBackground: "+ e.getMessage());
            return "Error";
        }
    }
    public static String Post(Context context,String url,String postData){
        HttpRequestPost httpRequest = new HttpRequestPost(context);
        try {
            String a = httpRequest.execute(url,postData).get();
            return  a;
        } catch (ExecutionException e) {
            Log.d("POST", "doInBackground: "+ e.getMessage());
            e.printStackTrace();
            return "Error";
        } catch (InterruptedException e) {
            Log.d("POST", "doInBackground: "+ e.getMessage());
            e.printStackTrace();
            return "Error";
        }
    }

    public static RegisterReponsiveClass getReponsiveRegister(Context context,String nickname,String password,String email,int sex){
        try{
            String url = HOST+REGISTER;
            String dataPost = getRegisterPost(nickname,password,email,sex);
            String json = Post(context,url,dataPost);
            if(json.equals("error")){
                Log.d("TAG", "getReponsiveRegister: "+ json);
                return null;
            }
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<RegisterReponsiveClass> jsonAdapter = moshi.adapter(RegisterReponsiveClass.class);
            RegisterReponsiveClass registerReponsiveClass = jsonAdapter.fromJson(json);
            return registerReponsiveClass;
        }catch (Exception ex){
            Log.d("REGISTER_REPONSIVE", "doInBackground: "+ ex.getMessage());
            return null;
        }

    }
    public static LoginReponsiveClass getReponsiveLogin(Context context,String nickname,String password){
        String url = HOST+LOGIN;
        String postData = getLoginPost(nickname,password);
        LoginReponsiveClass loginReponsiveClass;
        try{
            String json = Post(context,url,postData);
            if(json.equals("error")){
                Log.d("TAG", "getReponsiveRegister: "+ json);
                return null;
            }
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<LoginReponsiveClass> jsonAdapter = moshi.adapter(LoginReponsiveClass.class);
            loginReponsiveClass = jsonAdapter.fromJson(json);
            return  loginReponsiveClass;
        }catch (Exception ex){
            Log.d("LOGIN_REPONSIVE", "doInBackground: "+ ex.getMessage());
            return null;
        }
    }
    public static Object backupVay(Context context, BackupChiTieu data){
        try{
            String url = HOST+BACKUP_VAY;
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<BackupChiTieu> jsonAdapter = moshi.adapter(BackupChiTieu.class);
            String postData = jsonAdapter.toJson(data);
            String json = Post(context,url,postData);
            JsonAdapter<ReponsiveSuccessfull> successfullJsonAdapter = moshi.adapter(ReponsiveSuccessfull.class);
            try{
                ReponsiveSuccessfull re = successfullJsonAdapter.fromJson(json);
                return re;
            }catch (Exception e){
                try{
                    JsonAdapter<ReponsiveFalse.Rootobject> rootobjectJsonAdapter = moshi.adapter(ReponsiveFalse.Rootobject.class);
                    ReponsiveFalse.Rootobject rootobject = rootobjectJsonAdapter.fromJson(json);
                    return rootobject;
                }catch (Exception ex){
                    Log.d("TAG", "backupVay: "+ex.getMessage());
                    return null;
                }
            }
        }catch (Exception ex){
            Log.d("TAG", "backupVay: "+ex.getMessage());
            return null;
        }
    }

    // CÁC LỚP REPONSIVE

    // Lớp reponsive của Register
    public static class RegisterReponsiveClass {
        public int status_code ;
        public String nickname ;
        public String create_time ;
        public String table_vay ;
        public String table_chi_tieu ;
    }
    // Lớp reponsive của đăng nhập
    public static class LoginReponsiveClass {
        public String nickname;
        public String password;
        public String access_token;
        public Calendar create_time;
    }
    // Lớp backup vay
    public static class BackupVay{
        public static class BackupVayRequestClass
        {
            public Datum[] data ;
            public String token ;
        }
        public static class Datum
        {
            public int id ;
            public int sotienvay ;
            public int sotiendatra ;
            public String hantra ;
            public String nguoigiaodich ;
            public String loaigiaodich ;
            public String ghichugiaodich ;
            public String thoigiangiaodich ;
            public int laisuat ;
            public String trangthai ;
        }
    }
    // Lơp backup chi tiêu
    public static class BackupChiTieu{
        public static class BackupChiTieuRequestClass
        {
            public Data[] data ;
            public String token ;
        }
        public static class Data
        {
            public int id ;
            public int sotien ;
            public String loaigiaodich ;
            public String ghichugiaodich ;
            public String thoigiangiaodich ;
            public String diadiem ;
            public String soluong ;
        }
    }
    // reponsive successfull backup chitieu and vay
    public static class ReponsiveSuccessfull {
        public int status_code ;
        public String status_message ;
        public String output ;
        public String time ;
    }
    // reponsive false backup chitieu and vay
    public static class ReponsiveFalse{
        public class Rootobject
        {
            public Datum[] data;
            public String error ;
            public String create_time ;
        }

        public class Datum
        {
            public int id ;
            public int sotien ;
            public String loaigiaodich ;
            public String ghichugiaodich ;
            public String thoigiangiaodich ;
            public String diadiem ;
            public String soluong ;
        }

    }
    // get vay
    public static class SynchVay{
        public static class ReponsiveSynchVay
        {
            public Datum[] data ;
            public String create_time ;
        }

        public static class Datum
        {
            public String ID ;
            public String sotienvay ;
            public String hantra ;
            public String nguoigiaodich ;
            public String loaigiaodich ;
            public String ghichugiaodich ;
            public String thoigiangiaodich ;
            public String laisuat ;
            public String trangthai ;
            public String backup_time ;
        }
    }
    // Synch chitieu
    public static class SynchChiTieu{
        public class ReponsiveSynchChiTieu
        {
            public Datum[] data ;
            public String create_time ;
        }

        public class Datum
        {
            public String ID ;
            public String sotien ;
            public String loaigiaodich ;
            public String ghichugiaodich ;
            public String thoigiangiaodich ;
            public String diadiem ;
            public String soluong ;
            public String backup_time ;
        }

    }



}
