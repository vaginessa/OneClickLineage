package org.lineageos.oneclick;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemProperties;
import android.provider.Settings;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import java.util.ArrayList;

public class Utils {
    private static final ArrayList<String> SUPPORTED_DEVICES = new ArrayList<String>();

    static {
        SUPPORTED_DEVICES.add("angler");
        SUPPORTED_DEVICES.add("bullhead");
        SUPPORTED_DEVICES.add("sailfish");
        SUPPORTED_DEVICES.add("marlin");
    }

	@SuppressLint("DefaultLocale")
	public static boolean isDeviceSupported() {
	    String device = getDevice();
	    if (device != null) {
	        if (SUPPORTED_DEVICES.contains(device.toLowerCase())) {
	            return true;
	        }
	    }

	    return false;
	}
    
	public static String getDevice() {
	    return SystemProperties.get("ro.product.device");
	}

	public static final String md5(final String s) {
	    final String MD5 = "MD5";
	    try {
	        // Create MD5 Hash
	        MessageDigest digest = java.security.MessageDigest
	                .getInstance(MD5);
	        digest.update(s.getBytes());
	        byte messageDigest[] = digest.digest();

	        // Create Hex String
	        StringBuilder hexString = new StringBuilder();
	        for (byte aMessageDigest : messageDigest) {
	            String h = Integer.toHexString(0xFF & aMessageDigest);
	            while (h.length() < 2)
	                h = "0" + h;
	            hexString.append(h);
	        }
	        return hexString.toString();
	
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return "";
	}
	
	public static String getUniqueID(Context applicationContext) {
		return Utils.md5(Settings.Secure.getString(applicationContext.getContentResolver(), Settings.Secure.ANDROID_ID));		
	}
}
