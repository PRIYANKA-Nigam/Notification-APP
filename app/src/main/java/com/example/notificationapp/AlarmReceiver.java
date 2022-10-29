package com.example.notificationapp;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isRunning = false;
        String st = intent.getExtras().getString("extra");
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo serviceInfo : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (Music.class.getName().equals(serviceInfo.service.getClassName())) {
                isRunning = true;
            }
        }
        Intent mIntent =new Intent(context,Music.class);
        if (st.equals("on") && !isRunning){
            context.startService(mIntent);
            MainActivity.activeAlarm=intent.getExtras().getString("active");
        }else if (st.equals("off")){
            context.stopService(mIntent);
            MainActivity.activeAlarm="";
        }

    }
}