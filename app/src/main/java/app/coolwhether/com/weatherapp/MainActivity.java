package app.coolwhether.com.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.coolwhether.com.weatherapp.activity.CityActivity;
import app.coolwhether.com.weatherapp.activity.ProvinceItem;
import app.coolwhether.com.weatherapp.adapter.ItemAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_lv)
    ListView lv;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ItemAdapter adapter = new ItemAdapter(this);
        lv.setAdapter(adapter);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pro_id = ((ProvinceItem) parent.getItemAtPosition(position)).getId();
                //Log.e(TAG, "onItemClick: pro_id---"+pro_id );
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                String pro_name = ((ProvinceItem) parent.getItemAtPosition(position)).getPro_name();
                intent.putExtra("name",pro_name);
                intent.putExtra("pro_id",pro_id);
                startActivity(intent);

            }
        });
    }
}
