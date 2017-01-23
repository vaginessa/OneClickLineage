package org.lineageos.oneclick;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class Analytics {

	public static final String ADB_ALREADY_ENABLED = "apk.adbAlreadyEnabled";
	public static final String ADB_ENABLED = "apk.adbEnabled";
	public static final String CONTINUE_ON_MAC = "apk.continueOnMac";
	public static final String CONTINUE_ON_WINDOWS = "apk.continueOnWindows";
	public static final String DEVICE_ALREADY_UNPLUGGED = "apk.deviceAlreadyUnplugged";
	public static final String PTP_ALREADY_ENABLED = "apk.ptpAlreadyEnabled";
	public static final String STARTED = "apk.started";
	public static final String TERMS_ACCEPTED = "apk.termsAccepted";
	public static final String UNPLUG_DEVICE = "apk.unplugDevice";
	

    private static Tracker sTracker;
 
    private synchronized static Tracker getTracker(Context context) {
        if (sTracker == null) {
            GoogleAnalytics ga = GoogleAnalytics.getInstance(context);
            sTracker = ga.newTracker(context.getString(R.string.ga_trackingId));
            sTracker.setUseSecure(true);
            sTracker.setClientId(Utils.getUniqueID(context));
        }
        return sTracker;
    }
 
    public static void sendEvent(Context context, String category) {
        sendEvent(context, category, Utils.getDevice());
    }
 
    public static void sendEvent(Context context, String category, String action) {
        Tracker tracker = getTracker(context);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action).build());
    }
}
