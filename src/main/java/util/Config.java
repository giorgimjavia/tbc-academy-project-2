package util;

public class Config {
    private static boolean mobileDevice;

    public static boolean isMobileDevice() {
        return mobileDevice;
    }

    public static void setMobileDevice(boolean isMobile) {
        mobileDevice = isMobile;
    }
}