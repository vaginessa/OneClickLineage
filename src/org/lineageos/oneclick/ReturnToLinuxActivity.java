package org.lineageos.oneclick;

import android.app.Activity;
import android.os.Bundle;

public class ReturnToLinuxActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Analytics.sendEvent(getApplicationContext(), Analytics.CONTINUE_ON_LINUX);
        setContentView(R.layout.returntolinux);
    }
}
