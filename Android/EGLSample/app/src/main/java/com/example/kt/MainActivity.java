package com.example.kt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    private MyRenderer mMyRenderer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Singleton.setContext(this);

        SurfaceView surfaceView = new SurfaceView(this);
        mMyRenderer = new MyRenderer();
        mMyRenderer.start();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
                mMyRenderer.render(surfaceHolder.getSurface(), width, height);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        setContentView(surfaceView);
    }

    protected void onDestroy()
    {
        mMyRenderer.release();
        mMyRenderer = null;
        super.onDestroy();
    }
}
