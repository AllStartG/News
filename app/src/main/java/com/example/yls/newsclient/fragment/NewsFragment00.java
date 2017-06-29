package com.example.yls.newsclient.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.yls.newsclient.NewsDetailActivity;
import com.example.yls.newsclient.R;
import com.example.yls.newsclient.adapter.NewsAdapter;
import com.example.yls.newsclient.base.URLManager;
import com.example.yls.newsclient.bean.NewsEntity;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.List;

/**
 * Fragment基类
 * Created by yls on 2017/6/27.
 */

public class NewsFragment00 extends BaseFragment {

    private ListView listView;
    private SpringView springview;
    private List<NewsEntity.ResultBean> listDatas;
    private NewsAdapter newsAdapter;
    private View headerView;

    /** 新闻类别id */
    private String channelId;


    public void setChannelId (String channelId){
        this.channelId = channelId;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_news_00;
    }

    @Override
    public void initView() {
        listView = (ListView) mRoot.findViewById(R.id.listView);
        newsAdapter = new NewsAdapter(getContext(),null);
        listView.setAdapter(newsAdapter);

        initSpringView();
    }

    private void initSpringView() {
        springview = (SpringView) mRoot.findViewById(R.id.spring_view);

        springview.setHeader(new DefaultHeader(getContext()));
        springview.setFooter(new DefaultFooter(getContext()));

        springview.setType(SpringView.Type.FOLLOW);

        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                getNewsData(true);
            }

            @Override
            public void onLoadmore() {
                getNewsData(false);
        }
        });
    }

    @Override
    public void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int index = position;
                //列表有添加头部，才需要减1
                if (listView.getHeaderViewsCount() > 0) {
                    index = index - 1;
                }

                //用户点击的新闻
//                NewsEntity.ResultBean newsBean = (NewsEntity.ResultBean) parent.getItemAtPosition(index);
                 NewsEntity.ResultBean news = listDatas.get(index);

                Intent intent = new Intent(mActivity, NewsDetailActivity.class);
                intent.putExtra("news", news);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        getNewsData(true);
    }

    /** 要加载第几页数据 */
    private int pageNo = 1;
    private int pageSize = 20;

    private void getNewsData(final boolean refresh) {
        if (refresh)
            pageNo = 1;

        String url = URLManager.getUrl(channelId, pageNo, pageSize);

        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, url,  new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json = responseInfo.result;
                System.out.println("---服务器返回的json数据：---" + json);

                json = json.replace(channelId, "result");
                Gson gson = new Gson();
                NewsEntity newsEntity = gson.fromJson(json, NewsEntity.class);
                System.out.println("--解析json:" + newsEntity.getResult().size());
                //列表显示的数据集合
                listDatas = newsEntity.getResult();

                if (refresh){
                    showDatas(listDatas);
                } else {
                    newsAdapter.appendDatas(listDatas);
                }
                //显示数据到列表中
//                showDatas(newsEntity);
                pageNo++;
                springview.onFinishFreshAndLoad();
            }



            @Override
            public void onFailure(HttpException error, String msg) {
                System.out.println("---服务器返回的错误数据：---" + msg);
            }
        });
    }

    private void showDatas(List<NewsEntity.ResultBean> listDatas) {
//        if (newsEntity == null || newsEntity.getResult() == null
//                || newsEntity.getResult().size() == 0){
//            System.out.println("--没有获取到服务器的新闻数据--");
//            return;
//        }

        //如果列表已经已经添加头部布局，则先移除
        if(listView.getHeaderViewsCount() > 0){
            listView.removeHeaderView(headerView);
        }

        //第一条新闻
        NewsEntity.ResultBean firstNews = listDatas.get(0);

        //显示轮播图
        List<NewsEntity.ResultBean.AdsBean> ads = firstNews.getAds();

        //有轮播图广告
        if (ads != null && ads.size() > 0) {
            headerView = View.inflate(mActivity, R.layout.list_header, null);

            //移除第一条数据（也就是轮播图数据），不显示在列表项中
            listDatas.remove(0);

            SliderLayout sliderLayout = (SliderLayout)
                    headerView.findViewById(R.id.slider_layout);

            for (int i = 0; i < ads.size(); i++) {
                // 一则广告数据
                NewsEntity.ResultBean.AdsBean adBean = ads.get(i);

                TextSliderView sliderView = new TextSliderView(mActivity);
                sliderView.description(adBean.getTitle()).image(adBean.getImgsrc());
                // 添加子界面
                sliderLayout.addSlider(sliderView);
                // 设置点击事件
                sliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        showToast(slider.getDescription());
                    }
                });
            }
            // 添加列表头部布局
            listView.addHeaderView(headerView);
        }


        //显示新闻列表
//        NewsAdapter newsAdapter = new NewsAdapter(mActivity, newsEntity.getResult());
        newsAdapter.setDatas(listDatas);
    }
}
