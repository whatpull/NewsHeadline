package www.whatpull.com.newsheadline.function.news.presenter;

import www.whatpull.com.newsheadline.function.news.model.NewsModel;

/**
 * [Presenter]뉴스 프리젠터
 * Created by yeonsu on 2017-02-28.
 */
public interface NewsPresenter {

    void setView(NewsPresenter.View view);
    void setModel(String key);
    boolean getNetworkError();

    public interface View {
        void setRecyclerView();
        void setNewsModel(NewsModel newsModel);
    }
}
