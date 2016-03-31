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
import in.srain.cube.util.LocalDisplay;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.demo.R;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytest);
        ButterKnife.bind(this);

        StoreHouseHeader header = new StoreHouseHeader(this);
        header.setPadding(0, LocalDisplay.dp2px(20), 0, LocalDisplay.dp2px(20));
//        header.initWithString("Allinmd");


        ptrFrameLayout.setDurationToCloseHeader(500);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
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
                    }
                }, 1500);
            }
        });



        for (int i = 0; i < 30; i++) {
            datas.add("我是item==" + i);
        }
        listview.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas));


    }
}
