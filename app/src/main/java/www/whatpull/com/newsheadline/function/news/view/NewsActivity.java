package www.whatpull.com.newsheadline.function.news.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import www.whatpull.com.newsheadline.R;
import www.whatpull.com.newsheadline.function.news.adapter.NewsRecyclerAdapter;
import www.whatpull.com.newsheadline.function.news.model.NewsModel;
import www.whatpull.com.newsheadline.function.news.presenter.NewsPresenter;
import www.whatpull.com.newsheadline.function.news.presenter.NewsPresenterImpl;

/**
 * [View]뉴스 엑티비티
 * Created by yeonsu on 2017-02-28.
 */
public class NewsActivity extends AppCompatActivity implements NewsPresenter.View {

    private static final String TAG = "NewsActivity";
    private static final String API_KEY = "";
    private Toolbar toolbar;
    private NewsPresenter presenter;
    private RecyclerView mRecyclerView;
    private NewsRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("News Headline");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        presenter = new NewsPresenterImpl(this);
        presenter.setView(this);
        presenter.setModel(API_KEY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                if(presenter.getNetworkError()) {
                    presenter.setModel(API_KEY);
                }
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.news_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new NewsRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setNewsModel(NewsModel newsModel) {
        if(mAdapter != null && newsModel != null) {
            if(newsModel.getNum_results() > 0) {
                mAdapter.updateNewsModel(newsModel);
                mAdapter.notifyDataSetChanged();
            } else {
                Log.i(TAG, "업데이트 리스트가 존재하지 않습니다.");
            }
        }
    }
}
