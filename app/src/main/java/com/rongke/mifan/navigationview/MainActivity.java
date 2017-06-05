package com.rongke.mifan.navigationview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //根据设计稿设定 preview 切换至对应的尺寸
        AutoUtils.setSize(this, false, 720, 1280);
        initView();

    }

    private void initView() {
        NavigationView nv_tab= (NavigationView) findViewById(R.id.nv_tab);
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("首页", R.drawable.selector_home);
        map.put("找货", R.drawable.selector_find_goods);
        map.put("商圈", R.drawable.selector_business_circle);
        map.put("购物车", R.drawable.selector_shop_cart);
        map.put("我的", R.drawable.selector_mine);
        nv_tab.setNaviga(map, new NavigationView.NavigaClick() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(),"选中索引:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        AutoUtils.auto(this);

    }
}
