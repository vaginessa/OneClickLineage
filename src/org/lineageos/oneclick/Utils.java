package org.lineageos.oneclick;

import android.os.SystemProperties;

import java.util.ArrayList;

public class Utils {
    private static final ArrayList<String> SUPPORTED_DEVICES = new ArrayList<String>();

    static {
        SUPPORTED_DEVICES.add("angler");
        SUPPORTED_DEVICES.add("bullhead");
        SUPPORTED_DEVICES.add("sailfish");
        SUPPORTED_DEVICES.add("marlin");
    }

    public static boolean isDeviceSupported() {
        String device = SystemProperties.get("ro.product.device");
        if (device != null) {
            if (SUPPORTED_DEVICES.contains(device.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
}
