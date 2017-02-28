package www.whatpull.com.newsheadline.function.news.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import www.whatpull.com.newsheadline.R;
import www.whatpull.com.newsheadline.function.news.adapter.holder.NewsHolder;
import www.whatpull.com.newsheadline.function.news.model.NewsModel;
import www.whatpull.com.newsheadline.function.news.model.NewsModelResultMultimedia;

/**
 * [Apdater]뉴스 리사이클러 어댑터
 * Created by yeonsu on 2017-02-28.
 */
public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsHolder> {

    private Context context;
    private NewsModel newsModel;
    private final static String TAG = "NewsRecyclerAdapter";

    public NewsRecyclerAdapter(Context context) {
        this.context = context;
        this.newsModel = new NewsModel();
    }

    public void updateNewsModel(NewsModel newsModel) {
        this.newsModel = newsModel;
        this.notifyDataSetChanged();
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_news, parent, false);
        NewsHolder vh = new NewsHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final NewsHolder holder, int position) {
        holder.currentResult = newsModel.getResults().get(position);

        String url = "";
        String title = holder.currentResult.getTitle();
        String section = holder.currentResult.getSection();

        List<NewsModelResultMultimedia> multimedia = holder.currentResult.getMultimedia();
        for(NewsModelResultMultimedia media : multimedia) {
            if(StringUtils.isNoneBlank(media.getUrl()) && "thumbLarge".equalsIgnoreCase(media.getFormat()) && StringUtils.isBlank(url)) {
                url = media.getUrl();
            }
        }

        if(StringUtils.isNoneBlank(url)) {
            Glide.with(context).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    holder.thumbnail.setImageBitmap(resource);
                }
            });
        } else { // 이미지가 없는경우
            holder.thumbnail.setImageResource(R.drawable.no_image);
        }

        if(StringUtils.isNoneBlank(title)) {
            holder.title.setText(title);
            holder.title.setBackgroundColor(Color.argb(150, 76, 76, 76));
            holder.title.setMaxLines(3);
            holder.title.setEllipsize(TextUtils.TruncateAt.END);
            holder.title.setSelected(true);
        }

        if(StringUtils.isNoneBlank(section)) {
            holder.section.setText(section);
        }
    }

    @Override
    public int getItemCount() {
        return newsModel.getResults().size();
    }
}
