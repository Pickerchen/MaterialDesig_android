package com.sen5.test.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.sen5.test.R;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class OtherActivity extends Activity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        judgeMobileVersion();
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionFail(requestCode = 100)
    public void doFailSomething(){
        Toast.makeText(this, "Contact permission is not granted", Toast.LENGTH_SHORT).show();
    }

    @PermissionSuccess(requestCode = 100)
    public void doSomething(){
        Toast.makeText(this, "Contact permission is granted", Toast.LENGTH_SHORT).show();
    }

    private void showNotifycation() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("横幅通知");
        builder.setContentText("请在设置通知管理中开启消息横幅提醒权限");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setSmallIcon(R.drawable.icon_192);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_192));
        Intent intent = new Intent(this, OtherActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 1, intent, 0);
        builder.setContentIntent(pIntent);
        //这句是重点
        builder.setFullScreenIntent(pIntent, true);
        builder.setAutoCancel(true);
        Notification notification = builder.build();
        manager.notify(1, notification);
    }


//        String packname = context.getPackageName();
//        PackageManager pm = context.getPackageManager();
//        boolean permission = (PackageManager.PERMISSION_GRANTED == pm.checkPermission("android.permission.SYSTEM_ALERT_WINDOW", packname));
//        if(permission){
//            params.type = WindowManager.LayoutParams.TYPE_PHONE;
//        }else{
//            params.type = WindowManager.LayoutParams.TYPE_TOAST;
//        }



    private void judgeMobileVersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PermissionGen.with(OtherActivity.this)
                    .addRequestCode(100)
                    .permissions(
                            Manifest.permission.SYSTEM_ALERT_WINDOW
                            )
                    .request();
        }
    }
//    Manifest.permission.READ_CONTACTS,
//    Manifest.permission.RECEIVE_SMS,
//    Manifest.permission.WRITE_CONTACTS,
}
