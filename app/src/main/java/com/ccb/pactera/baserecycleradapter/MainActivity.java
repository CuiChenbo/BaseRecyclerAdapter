package com.ccb.pactera.baserecycleradapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ccb.pactera.baserecycleradapter.base.BaseRecyclerAdapter;
import com.ccb.pactera.baserecycleradapter.base.BaseRecyclerHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    private List<String> d = Arrays.asList(
            "A","B","C","D","E","F","G"
            ,"H","I","J","K","L","M","N"
            ,"O","P","Q","R","S","T"
            ,"U","V","W","X","Y","Z");

    private RecyclerView rv ;
    private BaseRecyclerAdapter ap;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
//        ap = new BaseRecyclerAdapter<String>(MainActivity.this, R.layout.item_rv){
//
//            @Override
//            public void convert(BaseRecyclerHolder holder, int position) {
//
//            }
//        };
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        ap = new Ap(this,R.layout.item_rv);
        rv.setAdapter(ap);
        ap.setData(datas);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            datas.add(d.get(i));
        }
    }


    class Ap extends BaseRecyclerAdapter<String>{

        public Ap(Context c, int layoutRes) {
            super(c, layoutRes);
        }

        @Override
        public void convert(BaseRecyclerHolder holder, final int position) {
            //链式调用
              holder.setText(R.id.tv,items.get(position))
                    .setOnClickListener(R.id.tv, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ap.remove(position);
                        }
                    });
        }
    }

}
