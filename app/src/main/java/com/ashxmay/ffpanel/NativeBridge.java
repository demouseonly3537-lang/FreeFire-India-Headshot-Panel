package com.ashxmay.ffpanel;

public class NativeBridge {
    static {
        System.loadLibrary("ffpanel");
    }

    public static native void setHeadshotChance(int percent);
    public static native void enableAntiban(boolean on);
}
