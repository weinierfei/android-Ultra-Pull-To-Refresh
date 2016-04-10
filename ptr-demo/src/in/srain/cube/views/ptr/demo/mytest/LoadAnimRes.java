package in.srain.cube.views.ptr.demo.mytest;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;

import in.srain.cube.views.ptr.demo.R;


public class LoadAnimRes {

    private static final String TAG = "LoadAnimRes";

	private static int[] dropDownAnimResIds = {
            R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,R.drawable.load_01,
            R.drawable.load_01, R.drawable.load_02,
			R.drawable.load_03, R.drawable.load_04, R.drawable.load_05,
			R.drawable.load_06, R.drawable.load_07, R.drawable.load_08,
			R.drawable.load_09, R.drawable.load_10, R.drawable.load_11,
			R.drawable.load_12, R.drawable.load_13, R.drawable.load_14,
			R.drawable.load_15, R.drawable.load_16, R.drawable.load_17,
			R.drawable.load_18, R.drawable.load_19, R.drawable.load_20,
			R.drawable.load_21, R.drawable.load_22, R.drawable.load_23,
			R.drawable.load_24 };

	private static AnimationDrawable dropDownLoadingAnimDrawable;

	public static int getDropDownResId(float offset) {

        Log.i(TAG,"offset="+offset);

        if (offset <= 0){
            return dropDownAnimResIds[0];
        }else if (offset >= 34){
            return dropDownAnimResIds[dropDownAnimResIds.length - 1];
        }

		int pos = (int) (offset % dropDownAnimResIds.length);
        Log.i(TAG,"pos="+pos);
		return dropDownAnimResIds[pos];
	}

	public static AnimationDrawable getDropDownLoadingAnimDrawable(
			Context context) {
        if (dropDownLoadingAnimDrawable == null) {
            dropDownLoadingAnimDrawable = new AnimationDrawable();
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_01), 10);
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_02), 10);
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_03), 10);
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_04), 10);
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_05), 10);
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_06), 10);
            dropDownLoadingAnimDrawable.addFrame(context.getResources().getDrawable(R.drawable.loading_07), 10);
            dropDownLoadingAnimDrawable.setOneShot(false);
        }
        return dropDownLoadingAnimDrawable;
	}
}
