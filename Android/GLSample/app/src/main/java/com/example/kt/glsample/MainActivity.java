package com.example.kt.glsample;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Singleton.setContext(this);

        MyGLSurfaceView glSurfaceView = new MyGLSurfaceView(this);
        setContentView(glSurfaceView);
    }
}
