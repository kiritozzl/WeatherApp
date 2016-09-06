package app.coolwhether.com.weatherapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.coolwhether.com.weatherapp.R;
import app.coolwhether.com.weatherapp.adapter.CountyItemAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kirito on 2016/9/6.
 */
public class CountyActivity extends AppCompatActivity {
    @BindView(R.id.city_lv)
    ListView lv;
    private String county_id;
    private String county_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_list);
        ButterKnife.bind(this);

        county_id = getIntent().getStringExtra("county_id");
        county_name = getIntent().getStringExtra("county_name");
        setTitle(county_name);
        CountyItemAdapter adapter = new CountyItemAdapter(this,county_id,county_name);
        lv.setClickable(true);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city_id = ((ProvinceItem) parent.getItemAtPosition(position)).getId();
                String name = ((ProvinceItem) parent.getItemAtPosition(position)).getPro_name();
                //Log.e(TAG, "onItemClick: city_id---"+city_id );
                    Intent intent = new Intent(CountyActivity.this,WeatherShow.class);
                    intent.putExtra("id",city_id);
                    intent.putExtra("name",name);
                    startActivity(intent);
            }
        });
    }
}
