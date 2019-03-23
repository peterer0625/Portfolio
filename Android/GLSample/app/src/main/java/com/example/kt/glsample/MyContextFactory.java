package com.example.kt.glsample;

import android.opengl.EGL14;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class MyContextFactory implements GLSurfaceView.EGLContextFactory {

    private int mEGLContextClientVersion;

    public MyContextFactory(int EGLContextClientVersion)
    {
        this.mEGLContextClientVersion = EGLContextClientVersion;
    }

    @Override
    public EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
        int[] attrib_list = {EGL14.EGL_CONTEXT_CLIENT_VERSION, this.mEGLContextClientVersion, EGL10.EGL_NONE };
        EGLContext context = egl.eglCreateContext(eglDisplay, eglConfig, EGL10.EGL_NO_CONTEXT, attrib_list);
        return context;
    }

    @Override
    public void destroyContext(EGL10 egl, EGLDisplay eglDisplay, EGLContext eglContext) {
        egl.eglDestroyContext(eglDisplay, eglContext);
    }
}
