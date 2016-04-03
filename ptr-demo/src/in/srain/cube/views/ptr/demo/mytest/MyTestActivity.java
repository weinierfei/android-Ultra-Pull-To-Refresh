package in.srain.cube.views.ptr.demo.mytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.demo.R;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/3/31 17:37
 */
public class MyTestActivity extends Activity {


    @Bind(R.id.listview) ListView listview;
    @Bind(R.id.fragment_ptr_home_ptr_frame) PtrFrameLayout ptrFrameLayout;

    List<String> datas = new ArrayList<>();

    ArrayAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytest);
        ButterKnife.bind(this);


        MyHead header = new MyHead(this);

        ptrFrameLayout.setDurationToCloseHeader(1500);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setKeepHeaderWhenRefresh(true);
        ptrFrameLayout.setPullToRefresh(false);
        header.setLastUpdateTimeRelateObject(this);

        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrameLayout.refreshComplete();

                        for (int j = 0; j < 5; j++) {
                            datas.add("我是新增item==" + j);
                        }

                        adapter.notifyDataSetChanged();

                    }
                }, 1500);
            }
        });



        for (int i = 0; i < 30; i++) {
            datas.add("我是item==" + i);
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listview.setAdapter(adapter);


    }
}
