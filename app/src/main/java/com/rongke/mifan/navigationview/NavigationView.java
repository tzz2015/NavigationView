package com.rongke.mifan.navigationview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Map;

/**
 * 杭州融科网络
 * 刘宇飞创建 on 2017/6/5.
 * 描述：
 */

public class NavigationView extends LinearLayout {

    private LinearLayout ll_root;
    private NavigationItemView curreItemView;

    public NavigationView(Context context) {
        super(context);
        initView(context, null);
    }

    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public NavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_navigation, this, true);
        ll_root = (LinearLayout) view.findViewById(R.id.ll_root);
    }

    /**
     * 设置底部导航布局
     */
    public void setNaviga(Map<String, Integer> map, final NavigaClick navigaClick) {
        int positon = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            positon++;
            final NavigationItemView itemView = new NavigationItemView(getContext());
            itemView.setTextValue(entry.getKey());
            itemView.setImage(entry.getValue());
            if (positon == 0) {
                itemView.setSelected(true);
                curreItemView = itemView;
            }else {
                itemView.setSelected(false);
            }
            final int finalPositon = positon;
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (curreItemView != itemView) {
                        curreItemView.setSelected(false);
                        itemView.setSelected(true);
                        navigaClick.onClick(finalPositon);
                        curreItemView=itemView;
                    }

                }
            });

            ll_root.addView(itemView);
        }
        invalidate();
        for(int i=0;i<ll_root.getChildCount();i++){
            View childAt = ll_root.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = AutoUtils.designWidth / map.size();
            childAt.setLayoutParams(layoutParams);
        }
        invalidate();
    }

    public interface NavigaClick {
        void onClick(int position);
    }
}
