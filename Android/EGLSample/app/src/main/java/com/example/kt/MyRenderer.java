package com.example.kt;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;

public class MyRenderer extends HandlerThread
{
    private String TAG = "MyRenderer";
    private EGLConfig mEGLConfig = null;
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    private EGLSurface mEGLSurface = null;

    private Cube mCube = null;

    public MyRenderer()
    {
        super("MyRenderer");
    }

    private void createContext()
    {
        Log.d(TAG, "createContext()");

        mEGLDisplay = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY);

        int[] version = new int[2];
        if (EGL14.eglInitialize(mEGLDisplay, version,0,version,1) == false)
        {
            throw new RuntimeException("EGL error " + EGL14.eglGetError());
        }

        int []configAttribs = {
            EGL14.EGL_BUFFER_SIZE, 32,
            EGL14.EGL_ALPHA_SIZE, 8,
            EGL14.EGL_BLUE_SIZE, 8,
            EGL14.EGL_GREEN_SIZE, 8,
            EGL14.EGL_RED_SIZE, 8,
            EGL14.EGL_RENDERABLE_TYPE, EGL14.EGL_OPENGL_ES2_BIT,
            EGL14.EGL_SURFACE_TYPE, EGL14.EGL_WINDOW_BIT,
            EGL14.EGL_NONE
        };
        int []numConfigs = new int[1];
        EGLConfig[]configs = new EGLConfig[1];
        if (EGL14.eglChooseConfig(mEGLDisplay, configAttribs,0, configs, 0,configs.length, numConfigs,0) == false)
        {
            throw new RuntimeException("EGL error " + EGL14.eglGetError());
        }
        mEGLConfig = configs[0];

        int []contextAttribs = {
            EGL14.EGL_CONTEXT_CLIENT_VERSION, 2,
            EGL14.EGL_NONE
        };
        mEGLContext = EGL14.eglCreateContext(mEGLDisplay, mEGLConfig, EGL14.EGL_NO_CONTEXT, contextAttribs,0);
        if (mEGLContext == EGL14.EGL_NO_CONTEXT)
        {
            throw new RuntimeException("EGL error "+EGL14.eglGetError());
        }
    }

    private void destroyContext()
    {
        Log.d(TAG, "destroyContext()");

        EGL14.eglDestroyContext(mEGLDisplay, mEGLContext);
        mEGLContext = EGL14.EGL_NO_CONTEXT;
        mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    }

    public void onSurfaceCreated(Surface surface)
    {
        Log.d(TAG, "onSurfaceCreated()");
        final int[] surfaceAttribs = { EGL14.EGL_NONE };
        mEGLSurface = EGL14.eglCreateWindowSurface(mEGLDisplay, mEGLConfig, surface, surfaceAttribs, 0);
        EGL14.eglMakeCurrent(mEGLDisplay, mEGLSurface, mEGLSurface, mEGLContext);

        this.mCube = new Cube();
    }

    public void onSurfaceChanged(int width, int height)
    {
        mSizeDirty = false;
        GLES20.glViewport(0, 0, width, height);
    }

    public void render()
    {
        EGL14.eglMakeCurrent(mEGLDisplay, mEGLSurface, mEGLSurface, mEGLContext);

        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        GLES20.glDisable(GLES20.GL_CULL_FACE);

        this.mCube.draw(null);

        EGL14.eglSwapBuffers(mEGLDisplay, mEGLSurface);
    }

    private Object mMutex = new Object();

    @Override
    public synchronized void start() {
        super.start();

        new Handler(getLooper()).post(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    synchronized (mMutex)
                    {
                        if (mEGLContext == EGL14.EGL_NO_CONTEXT)
                        {
                            createContext();
                        }
                        else if (mSurface != null && mEGLSurface == null)
                        {
                            onSurfaceCreated(mSurface);
                        }
                        else if (mSizeDirty == true)
                        {
                            onSurfaceChanged(mWidth, mHeight);
                        }
                        else if (mEGLSurface != null)
                        {
                            render();
                        }
                    }
                }
            }
        });
    }

    private Surface mSurface = null;
    public void setSurface(Surface surface)
    {
        this.mSurface = surface;
    }

    private int mWidth = 0;
    private int mHeight = 0;
    private boolean mSizeDirty = false;
    public void setSize(int width, int height)
    {
        this.mWidth = width;
        this.mHeight = height;
        this.mSizeDirty = true;
    }
}
