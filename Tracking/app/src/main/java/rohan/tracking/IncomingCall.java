package rohan.tracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Rohan on 7/10/2016.
 */
public class IncomingCall extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TELEPHONY MANAGER class object to register one listner
        TelephonyManager tmgr = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        //Create Listner
        MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

        // Register listener for LISTEN_CALL_STATE
        tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    public class MyPhoneStateListener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {

            // Log.d("MyPhoneListener",state+"   incoming no:"+incomingNumber);


            // state = 1 means when phone is ringing
            if (state == 1) {
//                String msg = " New Phone Call Event. Incomming Number : "+incomingNumber;

                if (incomingNumber.contains("9573923019")){
                    Log.d("test","test");
                    MyService.sendLoc(MyService.loc);
                }



            }
        }
    }
}
