package app.coolwhether.com.weatherapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.coolwhether.com.weatherapp.R;
import app.coolwhether.com.weatherapp.adapter.CityItemAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kirito on 2016/9/1.
 */
public class CityActivity extends AppCompatActivity {
    @BindView(R.id.city_lv)
    ListView lv;
    private String pro_id;
    private static final String TAG = "CityActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list);
        ButterKnife.bind(this);

        setTitle(getIntent().getStringExtra("name"));
        pro_id = getIntent().getStringExtra("pro_id");
        CityItemAdapter adapter = new CityItemAdapter(this);
        lv.setClickable(true);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city_id = ((ProvinceItem) parent.getItemAtPosition(position)).getId();
                String name = ((ProvinceItem) parent.getItemAtPosition(position)).getPro_name();
                //Log.e(TAG, "onItemClick: city_id---"+city_id );
                Intent intent = new Intent(CityActivity.this,WeatherShow.class);
                intent.putExtra("id",city_id);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
