package com.rongke.mifan.navigationview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 杭州融科网络
 * 刘宇飞创建 on 2017/6/1.
 * 描述：导航
 */

public class NavigationItemView extends RelativeLayout {

    private TextView tv_dse;
    private ImageView iv_top;
    private TextView tv_red_dot;

    public NavigationItemView(Context context) {
        super(context);
        initView(context,null);
    }

    public NavigationItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        }
        initView(context, attrs);
    }

    public NavigationItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode()) {
            return;
        }
        initView(context, attrs);

    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.navigation_tab, this, true);
        tv_dse = (TextView) view.findViewById(R.id.tv_dse);
        iv_top = (ImageView) view.findViewById(R.id.iv_top);
        tv_red_dot = (TextView) view.findViewById(R.id.tv_red_dot);
        if(attrs==null){
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NavigationView);

        String dse_name = a.getText(R.styleable.NavigationView_dse_name).toString();
        CommonUtils.setTextValue(tv_dse, dse_name);
        if (CommonUtils.isEmpty(dse_name)) {
            tv_dse.setVisibility(GONE);
            ViewGroup.LayoutParams layoutParams = iv_top.getLayoutParams();
            layoutParams.height=70;
            layoutParams.width=70;
            iv_top.setLayoutParams(layoutParams);

        }

        int drawable_src = a.getResourceId(R.styleable.NavigationView_drawable_src, -1);
        if (drawable_src > 0) {
            iv_top.setBackgroundResource(drawable_src);
        }

        boolean is_select = a.getBoolean(R.styleable.NavigationView_is_select, false);
        setSelected(is_select);
        a.recycle();
    }
    /**
     * 设置图片
     */
    public void setImage(int imgId){
        if (imgId > 0) {
            iv_top.setBackgroundResource(imgId);
        }
    }
    /**
     * 设置文本
     */
    public void setTextValue(String text){
        CommonUtils.setTextValue(tv_dse, text);
        if (CommonUtils.isEmpty(text)) {
            tv_dse.setVisibility(GONE);
            ViewGroup.LayoutParams layoutParams = iv_top.getLayoutParams();
            layoutParams.height=70;
            layoutParams.width=70;
            iv_top.setLayoutParams(layoutParams);

        }
    }
    /**
     * 设置未读数
     */
    protected void setUnReadNum(int num) {
        tv_red_dot.setText(num + "");
        if (num > 99) {
            tv_red_dot.setText("99+");
        }
        if (num > 0) {
            tv_red_dot.setVisibility(View.VISIBLE);
            if (num > 10) {
                if (num < 100)
                    tv_red_dot.setPadding(3, 3, 3, 3);
                else tv_red_dot.setPadding(3, 10, 3, 10);
            } else tv_red_dot.setPadding(10, 3, 10, 3);

        } else {
            tv_red_dot.setVisibility(View.GONE);
        }
    }

    /**
     * 是否选中
     *
     * @param selected
     */
    public void setSelected(boolean selected) {
        iv_top.setSelected(selected);
        if (selected)
            tv_dse.setTextColor(CommonUtils.getColor(getContext(), R.color.public_orange));
        else
            tv_dse.setTextColor(CommonUtils.getColor(getContext(), R.color.color666666));
    }

    /**
     * iv_top 是否被选中
     */
    public boolean isSelected(){
        return iv_top.isSelected();
    }
}
