package in.srain.cube.views.ptr.demo.mytest;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Description:下拉刷新控件
 *
 * @author: guoyongping
 * @date: 2016/4/3 16:47
 */
public class PullToRefFrameLayout extends PtrFrameLayout {

    private PullToRefHeader header;

    public PullToRefFrameLayout(Context context) {
        super(context);
        initView();
    }

    public PullToRefFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        header = new PullToRefHeader(getContext());
        setHeaderView(header);
        addPtrUIHandler(header);
        setLastUpdateTimeRelateObject(this);
        this.setKeepHeaderWhenRefresh(true);
        this.setPullToRefresh(false);
        this.setDurationToClose(200);
        this.setDurationToCloseHeader(1000);
        this.setResistance(1.5f);
        this.setRatioOfHeaderHeightToRefresh(1.2f);
        this.setBackgroundColor(Color.parseColor("#f8f8f8"));
    }


    /**
     * 记录最后刷新时间的key(目前为类名)
     *
     * @param key
     */

    public void setLastUpdateTimeKey(String key) {
        if (header != null) {
            header.setLastUpdateTimeKey(key);
        }
    }

    /**
     * 设置最后刷新时间
     *
     * @param object
     */
    public void setLastUpdateTimeRelateObject(Object object) {
        if (header != null) {
            header.setLastUpdateTimeRelateObject(object);
        }
    }

}
