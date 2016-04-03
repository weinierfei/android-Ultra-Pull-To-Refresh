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
import in.srain.cube.views.ptr.demo.R;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/4/3 17:00
 */
public class MyTestCusRefActivity extends Activity {

    @Bind(R.id.listview) ListView listview;
    @Bind(R.id.pull_ref_lay) PullToRefFrameLayout pullRefLay;

    List<String> datas = new ArrayList<>();

    ArrayAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_ref_cus);
        ButterKnife.bind(this);


        pullRefLay.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pullRefLay.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullRefLay.refreshComplete();

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
