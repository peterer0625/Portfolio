package com.example.kt.glsample;

import android.opengl.GLES20;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by KT on 2018/1/24.
 */

public class GLRenderer implements android.opengl.GLSurfaceView.Renderer
{
    private Cube mCube = null;

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig)
    {
        this.mCube = new Cube();
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        GLES20.glDisable(GLES20.GL_CULL_FACE);
        this.mCube.draw();
    }
}
