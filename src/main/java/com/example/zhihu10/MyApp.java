package com.example.zhihu10;

import android.app.Application;
import android.content.Context;

/**
 * Created by Xu on 2016/8/22.
 */
public class MyApp extends Application {

    private static Context context;
    public static final int DAY_THEME = R.style.AppTheme;
    public static final int NIGHT_THEME = R.style.DefaultTheme;
    public static int myThemeType = DAY_THEME;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    /** 获取Application类型的上下文 */
    public static Context getContext() {
        return context;
    }
}
