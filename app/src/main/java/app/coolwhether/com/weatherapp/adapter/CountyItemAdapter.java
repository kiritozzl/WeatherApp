package app.coolwhether.com.weatherapp.adapter;

import android.content.Context;
import android.util.Log;
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
import app.coolwhether.com.weatherapp.entity.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kirito on 2016/9/6.
 */
public class CountyItemAdapter extends BaseAdapter {
    private String id;
    private String name;
    private List<ProvinceItem> itemList;
    private List<String> listName;
    private Context mContext;
    private static final String TAG = "CountyItemAdapter";

    public CountyItemAdapter(Context context,String id, String name) {
        this.id = id;
        this.name = name;
        mContext = context;
        initName();
    }

    private void initName(){
        itemList = new ArrayList<>();
        listName = new ArrayList<>();
        if (name.equals("广州市")){
            listName.add("广州");
            listName.add("番禺");
            listName.add("从化");
            listName.add("增城");
            listName.add("花都");
        }else if (name.equals("韶关市")){
            listName.add("韶关");
            listName.add("乳源");
            listName.add("始兴");
            listName.add("翁源");
            listName.add("乐昌");
            listName.add("仁化");
            listName.add("南雄");
            listName.add("新丰");
            listName.add("曲江");
            listName.add("浈江");
            listName.add("武江");
        }
        initData();
    }

    private void initData(){
        for (int i = 0; i < listName.size(); i++) {
            ProvinceItem item = new ProvinceItem();
            item.setPro_name(listName.get(i));
            item.setPro_res_id(R.drawable.city);
            String county_id = "CN10" + String.valueOf(Integer.valueOf(id.substring(4)) + i);
            Log.e(TAG, "initData: county_id---"+county_id );
            item.setId(county_id);
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
    public long getItemId(int position) {
        return position;
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
