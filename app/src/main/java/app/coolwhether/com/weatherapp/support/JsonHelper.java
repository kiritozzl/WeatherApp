package app.coolwhether.com.weatherapp.support;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import app.coolwhether.com.weatherapp.entity.Item;

/**
 * Created by kirito on 2016/9/3.
 */
public class JsonHelper {
    private static final String TAG = "JsonHelper";

    public static Item parseJsonToItem(String json) throws JSONException{
        JSONObject jsonObject = new JSONObject(json);
        JSONArray heWeather = jsonObject.getJSONArray("HeWeather data service 3.0");
        //Log.e(TAG, "parseJsonToList: ---heWeather"+heWeather);
        Item item = new Item();
        JSONObject object = heWeather.getJSONObject(0);
        JSONArray daily_forecast = null;
        if (object.has("daily_forecast")){
            daily_forecast = object.getJSONArray("daily_forecast");
            //Log.e(TAG, "parseJsonToList: daily_forecast---"+daily_forecast );
            JSONObject obj = daily_forecast.getJSONObject(0);
            JSONObject wind = null;
            if (obj.has("wind")){
                wind = obj.getJSONObject("wind");
                //Log.e(TAG, "parseJsonToList: wind---"+wind );
                item.setWind_dir(wind.optString("dir"));
                item.setWind_sc(wind.optString("sc"));
                //Log.e(TAG, "parseJsonToList: dir,sc"+ wind.optString("dir"));
            }

            JSONObject astro = null;
            if (obj.has("astro")){
                astro = obj.getJSONObject("astro");
                item.setSr(astro.optString("sr"));
                item.setSs(astro.optString("ss"));
                //Log.e(TAG, "parseJsonToItem: ss---"+ astro.optString("ss"));
            }

            JSONObject temp = null;
            if (obj.has("tmp")){
                temp = obj.getJSONObject("tmp");
                item.setTmp_max(temp.optString("max"));
                item.setTmp_min(temp.optString("min"));
                //Log.e(TAG, "parseJsonToItem: max---"+ temp.optString("max"));
            }

            if(obj.has("date")){
                item.setDate(obj.optString("date"));
                //Log.e(TAG, "parseJsonToItem: date---"+ obj.optString("date"));
            }

            if (obj.has("cond")){
                JSONObject cond = obj.getJSONObject("cond");
                item.setTxt_d(cond.optString("txt_d"));
                item.setTxt_n(cond.optString("txt_n"));
                //Log.e(TAG, "parseJsonToItem: txt_d---"+ cond.optString("txt_d"));
            }
        }
        return item;
    }

}
