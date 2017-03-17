package com.sen5.test.tools;

import android.content.Context;
import android.media.ExifInterface;
import android.util.Log;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.io.IOException;

/**
 * Created by chenqianghua on 2017/2/5.
 */
public class OverAllTools {
    private String TAG = OverAllTools.class.getSimpleName();

    public void printPhotoInfo(String path){
        ExifInterface exifInterface = null;
        try {
            exifInterface = new ExifInterface(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String TAG_APERTURE = exifInterface.getAttribute(ExifInterface.TAG_APERTURE);
        String TAG_DATETIME = exifInterface.getAttribute(ExifInterface.TAG_DATETIME);
        String TAG_EXPOSURE_TIME = exifInterface.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
        String TAG_FLASH = exifInterface.getAttribute(ExifInterface.TAG_FLASH);
        String TAG_FOCAL_LENGTH = exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
        String TAG_IMAGE_LENGTH = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
        String TAG_IMAGE_WIDTH = exifInterface.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
        String TAG_ISO = exifInterface.getAttribute(ExifInterface.TAG_ISO);
        String TAG_MAKE = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
        String TAG_MODEL = exifInterface.getAttribute(ExifInterface.TAG_MODEL);
        String TAG_ORIENTATION = exifInterface.getAttribute(ExifInterface.TAG_ORIENTATION);
        String TAG_WHITE_BALANCE = exifInterface.getAttribute(ExifInterface.TAG_WHITE_BALANCE);

        Log.i(TAG, "光圈值:" + TAG_APERTURE);
        Log.i(TAG, "拍摄时间:" + TAG_DATETIME);
        Log.i(TAG, "曝光时间:" + TAG_EXPOSURE_TIME);
        Log.i(TAG, "闪光灯:" + TAG_FLASH);
        Log.i(TAG, "焦距:" + TAG_FOCAL_LENGTH);
        Log.i(TAG, "图片高度:" + TAG_IMAGE_LENGTH);
        Log.i(TAG, "图片宽度:" + TAG_IMAGE_WIDTH);
        Log.i(TAG, "ISO:" + TAG_ISO);
        Log.i(TAG, "设备品牌:" + TAG_MAKE);
        Log.i(TAG, "设备型号:" + TAG_MODEL);
        Log.i(TAG, "旋转角度:" + TAG_ORIENTATION);
        Log.i(TAG, "白平衡:" + TAG_WHITE_BALANCE);
    }

    private static Toast sToast;
    public static void showToast(Context mcontext, String content){
        synchronized (OverAllTools.class){
            if (sToast == null){
                sToast = Toast.makeText(mcontext,content,Toast.LENGTH_LONG);
            }
            else {
                sToast.setText(content);
            }
        }
        sToast.show();
    }

    public static boolean isDebug = true;
    public static void printLog(String TAG, String content){
        if (isDebug){
            Logger.d(TAG,content);
        }
    }

    /**
     * 将dip或dp转为px
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {

        final float scale = context.getResources().getDisplayMetrics().density;
        return getMultRound(dipValue, scale);
        //  return (int)(dipValue * scale + 0.5f);
    }

    /**
     * 乘法运行并四舍五入
     * @param x
     * @param y
     * @return
     */
    public static int getMultRound(float x, float y){

        return Math.round(x*y);
    }
}
