"# NavigationView" 
第一步在布局添加自定义view    </br>
  <com.rongke.mifan.navigationview.NavigationView  </br>
      android:id="@+id/nv_tab"  </br>
      android:layout_centerVertical="true" </br>
      android:layout_alignParentBottom="true" </br>
      android:layout_width="match_parent" </br>
      android:layout_height="100px"/> </br>
第二步 activity 初始化 </br>
 private void initView() { </br>
        NavigationView nv_tab= (NavigationView) findViewById(R.id.nv_tab); </br>
        Map<String, Integer> map = new LinkedHashMap<>(); </br>
        map.put("首页", R.drawable.selector_home); </br>
        map.put("找货", R.drawable.selector_find_goods); </br>
        map.put("商圈", R.drawable.selector_business_circle); </br>
        map.put("购物车", R.drawable.selector_shop_cart); </br>
        map.put("我的", R.drawable.selector_mine); </br>
        nv_tab.setNaviga(map, new NavigationView.NavigaClick() { </br>
            @Override </br>
            public void onClick(int position) { </br>
                Toast.makeText(getApplicationContext(),"选中索引:"+position,Toast.LENGTH_SHORT).show(); </br>
            } </br>
        }); </br>
        AutoUtils.auto(this); </br>

    } </br>
    </br>










  ![image](https://github.com/tzz2015/NavigationView/blob/master/screenshots/FFA38R.png)