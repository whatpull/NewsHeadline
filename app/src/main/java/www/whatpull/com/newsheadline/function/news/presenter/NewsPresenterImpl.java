package www.whatpull.com.newsheadline.function.news.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import www.whatpull.com.newsheadline.config.retrofit.RetrofitConfig;
import www.whatpull.com.newsheadline.function.news.model.NewsModel;
import www.whatpull.com.newsheadline.function.news.service.NewsService;

/**
 * [Presenter]뉴스 프리젠터 구현체
 * Created by yeonsu on 2017-02-28.
 */
public class NewsPresenterImpl implements NewsPresenter {

    private static final String TAG = "NewsPresenterImpl";
    private Activity activity;
    private NewsPresenter.View view;
    private boolean isNetworkError = false;

    public NewsPresenterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void setView(View view) {
        this.view = view;
        this.view.setRecyclerView();
    }

    @Override
    public void setModel(String key) {
        Retrofit retrofit = RetrofitConfig.getInstance();
        NewsService service = retrofit.create(NewsService.class);

        Call<NewsModel> newsList = service.newsList(key);
        newsList.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if(response.isSuccessful()) {
                    isNetworkError = false;
                    NewsModel newsModel = (NewsModel) response.body();
                    view.setNewsModel(newsModel);
                } else {
                    isNetworkError = true;
                    Log.e(TAG, response.message());
                    StringBuffer sb = new StringBuffer("Network error : ").append(response.message());
                    Toast.makeText(activity, sb.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                isNetworkError = true;
                Log.e(TAG, t.getMessage());
            }
        });
    }

    @Override
    public boolean getNetworkError() {
        return this.isNetworkError;
    }
}
