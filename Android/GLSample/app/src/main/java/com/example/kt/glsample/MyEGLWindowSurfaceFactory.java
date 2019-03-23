package com.example.kt.glsample;

import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

import static android.content.ContentValues.TAG;

public class MyEGLWindowSurfaceFactory implements GLSurfaceView.EGLWindowSurfaceFactory {
    @Override
    public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig, Object nativeWindow) {
        EGLSurface result = null;
        try {
            result = egl.eglCreateWindowSurface(eglDisplay, eglConfig, nativeWindow, null);
        } catch (IllegalArgumentException e) {
            // This exception indicates that the surface flinger surface
            //            // is not valid. This can happen if the surface flinger surface has
            //            // been torn down, but the application has not yet been
            //            // notified via SurfaceHolder.Callback.surfaceDestroyed.
            //            // In theory the application should be notified first,
            // but in practice sometimes it is not. See b/4588890
            Log.e(TAG, "eglCreateWindowSurface", e);
        }
        return result;
    }

    @Override
    public void destroySurface(EGL10 egl, EGLDisplay eglDisplay, EGLSurface eglSurface) {
        egl.eglDestroySurface(eglDisplay, eglSurface);
    }
}
