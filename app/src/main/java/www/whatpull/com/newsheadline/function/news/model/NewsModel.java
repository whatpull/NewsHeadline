package www.whatpull.com.newsheadline.function.news.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * [Model]뉴스 모델
 * Created by yeonsu on 2017-02-28.
 */
public class NewsModel implements Serializable {

    private String status;                                        // 상태
    private List<NewsModelResult> results = new ArrayList<>();   // 결과
    private int num_results;                                     // 결과수

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NewsModelResult> getResults() {
        return results;
    }

    public void setResults(List<NewsModelResult> results) {
        this.results = results;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "status='" + status + '\'' +
                ", results=" + results +
                ", num_result=" + num_results +
                '}';
    }
}
