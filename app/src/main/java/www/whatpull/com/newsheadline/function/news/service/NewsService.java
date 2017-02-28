package www.whatpull.com.newsheadline.function.news.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import www.whatpull.com.newsheadline.function.news.model.NewsModel;

/**
 * [Service]뉴스 서비스
 * Created by yeonsu on 2017-02-28.
 */

public interface NewsService {

    @GET("svc/topstories/v2/home.json")
    Call<NewsModel> newsList(@Query("api-key") String key);

}
