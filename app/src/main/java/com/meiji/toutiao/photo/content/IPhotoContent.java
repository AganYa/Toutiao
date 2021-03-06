package com.meiji.toutiao.photo.content;

import android.content.Context;

import com.meiji.toutiao.bean.photo.PhotoArticleBean;
import com.meiji.toutiao.bean.photo.PhotoGalleryBean;

/**
 * Created by Meiji on 2017/2/16.
 */

interface IPhotoContent {

    interface View {

        void onSetImageBrowser(PhotoGalleryBean bean, int position);

        /**
         * 请求数据失败
         */
        void onFail();

        void onSaveImageSuccess();
    }

    interface Presenter {

        void doSetImageBrowser();

        /**
         * 请求数据失败
         */
        void onFail();

        void doRequestData(PhotoArticleBean.DataBean dataBean);

        void doGetComment();

        int doGetImageCount();

        void doSetPosition(int position);

        void doSaveImage();

    }

    interface Model {

        /**
         * 请求数据
         */
        boolean getRequestData(String url);

        /**
         * 返回内容
         */
        PhotoGalleryBean getData();

        boolean SaveImage(String url, Context context);
    }

}
