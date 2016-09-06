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
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/29.
 */
public class CityItemAdapter extends BaseAdapter {
    private List<ProvinceItem> itemList;
    private Context mContext;
    private List<String> proList = new ArrayList<>();
    private String pro_name;
    private String pro_id;
    private static final String TAG = "CityItemAdapter";

    public CityItemAdapter(Context mContext,String pro_name,String pro_id) {
        this.mContext = mContext;
        this.pro_name = pro_name;
        this.pro_id = pro_id;
        initString();
    }

    private void initString(){
        if (pro_name.equals("北京市")){
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
        }else if (pro_name.equals("上海市")){
            proList.add("上海");
        }else if (pro_name.equals("天津市")){
            proList.add("天津");
        }else if (pro_name.equals("重庆市")){
            proList.add("重庆");
        }else if (pro_name.equals("黑龙江省")){
            proList.add("哈尔滨");
            proList.add("齐齐哈尔");
            proList.add("牡丹江");
            proList.add("佳木斯");
            proList.add("绥化");
            proList.add("黑河");
            proList.add("大兴安岭");
            proList.add("伊春");
            proList.add("大庆");
            proList.add("七台河");
            proList.add("鸡西");
            proList.add("鹤岗");
            proList.add("双鸭山");
        }else if (pro_name.equals("吉林省")){
            proList.add("长春");
            proList.add("吉林");
            proList.add("延边");
            proList.add("四平");
            proList.add("通化");
            proList.add("白城");
            proList.add("辽源");
            proList.add("松原");
            proList.add("白山");
        }else if (pro_name.equals("辽宁省")){
            proList.add("沈阳");
            proList.add("大连");
            proList.add("鞍山");
            proList.add("抚顺");
            proList.add("本溪");
            proList.add("丹东");
            proList.add("锦州");
            proList.add("营口");
            proList.add("阜新");
            proList.add("辽阳");
            proList.add("铁岭");
            proList.add("朝阳");
            proList.add("盘锦");
            proList.add("葫芦岛");
        }else if (pro_name.equals("内蒙古自治区")){
            proList.add("呼和浩特");
            proList.add("包头");
            proList.add("乌海");
            proList.add("乌兰察布");
            proList.add("通辽");
            proList.add("兴安盟");
            proList.add("赤峰");
            proList.add("鄂尔多斯");
            proList.add("巴彦淖尔");
            proList.add("锡林郭勒");
            proList.add("呼伦贝尔");
            proList.add("阿拉善盟");
        }else if (pro_name.equals("河北省")){
            proList.add("石家庄");
            proList.add("保定");
            proList.add("张家口");
            proList.add("承德");
            proList.add("唐山");
            proList.add("廊坊");
            proList.add("沧州");
            proList.add("衡水");
            proList.add("邢台");
            proList.add("邯郸");
            proList.add("秦皇岛");
        }else if (pro_name.equals("山西省")){
            proList.add("太原");
            proList.add("大同");
            proList.add("阳泉");
            proList.add("晋中");
            proList.add("长治");
            proList.add("晋城");
            proList.add("临汾");
            proList.add("运城");
            proList.add("朔州");
            proList.add("忻州");
            proList.add("吕梁");
        }else if (pro_name.equals("陕西省")){
            proList.add("西安");
            proList.add("咸阳");
            proList.add("延安");
            proList.add("榆林");
            proList.add("渭南");
            proList.add("商洛");
            proList.add("安康");
            proList.add("汉中");
            proList.add("宝鸡");
            proList.add("铜川");
            proList.add("杨凌");
        }else if (pro_name.equals("山东省")){
            proList.add("济南");
            proList.add("青岛");
            proList.add("淄博");
            proList.add("德州");
            proList.add("烟台");
            proList.add("潍坊");
            proList.add("济宁");
            proList.add("泰安");
            proList.add("临沂");
            proList.add("菏泽");
            proList.add("滨州");
            proList.add("东营");
            proList.add("威海");
            proList.add("枣庄");
            proList.add("日照");
            proList.add("莱芜");
            proList.add("聊城");
        }else if (pro_name.equals("新疆维吾尔自治区")){
            proList.add("乌鲁木齐");
            proList.add("克拉玛依");
            proList.add("石河子");
            proList.add("昌吉");
            proList.add("吐鲁番");
            proList.add("巴音郭楞");
            proList.add("阿拉尔");
            proList.add("阿克苏");
            proList.add("喀什");
            proList.add("伊犁");
            proList.add("塔城");
            proList.add("哈密");
            proList.add("和田");
            proList.add("阿勒泰");
            proList.add("克州");
            proList.add("博尔塔拉");
        }else if (pro_name.equals("西藏自治区")){
            proList.add("拉萨");
            proList.add("日喀则");
            proList.add("山南");
            proList.add("林芝");
            proList.add("昌都");
            proList.add("那曲");
            proList.add("阿里");
        }else if (pro_name.equals("青海省")){
            proList.add("西宁");
            proList.add("海东");
            proList.add("黄南");
            proList.add("海南");
            proList.add("果洛");
            proList.add("玉树");
            proList.add("海西");
            proList.add("海北");
            proList.add("格尔木");
        }else if (pro_name.equals("甘肃省")){
            proList.add("兰州");
            proList.add("定西");
            proList.add("平凉");
            proList.add("庆阳");
            proList.add("武威");
            proList.add("金昌");
            proList.add("张掖");
            proList.add("酒泉");
            proList.add("天水");
            proList.add("陇南");
            proList.add("临夏");
            proList.add("甘南");
            proList.add("白银");
            proList.add("嘉峪关");
        }else if (pro_name.equals("宁夏回族自治区")){
            proList.add("银川");
            proList.add("石嘴山");
            proList.add("吴忠");
            proList.add("固原");
            proList.add("中卫");
        }else if (pro_name.equals("河南省")){
            proList.add("郑州");
            proList.add("安阳");
            proList.add("新乡");
            proList.add("许昌");
            proList.add("平顶山");
            proList.add("信阳");
            proList.add("南阳");
            proList.add("开封");
            proList.add("洛阳");
            proList.add("商丘");
            proList.add("焦作");
            proList.add("鹤壁");
            proList.add("濮阳");
            proList.add("周口");
            proList.add("漯河");
            proList.add("驻马店");
            proList.add("三门峡");
            proList.add("济源");
        }else if (pro_name.equals("江苏省")){
            proList.add("南京");
            proList.add("无锡");
            proList.add("镇江");
            proList.add("苏州");
            proList.add("南通");
            proList.add("扬州");
            proList.add("盐城");
            proList.add("徐州");
            proList.add("淮安");
            proList.add("连云港");
            proList.add("常州");
            proList.add("泰州");
            proList.add("宿迁");
        }else if (pro_name.equals("湖北省")){
            proList.add("武汉");
            proList.add("襄阳");
            proList.add("鄂州");
            proList.add("孝感");
            proList.add("黄冈");
            proList.add("黄石");
            proList.add("咸宁");
            proList.add("荆州");
            proList.add("宜昌");
            proList.add("恩施");
            proList.add("十堰");
            proList.add("神农架");
            proList.add("随州");
            proList.add("荆门");
            proList.add("荆州");
            proList.add("天门");
            proList.add("仙桃");
            proList.add("潜江");
        }else if (pro_name.equals("浙江省")){
            proList.add("杭州");
            proList.add("湖州");
            proList.add("嘉兴");
            proList.add("宁波");
            proList.add("绍兴");
            proList.add("台州");
            proList.add("温州");
            proList.add("丽水");
            proList.add("金华");
            proList.add("衢州");
            proList.add("舟山");
        }else if (pro_name.equals("安徽省")){
            proList.add("合肥");
            proList.add("蚌埠");
            proList.add("芜湖");
            proList.add("淮南");
            proList.add("马鞍山");
            proList.add("宿州");
            proList.add("阜阳");
            proList.add("亳州");
            proList.add("黄山");
            proList.add("滁州");
            proList.add("淮北");
            proList.add("铜陵");
            proList.add("宣城");
            proList.add("六安");
            proList.add("池州");
        }else if (pro_name.equals("福建省")){
            proList.add("福州");
            proList.add("厦门");
            proList.add("宁德");
            proList.add("莆田");
            proList.add("泉州");
            proList.add("漳州");
            proList.add("龙岩");
            proList.add("三明");
            proList.add("南平");
            proList.add("钓鱼岛");
        }else if (pro_name.equals("江西省")){
            proList.add("南昌");
            proList.add("九江");
            proList.add("上饶");
            proList.add("抚州");
            proList.add("宜春");
            proList.add("吉安");
            proList.add("赣州");
            proList.add("景德镇");
            proList.add("萍乡");
            proList.add("新余");
            proList.add("鹰潭");
        }else if (pro_name.equals("湖南省")){
            proList.add("长沙");
            proList.add("湘潭");
            proList.add("株洲");
            proList.add("衡阳");
            proList.add("郴州");
            proList.add("常德");
            proList.add("益阳");
            proList.add("娄底");
            proList.add("邵阳");
            proList.add("岳阳");
            proList.add("张家界");
            proList.add("怀化");
            proList.add("永州");
            proList.add("湘西");
        }else if (pro_name.equals("贵州省")){
            proList.add("贵阳");
            proList.add("遵义");
            proList.add("安顺");
            proList.add("黔南");
            proList.add("黔东南");
            proList.add("铜仁");
            proList.add("毕节");
            proList.add("六盘水");
            proList.add("黔西南");
        }else if (pro_name.equals("四川省")){
            proList.add("成都");
            proList.add("攀枝花");
            proList.add("自贡");
            proList.add("绵阳");
            proList.add("南充");
            proList.add("达州");
            proList.add("遂宁");
            proList.add("广安");
            proList.add("巴中");
            proList.add("泸州");
            proList.add("宜宾");
            proList.add("内江");
            proList.add("资阳");
            proList.add("乐山");
            proList.add("眉山");
            proList.add("凉山");
            proList.add("雅安");
            proList.add("甘孜");
            proList.add("阿坝");
            proList.add("德阳");
            proList.add("广元");
        }else if (pro_name.equals("广东省")){
            proList.add("广州");
            proList.add("韶关");
            proList.add("惠州");
            proList.add("梅州");
            proList.add("汕头");
            proList.add("深圳");
            proList.add("珠海");
            proList.add("佛山");
            proList.add("肇庆");
            proList.add("湛江");
            proList.add("江门");
            proList.add("河源");
            proList.add("清远");
            proList.add("云浮");
            proList.add("潮州");
            proList.add("中山");
            proList.add("阳江");
            proList.add("揭阳");
            proList.add("茂名");
            proList.add("汕尾");
        }else if (pro_name.equals("云南省")){
            proList.add("昆明");
            proList.add("大理");
            proList.add("红河");
            proList.add("曲靖");
            proList.add("保山");
            proList.add("文山");
            proList.add("玉溪");
            proList.add("楚雄");
            proList.add("普洱");
            proList.add("昭通");
            proList.add("临沧");
            proList.add("怒江");
            proList.add("迪庆");
            proList.add("丽江");
            proList.add("德宏");
            proList.add("西双版纳");
        }else if (pro_name.equals("广西壮族自治区")){
            proList.add("南宁");
            proList.add("崇左");
            proList.add("柳州");
            proList.add("来宾");
            proList.add("桂林");
            proList.add("梧州");
            proList.add("贺州");
            proList.add("贵港");
            proList.add("玉林");
            proList.add("百色");
            proList.add("钦州");
            proList.add("河池");
            proList.add("北海");
            proList.add("防城港");
        }else if (pro_name.equals("海南省")){
            proList.add("海口");
            proList.add("三亚");
            proList.add("东方");
            proList.add("临高");
            proList.add("澄迈");
            proList.add("儋州");
            proList.add("昌江");
            proList.add("白沙");
            proList.add("琼中");
            proList.add("定安");
            proList.add("屯昌");
            proList.add("文昌");
            proList.add("保亭");
            proList.add("万宁");
            proList.add("陵水");
            proList.add("西沙");
            proList.add("南沙");
            proList.add("乐东");
            proList.add("五指山");
            proList.add("中沙");
        }else if (pro_name.equals("香港特别行政区")){
            proList.add("香港");
        }else if (pro_name.equals("澳门特别行政区")){
            proList.add("澳门");
        }else if (pro_name.equals("台湾省")){
            proList.add("台北");
            proList.add("高雄");
            proList.add("台中");
        }
        initData();
    }

    private void initData(){
        itemList = new ArrayList<>();
        for (int i = 0; i < proList.size(); i++) {
            ProvinceItem item = new ProvinceItem();
            item.setPro_name(proList.get(i) + "市");
            item.setPro_res_id(R.drawable.city);
            String id = "";
            if (pro_id.equals("CN101010100")){
                id = "CN1010" + String.valueOf(10100 + i * 100);
            }else if (pro_id.equals("CN101020100") || pro_id.equals("CN101030100") || pro_id.equals("CN101040100")){
                id = pro_id;
            }else {
                String temp = pro_id.substring(4);
                //Log.e(TAG, "initData: temp----"+temp );
                id = "CN10" + String.valueOf(Integer.valueOf(temp) + i * 100);
            }
            //Log.e(TAG, "initData: id----"+id );
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
