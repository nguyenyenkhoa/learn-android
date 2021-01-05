package com.example.buoi6_bai14_nguyenthiyenkhoab1709343;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMS extends BroadcastReceiver {
    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null &&
                ACTION.compareToIgnoreCase(intent.getAction()) == 0) {
            Object[] pduArray = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] messages = new SmsMessage[pduArray.length];
            for (int i = 0; i < pduArray.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pduArray[i]);
                String sms = messages[i].getMessageBody();
                String screen = messages[i].getDisplayOriginatingAddress();
                Log.d("MySMSMonitor", "From: " + messages[i].getOriginatingAddress());
                Log.d("MySMSMonitor", "Msg: " + messages[i].getMessageBody());
                SmsManager smsManager = SmsManager.getDefault();
                Toast.makeText(context, "You recieved new message!" + messages, Toast.LENGTH_SHORT).show();

                if (sms.equals("Bong den")) {
                    smsManager.sendTextMessage(screen, null, "Dang bat", null, null);
                } else if (sms.equals("Ban ui")) {
                    smsManager.sendTextMessage(screen, null, "Da tat", null, null);
                }
                Log.d("MySMSMonitor", "SMS Message Received.");
            }
        }

    }
}
