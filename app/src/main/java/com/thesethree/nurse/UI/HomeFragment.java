package com.thesethree.nurse.UI;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.thesethree.nurse.Adapter.GridAdapter;
import com.thesethree.nurse.Bean.GridItem;
import com.thesethree.nurse.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Eric on 2017-4-10.
 */

public class HomeFragment extends Fragment {
    private static HomeFragment fragment;

    public static HomeFragment getInstance() {
        if (fragment == null)
            fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, null);

        carouselFigureViewPager = (ViewPager) view.findViewById(R.id.carousel_figure_view_pager);
        indicatorCarouselFigureViewPager = (LinearLayout) view.findViewById(R.id.indicator_carousel_figure_view_pager);

        GridView gridview = (GridView) view.findViewById(R.id.common_grid_view);
        GridViewInit(gridview);

        return view;
    }

    //首页轮播图初始化
    private static final int UPDATE_VIEWPAGER = 0;
    //轮播的最热新闻图片
    ViewPager carouselFigureViewPager;
    //轮播图片下面的小圆点
    LinearLayout indicatorCarouselFigureViewPager;
    //设置当前 第几个图片 被选中
    private int autoCurrIndex = 0;
    private ImageView[] mBottomImages;//底部只是当前页面的小圆点
    private Timer timer = new Timer(); //为了方便取消定时轮播，将 Timer 设为全局
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_VIEWPAGER:
                    if (msg.arg1 != 0) {
                        carouselFigureViewPager.setCurrentItem(msg.arg1);
                    } else {
                        //false 当从末页调到首页是，不显示翻页动画效果，
                        carouselFigureViewPager.setCurrentItem(msg.arg1, false);
                    }
                    break;
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new ImageTask().execute();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void setUpViewPager(final List<GridItem> items) {
        GridAdapter imageAdapter = new GridAdapter(getActivity(), items);
        carouselFigureViewPager.setAdapter(imageAdapter);
        //创建底部指示位置的导航栏
        mBottomImages = new ImageView[items.size()];
        for (int i = 0; i < mBottomImages.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.icon_point);
            } else {
                imageView.setBackgroundResource(R.drawable.icon_point_pre);
            }
            mBottomImages[i] = imageView;
            //把指示作用的原点图片加入底部的视图中
            indicatorCarouselFigureViewPager.addView(mBottomImages[i]);
        }

        carouselFigureViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //图片左右滑动时候，将当前页的圆点图片设为选中状态
            @Override
            public void onPageSelected(int position) {
                // 一定几个图片，几个圆点，但注意是从0开始的
                int total = mBottomImages.length;
                for (int j = 0; j < total; j++) {
                    if (j == position) {
                        mBottomImages[j].setBackgroundResource(R.drawable.icon_point);
                    } else {
                        mBottomImages[j].setBackgroundResource(R.drawable.icon_point_pre);
                    }
                }
                //设置全局变量，currentIndex为选中图标的 index
                autoCurrIndex = position;
            }

            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // 设置自动轮播图片，5s后执行，周期是5s
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPDATE_VIEWPAGER;
                if (autoCurrIndex == items.size() - 1) {
                    autoCurrIndex = -1;
                }
                message.arg1 = autoCurrIndex + 1;
                handler.sendMessage(message);
            }
        }, 5000, 5000);
    }

    class ImageTask extends AsyncTask<String, Void, List<GridItem>> {
        @Override
        protected List<GridItem> doInBackground(String... params) {
            List<GridItem> items = new ArrayList<GridItem>();
            items.add(
                    new GridItem(1, "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg"));
            items.add(
                    new GridItem(2, "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg"));
            items.add(
                    new GridItem(3, "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg"));
            items.add(
                    new GridItem(4, "http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg"));
            return items;
        }

        @Override
        protected void onPostExecute(List<GridItem> items) {
            super.onPostExecute(items);
            setUpViewPager(items);

        }
    }

    ///九宫格模块初始化
    private void GridViewInit(GridView gridview) {
        final int[] imageRes = {
                R.drawable.i6,
                R.drawable.i7,
                R.drawable.i8
        };
        final int[] name = {
                R.string.notice_title_item_grid_view,
                R.string.news_title_item_grid_view,
                R.string.more_title_item_grid_view
        };
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<>();
        for (int i = 0; i < imageRes.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("ItemImage", imageRes[i]);
            map.put("ItemText", getString(name[i]));
            lstImageItem.add(map);
        }

        SimpleAdapter saImageItems = new SimpleAdapter(getActivity(),
                lstImageItem,
                R.layout.item_grid_view,
                new String[]{"ItemImage", "ItemText"},
                new int[]{R.id.img_item_grid_view, R.id.txt_item_grid_view});
        gridview.setAdapter(saImageItems);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), getString(name[position])+",敬请期待......", Toast.LENGTH_LONG).show();
            }
        });
    }
}
