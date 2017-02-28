package www.whatpull.com.newsheadline.function.news.model;

import java.io.Serializable;

/**
 * [Model]뉴스 모델 결과 멀티미디어
 * Created by yeonsu on 2017-02-28.
 */

public class NewsModelResultMultimedia implements Serializable {

    private String url;                 // 이미지 URL
    private String format;             // 이미지 형태
    private int height;                // 이미지 높이
    private int width;                 // 이미지 길이
    private String type;               // 이미지 타입
    private String subtype;            // 보조타입
    private String caption;            // 이미지 설명

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "NewsModelResultMultimedia{" +
                "url='" + url + '\'' +
                ", format='" + format + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }
}
