package com.rongke.mifan.navigationview;


import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 杭州融科网络
 * 刘宇飞创建 on 2017/6/5.
 * 描述：
 */

public class CommonUtils {
    /**
     * 判断字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }
    /**
     * 设置文本
     *
     * @param value
     * @return
     */
    public static void setTextValue(TextView textView, String value, String... defValue) {
        if (isNotEmpty(value))
            textView.setText(value);
        else {
            if (defValue!=null&&defValue.length==1) {
                textView.setText(defValue[0]);
            } else {
                textView.setText("");
            }

        }


    }
    /**
     * 字符串是否为空
     *
     * @param input
     * @return
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input)||"null".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    public static int getColor(Context context, int resid) {
        return getResoure(context).getColor(resid);
    }

    public static Resources getResoure(Context context) {
        return context.getResources();
    }
    /**
     * 获取屏幕px
     *
     * @param context
     * @return 分辨率
     */
    static public int getScreenWidthPixels(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.widthPixels;
    }
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context,float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
