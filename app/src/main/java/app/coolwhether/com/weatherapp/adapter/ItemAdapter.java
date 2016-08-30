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
public class ItemAdapter extends BaseAdapter {
    private List<ProvinceItem> itemList;
    private Context mContext;
    private List<String> proList = new ArrayList<>();

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
        initString();
    }

    private void initString(){

        proList.add(mContext.getResources().getString(R.string.beijing));
        proList.add(mContext.getResources().getString(R.string.tianjing));
        proList.add(mContext.getResources().getString(R.string.hebei));
        proList.add(mContext.getResources().getString(R.string.shanxi));
        proList.add(mContext.getResources().getString(R.string.neimeng));
        proList.add(mContext.getResources().getString(R.string.liaoning));
        proList.add(mContext.getResources().getString(R.string.jilin));
        proList.add(mContext.getResources().getString(R.string.heilongjiang));
        proList.add(mContext.getResources().getString(R.string.shanghai));
        proList.add(mContext.getResources().getString(R.string.jiangsu));
        proList.add(mContext.getResources().getString(R.string.zhejiang));
        proList.add(mContext.getResources().getString(R.string.anhui));
        proList.add(mContext.getResources().getString(R.string.fujian));
        proList.add(mContext.getResources().getString(R.string.jiangxi));
        proList.add(mContext.getResources().getString(R.string.shangdong));
        proList.add(mContext.getResources().getString(R.string.henan));
        proList.add(mContext.getResources().getString(R.string.hubei));
        proList.add(mContext.getResources().getString(R.string.hunan));
        proList.add(mContext.getResources().getString(R.string.guangdong));
        proList.add(mContext.getResources().getString(R.string.hainan));
        proList.add(mContext.getResources().getString(R.string.guangxi));
        proList.add(mContext.getResources().getString(R.string.gansu));
        proList.add(mContext.getResources().getString(R.string.shanxis));
        proList.add(mContext.getResources().getString(R.string.xinjiang));
        proList.add(mContext.getResources().getString(R.string.qinhai));
        proList.add(mContext.getResources().getString(R.string.ninxia));
        proList.add(mContext.getResources().getString(R.string.chongqin));
        proList.add(mContext.getResources().getString(R.string.sichuang));
        proList.add(mContext.getResources().getString(R.string.guizhou));
        proList.add(mContext.getResources().getString(R.string.yunnan));
        proList.add(mContext.getResources().getString(R.string.xizhang));
        proList.add(mContext.getResources().getString(R.string.taiwang));
        proList.add(mContext.getResources().getString(R.string.aomeng));
        proList.add(mContext.getResources().getString(R.string.xianggan));
        initData();
    }

    private void initData(){
        itemList = new ArrayList<>();
        for (int i = 0; i < proList.size(); i++) {
            ProvinceItem item = new ProvinceItem();
            item.setPro_name(proList.get(i));
            item.setPro_res_id(R.drawable.city);
            if (i == 0) {
               item.setId("CN101010100");
            }else {
                item.setId("0000000000");
            }
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
