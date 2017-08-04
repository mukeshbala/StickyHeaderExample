package com.example.orgware.stickyheadersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String[] name ={"then","that","it","you","me","we"};
    String[] smile={"when","where","what","it","that","12554","87365464","gyfyuyg"};

    @BindView(R.id.list_view)
    RecyclerView listView;
private StickyAdapter stickyAdapter;
    private List<HeaderPojo> headerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listView.setLayoutManager(new StickyHeaderLayoutManager());
        listView.setItemAnimator(new DefaultItemAnimator());
        stickyAdapter = new StickyAdapter(this);
        listView.setAdapter(stickyAdapter);
        setData();
        stickyAdapter.setStickyList(headerList);
    }

    private void setData() {

        headerList = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            List<ChildPojo> item =new ArrayList<>();
//            Random r = new Random();
//            for(int j =0;j<r.nextInt(20);j++){
            for(int j =0; j<smile.length; j++){
                item.add( new ChildPojo(smile[j]));
            }
            headerList.add(new HeaderPojo(name[i],item));

        }

    }
}
