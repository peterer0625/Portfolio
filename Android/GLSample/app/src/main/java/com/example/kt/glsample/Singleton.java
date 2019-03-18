package com.example.kt.glsample;

import android.content.Context;

public class Singleton
{
    private static Context sContext = null;

    synchronized public static Context getContext()
    {
        return sContext;
    }
}
