package com.example.zhihu10.util;

import android.content.Context;

/**
 * Created by Xu on 2016/8/21.
 */
public class UiUtils {

    /**
     * 把一个dp单位的值转换为px（像素）
     * @param dp
     * @return
     */
    public static int dp2px(Context context,int dp) {
        float density =context .getResources().getDisplayMetrics().density;	// 获取屏幕密度
        int px = (int) (dp * density + 0.5);	// 加0.5是为了四舍五入
        return px;
    }

}
