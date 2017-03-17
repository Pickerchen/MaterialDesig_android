package com.sen5.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

/**
 * Created by chenqianghua on 2017/3/13.
 */

public class NetWorkChangeReceiver extends BroadcastReceiver {

    //1:无线网络 2：wifi 3：断网
    public static final int wirelessNetwork =1;
    public static final int wifiNetwork = 2;
    public static final int offNetwork = 3;
    public static int netState;
    private long time;
    //网络状态监听

    private WifiManager mWifiManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //网络状态发生改变时接收到的广播
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo.State wifiState = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
            NetworkInfo.State mobileState = null;
            if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null) {//盒子端没有ConnectivityManager.TYPE_MOBILE这个属性
                mobileState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
            }
            if (wifiState != null && mobileState != null && NetworkInfo.State.CONNECTED != wifiState && NetworkInfo.State.CONNECTED == mobileState) {
                netState = wirelessNetwork;
            } else if (wifiState != null && mobileState != null && NetworkInfo.State.CONNECTED == wifiState && NetworkInfo.State.CONNECTED != mobileState) {
                netState = wifiNetwork;
            } else if (wifiState != null && mobileState != null && NetworkInfo.State.CONNECTED != wifiState && NetworkInfo.State.CONNECTED != mobileState) {
                long time2 = System.currentTimeMillis();
                if ((time2 - time) > 3000) {
                    Toast.makeText(context, "无网络访问", Toast.LENGTH_SHORT).show();
                }
                time = time2;
                netState = offNetwork;
            }
        } else if (action.equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
        }
        //系统wifi的状态
        else if (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
            int wifiState = intent.getIntExtra(
                    WifiManager.EXTRA_WIFI_STATE, 0);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_ENABLED:
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    break;
            }
        }
    }
}
