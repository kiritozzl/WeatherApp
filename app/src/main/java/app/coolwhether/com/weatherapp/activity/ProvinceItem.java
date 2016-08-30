package app.coolwhether.com.weatherapp.activity;

/**
 * Created by Administrator on 2016/8/25.
 */
public class ProvinceItem {
    private String pro_name;
    private int pro_res_id;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPro_res_id() {
        return pro_res_id;
    }

    public void setPro_res_id(int pro_res_id) {
        this.pro_res_id = pro_res_id;
    }
}
