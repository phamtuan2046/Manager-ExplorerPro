package phamtuam.filemanager.source.controllers.utils;

import phamtuam.filemanager.source.controllers.BuildConfig;

/**
 * Created by HaKr on 23/05/16.
 */

public class CrashReportingManager {

    public static void logException(Exception e) {
        logException(e, false);
    }

    public static void logException(Exception e, boolean log) {
        if(BuildConfig.DEBUG){
            e.printStackTrace();
        } else if(log) {
        }
    }

    public static void log(String s) {
    }

    public static void log(String tag, String s) {
    }
}
