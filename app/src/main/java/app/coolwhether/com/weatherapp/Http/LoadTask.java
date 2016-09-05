package app.coolwhether.com.weatherapp.Http;

import android.os.AsyncTask;
import android.util.Log;

import app.coolwhether.com.weatherapp.activity.WeatherShow;
import app.coolwhether.com.weatherapp.entity.Item;
import app.coolwhether.com.weatherapp.support.JsonHelper;

/**
 * Created by kirito on 2016/9/4.
 */
public class LoadTask extends AsyncTask<String,Void,String> {
    private Item item;
    //LoadTask的参数callBack
    private callBack callBack;
    private static final String TAG = "LoadTask";

    @Override
    protected String doInBackground(String... params) {
        return Http.getUrlData(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        Log.e(TAG, "onPostExecute: s---"+s);
        try{
            item = JsonHelper.parseJsonToItem(s);
            //如果callBack不为空，把item参数传给WeatherShow.activity
            if (callBack != null){
                callBack.setItem(item);
            }
            //Log.e(TAG, "onPostExecute: item---"+item );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //给LoadTask添加设置回调的方法
    public void setCallBack(callBack callback){
        this.callBack = callback;
    }

    //设置回调借口
    public interface callBack{
        void setItem(Item i);
    }

}
