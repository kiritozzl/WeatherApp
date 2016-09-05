package app.coolwhether.com.weatherapp.Http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.security.auth.login.LoginException;

/**
 * Created by kirito on 2016/9/2.
 */
public class Http {
    private static final String TAG = "Http";

    public static String getUrlData(String path){
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        HttpURLConnection connection = null;
        try{
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String s = null;
            while ((s = br.readLine()) != null){
                sb.append(s);
            }
            //Log.e(TAG, "getUrlData: sb1--"+sb.toString() );
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.disconnect();
            }
        }
        return sb.toString();
    }
}
