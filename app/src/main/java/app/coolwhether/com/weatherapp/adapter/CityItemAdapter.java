package app.coolwhether.com.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.coolwhether.com.weatherapp.R;
import app.coolwhether.com.weatherapp.activity.ProvinceItem;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/29.
 */
public class CityItemAdapter extends BaseAdapter {
    private List<ProvinceItem> itemList;
    private Context mContext;
    private List<String> proList = new ArrayList<>();

    public CityItemAdapter(Context mContext) {
        this.mContext = mContext;
        initString();
    }

    private void initString(){
        proList.add("北京");
        proList.add("海淀");
        proList.add("朝阳");
        proList.add("顺义");
        proList.add("怀柔");
        proList.add("通州");
        proList.add("昌平");
        proList.add("延庆");
        proList.add("丰台");
        proList.add("石景山");
        proList.add("大兴");
        proList.add("房山");
        proList.add("密云");
        proList.add("门头沟");
        proList.add("平谷");
        initData();
    }

    private void initData(){
        itemList = new ArrayList<>();
        for (int i = 0; i < proList.size(); i++) {
            ProvinceItem item = new ProvinceItem();
            item.setPro_name(proList.get(i));
            item.setPro_res_id(R.drawable.city);
            String id = "CN1010" + String.valueOf(10100 + i * 100);
            item.setId(id);
            itemList.add(item);
        }
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.pro_item,parent,false);
            holder = new viewHolder(convertView);

            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.iv.setImageResource(itemList.get(position).getPro_res_id());
        holder.tv.setText(itemList.get(position).getPro_name());
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class viewHolder{
        @BindView(R.id.pro_item_iv)
        ImageView iv;
        @BindView(R.id.pro_item_tv)
        TextView tv;

        public viewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
