"# NavigationView" 
第一步在布局添加自定义view
  <com.rongke.mifan.navigationview.NavigationView
      android:id="@+id/nv_tab"
      android:layout_centerVertical="true"
      android:layout_alignParentBottom="true"
      android:layout_width="match_parent"
      android:layout_height="100px"/>
第二步 activity 初始化
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
    ＜/br＞










  ![image](https://github.com/tzz2015/NavigationView/blob/master/screenshots/FFA38R.png)