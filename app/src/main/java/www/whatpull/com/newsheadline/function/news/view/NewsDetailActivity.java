package www.whatpull.com.newsheadline.function.news.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import www.whatpull.com.newsheadline.R;
import www.whatpull.com.newsheadline.function.news.model.NewsModelResult;
import www.whatpull.com.newsheadline.function.news.model.NewsModelResultMultimedia;
import www.whatpull.com.newsheadline.util.Util;

/**
 * [View]뉴스 상세 엑티비티
 * Created by yeonsu on 2017-02-28.
 */
public class NewsDetailActivity extends AppCompatActivity {

    private static final String TAG = "NewsDetailActivity";
    private Toolbar toolbar;
    private ImageView media;
    private TextView date, byline, title, link, desFacet, orgFacet, perFacet, geoFacet;
    private LinearLayout btnLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        media = (ImageView) findViewById(R.id.media);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        date = (TextView) findViewById(R.id.date);
        byline = (TextView) findViewById(R.id.byline);
        title = (TextView) findViewById(R.id.title);
        link = (TextView) findViewById(R.id.link);
        btnLink = (LinearLayout) findViewById(R.id.btn_link);
        desFacet = (TextView) findViewById(R.id.des_facet);
        orgFacet = (TextView) findViewById(R.id.org_facet);
        perFacet = (TextView) findViewById(R.id.per_facet);
        geoFacet = (TextView) findViewById(R.id.geo_facet);

        final NewsModelResult result = (NewsModelResult)getIntent().getSerializableExtra("result");

        btnLink.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    link.setTextColor(getResources().getColor(R.color.colorPrimary));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    link.setTextColor(Color.BLACK);
                }
                return false;
            }
        });
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getShort_url()));
                startActivity(browserIntent);
            }
        });

        String section = result.getSection();
        toolbar.setTitle(section);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Drawable drawable = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = getResources().getDrawable(R.drawable.ic_navigate_before_white_24dp, null);
        } else {
            drawable = getResources().getDrawable(R.drawable.ic_navigate_before_white_24dp);
        }
        toolbar.setNavigationIcon(drawable);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String date = result.getPublished_date();
        date = Util.getReformDate(date, "yyyy-MM-dd'T'hh:mm:ssZ");
        if(StringUtils.isNoneBlank(date)) {
            this.date.setText(date);
        }

        String byline = result.getByline();
        if(StringUtils.isNoneBlank(byline)) {
            this.byline.setText(byline);
        }

        String title = result.getTitle();
        if(StringUtils.isNoneBlank(title)) {
            this.title.setText(title);
        }

        String link = result.getShort_url();
        if(StringUtils.isNoneBlank(link)) {
            this.link.setText(link);
        }

        List<String> desFacet = result.getDes_facet();
        StringBuffer sb = new StringBuffer("Description facet : ");
        for(String facet : desFacet) {
            if(StringUtils.isNoneBlank(facet)) {
                sb.append(facet).append(", ");
            }
        }
        if(StringUtils.isNoneBlank(sb.toString())) {
            this.desFacet.setText(sb.toString().substring(0, sb.lastIndexOf(",")));
        }

        List<String> orgFacet = result.getOrg_facet();
        sb = new StringBuffer("Organization facet : ");
        for(String facet : orgFacet) {
            if(StringUtils.isNoneBlank(facet)) {
                sb.append(facet).append(", ");
            }
        }
        if(StringUtils.isNoneBlank(sb.toString())) {
            this.orgFacet.setText(sb.toString().substring(0, sb.lastIndexOf(",")));
        }

        List<String> perFacet = result.getPer_facet();
        sb = new StringBuffer("Person facet : ");
        for(String facet : perFacet) {
            if(StringUtils.isNoneBlank(facet)) {
                sb.append(facet).append(", ");
            }
        }
        if(StringUtils.isNoneBlank(sb.toString())) {
            this.perFacet.setText(sb.toString().substring(0, sb.lastIndexOf(",")));
        }

        List<String> geoFacet = result.getGeo_facet();
        sb = new StringBuffer("Geolocation facet : ");
        for(String facet : geoFacet) {
            if(StringUtils.isNoneBlank(facet)) {
                sb.append(facet).append(", ");
            }
        }
        if(StringUtils.isNoneBlank(sb.toString())) {
            this.geoFacet.setText(sb.toString().substring(0, sb.lastIndexOf(",")));
        }

        String url = "";
        List<NewsModelResultMultimedia> multimedia = result.getMultimedia();
        for(NewsModelResultMultimedia media : multimedia) {
            if(StringUtils.isNoneBlank(media.getUrl()) && "superJumbo".equalsIgnoreCase(media.getFormat()) && StringUtils.isBlank(url)) {
                url = media.getUrl();
            }
        }
        if(StringUtils.isNoneBlank(url)) {
            Glide.with(this).load(url).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    media.setImageBitmap(resource);
                }
            });
        } else { // 이미지가 없는경우
            media.setImageResource(R.drawable.no_image);
        }

    }
}
