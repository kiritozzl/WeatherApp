package app.coolwhether.com.weatherapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import app.coolwhether.com.weatherapp.Http.Http;
import app.coolwhether.com.weatherapp.Http.LoadTask;
import app.coolwhether.com.weatherapp.Http.Utility;
import app.coolwhether.com.weatherapp.R;
import app.coolwhether.com.weatherapp.entity.Item;
import app.coolwhether.com.weatherapp.support.JsonHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kirito on 2016/9/2.
 */
public class WeatherShow extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    private String id;
    private static final String path_left = "https://api.heweather.com/x3/weather?cityid=";
    private static final String path_right = "&key=9bb0507d23b046cb9b6fee3c6053f985";
    private String url;
    private Item item;

    @BindView(R.id.time_tv_show)
    TextView date_tv;
    @BindView(R.id.wind_sc)
    TextView sc_tv;
    @BindView(R.id.wind_dir)
    TextView dir_tv;
    @BindView(R.id.ss_show)
    TextView ss_tv;
    @BindView(R.id.sr_show)
    TextView sr_tv;
    @BindView(R.id.temp_min_show)
    TextView temp_min_tv;
    @BindView(R.id.temp_max_show)
    TextView temp_max_tv;
    @BindView(R.id.txt_d_show)
    TextView txt_d_tv;
    @BindView(R.id.txt_n_show)
    TextView txt_n_tv;

    @BindView(R.id.srl)
    SwipeRefreshLayout srl;

    private static final String TAG = "WeatherShow";
    private boolean isConnect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        ButterKnife.bind(this);

        setTitle(getIntent().getStringExtra("name"));
        id = getIntent().getStringExtra("id");
        url = path_left + id + path_right;

        srl.setOnRefreshListener(this);
        srl.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        loadData();
    }

    private void loadData(){
        //new一个LoadTask，设置回调接口，在获取到item后执行与item有关的操作
        //不在获取到item后就使用item会报空指针
        LoadTask task = new LoadTask();
        task.setCallBack(new LoadTask.callBack() {
            @Override
            public void setItem(Item i) {
                item = i;
                date_tv.setText(item.getDate());
                sc_tv.setText(item.getWind_sc());
                dir_tv.setText(item.getWind_dir());
                sr_tv.setText(item.getSr());
                ss_tv.setText(item.getSs());
                temp_min_tv.setText(item.getTmp_min());
                temp_max_tv.setText(item.getTmp_max());
                txt_d_tv.setText(item.getTxt_d());
                txt_n_tv.setText(item.getTxt_n());
                Toast.makeText(WeatherShow.this,"天气数据加载完毕(∩_∩)",Toast.LENGTH_LONG).show();
                srl.setRefreshing(false);
            }
        });
        //执行task
        task.execute(url);
    }

    @Override
    public void onRefresh() {
        isConnect = Utility.checkNetworkConnection(WeatherShow.this);
        if (!isConnect){
            Utility.noNetWorkAlarm(WeatherShow.this);
            srl.setRefreshing(false);
        }else if (isConnect){
            loadData();
        }
    }
}
