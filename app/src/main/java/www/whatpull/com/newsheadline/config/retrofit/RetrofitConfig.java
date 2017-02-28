package www.whatpull.com.newsheadline.config.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * [Retrofit]레트로핏 연결 설정파일
 * Created by yeonsu on 2017-02-28.
 */
public class RetrofitConfig {

    private static Retrofit retrofit;
    private static final String API_BASE_URL = "https://api.nytimes.com/";

    public static Retrofit getInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
