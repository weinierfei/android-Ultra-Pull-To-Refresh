package in.srain.cube.views.ptr.demo.mytest;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.demo.R;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/3/31 19:04
 */
public class MyHead extends RelativeLayout implements PtrUIHandler {

    private static final String TAG = "MyHead";

    ImageView arrow;
    TextView tip;
    TextView lastUpdate;
    private AnimationDrawable animation;

    public MyHead(Context context) {
        super(context);
        init(context);
    }

    public MyHead(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public MyHead(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header, this);
        arrow = (ImageView) findViewById(R.id.arrow);
        tip = (TextView) findViewById(R.id.tip);
        lastUpdate = (TextView) findViewById(R.id.lastUpdate);

        animation = LoadAnimRes.getDropDownLoadingAnimDrawable(context);
    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {


    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {

//        arrow.setImageDrawable(animation);
//        animation.start();
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        arrow.setImageDrawable(animation);
        animation.start();
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        arrow.setImageResource(LoadAnimRes.getDropDownResId(ptrIndicator.getCurrentPosY()));
        Log.i(TAG,""+ptrIndicator.getCurrentPosY());
    }
}
