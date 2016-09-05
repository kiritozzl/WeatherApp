package app.coolwhether.com.weatherapp.entity;

/**
 * Created by kirito on 2016/9/3.
 */
public class Item {
    private String wind_sc;
    private String wind_dir;
    private String tmp_min;
    private String tmp_max;
    private String txt_d;
    private String txt_n;
    private String ss;
    private String sr;
    private String date;

    public String getWind_sc() {
        return wind_sc;
    }

    public void setWind_sc(String wind_sc) {
        this.wind_sc = wind_sc;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getTmp_min() {
        return tmp_min;
    }

    public void setTmp_min(String tmp_min) {
        this.tmp_min = tmp_min;
    }

    public String getTxt_d() {
        return txt_d;
    }

    public void setTxt_d(String txt_d) {
        this.txt_d = txt_d;
    }

    public String getTxt_n() {
        return txt_n;
    }

    public void setTxt_n(String txt_n) {
        this.txt_n = txt_n;
    }

    public String getTmp_max() {
        return tmp_max;
    }

    public void setTmp_max(String tmp_max) {
        this.tmp_max = tmp_max;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
