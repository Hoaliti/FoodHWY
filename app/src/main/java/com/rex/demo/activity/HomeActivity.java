package com.rex.demo.activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rex.demo.R;
import com.rex.demo.adapter.HomeAdapter;
import com.rex.demo.model.Business;
import com.rex.demo.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomePresenter {
    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    private List<Business> viewData = new ArrayList<>();

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        super.init();
        setTitle("London");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        addBusiness();
        initView();
    }


    @Override
    public void addBusiness() {
        viewData.add(new Business("Walmart","营业时间 12:00 - 19:40","Toronto","30min","起送: $15.0"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSve2oZwBob3b_kICcJQc_W8OUKfyT1scC9yz98NMjOUjMcP4cZ"));
        viewData.add(new Business("PetSmart","营业时间 11:00 - 19:30","London","40min","起送: $25.0"
                ,"https://www.peta.org/wp-content/uploads/2017/11/iStock-805170532_absolutimages-668x336.jpg?20190103112626"));
        viewData.add(new Business("Loblaws","营业时间 9:00 - 19:40","Toronto","20min","起送: $35.0"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQaBGkN1dAnt2pwyFjHEHi0DEhkW6vSTdjhBwAVgWOWLWIOOo_f"));
        viewData.add(new Business("TP Auto 车饰","营业时间 12:00 - 19:40","Toronto","30min","起送: $25.0"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRvRqjXMS9BRGlt7XjxhsndjGzZWqMiaO9V0SZrMrDOK4SYGyz8"));
        viewData.add(new Business("Zodiac KTV预定","营业时间 12:00 - 19:40","Toronto","50min","起送: $55.0"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR5wqVBoiIyw4cVfBWFO7s27yeHAvmP5NTDR1XsqhZlyY9v-DeT"));
        viewData.add(new Business("珍珠首饰","营业时间 12:00 - 19:40","Toronto","50min","起送: $55.0"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRU1mD0xbcSP2ju0fnPzvz9gAgPdZDpsfDxGvw3FoSotmVHfhAw"));
        viewData.add(new Business("日本药妆店","营业时间 12:00 - 19:40","Toronto","50min","起送: $55.0"
                ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSGhBXYFg0W-f_ZSDvJuuJFtaIPCL4kexWWtIOsGlnt5c0O7vIu"));

    }

    private void initView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        homeAdapter = new HomeAdapter(this, viewData);
        // 设置适配器
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked" , Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
