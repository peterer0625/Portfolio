package com.example.kt.glsample;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {
    public MyGLSurfaceView(Context context)
    {
        super(context);

        MyContextFactory contextFactory = new MyContextFactory(2);
        this.setEGLContextFactory(contextFactory);

        this.setEGLConfigChooser(8,8,8,8,24,0);
        this.setRenderer(new GLRenderer());
    }
}
