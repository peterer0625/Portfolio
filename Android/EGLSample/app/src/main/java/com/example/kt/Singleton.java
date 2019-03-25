package com.example.kt;

import android.content.Context;

public class Singleton
{
    private static Context sContext = null;

    synchronized public static Context getContext()
    {
        return sContext;
    }

    synchronized public static void setContext(Context context)
    {
        sContext = context;
    }
}
