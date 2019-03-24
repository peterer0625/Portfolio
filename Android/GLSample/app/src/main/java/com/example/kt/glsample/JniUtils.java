package com.example.kt.glsample;

public class JniUtils
{
    static {
        System.loadLibrary("JniUtils");
    }

    public static native void glReadPixels(int x, int y, int width, int height, int format, int type);
}
