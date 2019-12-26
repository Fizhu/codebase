package com.fizhu.base.common.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.fizhu.base.R;

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */

public class Tools {
//    private static float getAPIVerison() {
//
//        Float f = null;
//        try {
//            StringBuilder strBuild = new StringBuilder();
//            strBuild.append(android.os.Build.VERSION.RELEASE.substring(0,android.os.Build.VERSION.RELEASE.length() ));
//            f = new Float(strBuild.toString());
//        } catch (NumberFormatException e) {
//            Log.e("", "error API version" + e.getMessage());
//        }
//
//        return f.floatValue();
//    }

    public static void systemBarLolipop(Activity act){
        Window window = act.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(act.getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
