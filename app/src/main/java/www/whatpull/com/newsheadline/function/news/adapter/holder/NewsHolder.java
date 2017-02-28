package www.whatpull.com.newsheadline.function.news.adapter.holder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.Serializable;

import www.whatpull.com.newsheadline.R;
import www.whatpull.com.newsheadline.function.news.model.NewsModelResult;
import www.whatpull.com.newsheadline.function.news.view.NewsDetailActivity;

/**
 * [Apdater]뉴스 리사이클러 홀더
 * Created by yeonsu on 2017-02-28.
 */
public class NewsHolder extends RecyclerView.ViewHolder {

    public View view;
    public ImageView thumbnail;
    public TextView title, section;
    public NewsModelResult currentResult;
    public ProgressBar progress;

    public NewsHolder(View view) {
        super(view);
        this.view = view;
        this.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
                intent.putExtra("result", (Serializable) currentResult);
                view.getContext().startActivity(intent);
            }
        });
        thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        title = (TextView) view.findViewById(R.id.title);
        section = (TextView) view.findViewById(R.id.section);
        progress = (ProgressBar) view.findViewById(R.id.progress);
    }
}
