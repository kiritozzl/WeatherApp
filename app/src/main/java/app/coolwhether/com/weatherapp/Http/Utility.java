package app.coolwhether.com.weatherapp.Http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by kirito on 2016/9/6.
 */
public class Utility {

    public static boolean checkNetworkConnection(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    public static void noNetWorkAlarm(Context context){
        Toast.makeText(context,"没有网络连接！",Toast.LENGTH_LONG).show();
    }
}
