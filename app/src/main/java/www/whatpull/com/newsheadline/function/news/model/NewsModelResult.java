package www.whatpull.com.newsheadline.function.news.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * [Model]뉴스 모델 결과
 * Created by yeonsu on 2017-02-28.
 */
public class NewsModelResult implements Serializable {

    private String section;                                                     // 섹션
    private String title;                                                       // 제목
    private String short_url;                                                   // URL
    private String byline;                                                      // 필자
    private String item_type;                                                   // 타입
    private String published_date;                                             // 배포일
    private List<String> des_facet;                                             // 설명 피켓
    private List<String> org_facet;                                             // 조직 피켓
    private List<String> per_facet;                                             // 사람 피켓
    private List<String> geo_facet;                                             // 위치 피켓
    private List<NewsModelResultMultimedia> multimedia = new ArrayList<>();    // 멀티미디어

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public List<String> getDes_facet() {
        return des_facet;
    }

    public void setDes_facet(List<String> des_facet) {
        this.des_facet = des_facet;
    }

    public List<String> getOrg_facet() {
        return org_facet;
    }

    public void setOrg_facet(List<String> org_facet) {
        this.org_facet = org_facet;
    }

    public List<String> getPer_facet() {
        return per_facet;
    }

    public void setPer_facet(List<String> per_facet) {
        this.per_facet = per_facet;
    }

    public List<String> getGeo_facet() {
        return geo_facet;
    }

    public void setGeo_facet(List<String> geo_facet) {
        this.geo_facet = geo_facet;
    }

    public List<NewsModelResultMultimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<NewsModelResultMultimedia> multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public String toString() {
        return "NewsModelResult{" +
                "section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", short_url='" + short_url + '\'' +
                ", byline='" + byline + '\'' +
                ", item_type='" + item_type + '\'' +
                ", published_date='" + published_date + '\'' +
                ", multimedia=" + multimedia +
                '}';
    }
}
