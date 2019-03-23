package com.example.kt.glsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

public class FBO extends Cube{
    private int[] mFBOHandle = new int[1];
    private int[] mTextureHandle = new int[1];

    private int mWidth = 0;
    private int mHeight = 0;

    public FBO(int width, int height)
    {
        super();
        this.mWidth = width;
        this.mHeight = height;

        GLES20.glGenFramebuffers(1, mFBOHandle, 0);
        GLES20.glGenTextures(1, this.mTextureHandle, 0);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mTextureHandle[0]);
        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D,0, GLES20.GL_RGBA, this.mWidth, this.mHeight,0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE,null);

        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);

        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_REPEAT);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_REPEAT);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);

        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, this.mFBOHandle[0]);
        GLES20.glFramebufferTexture2D(GLES20.GL_FRAMEBUFFER, GLES20.GL_COLOR_ATTACHMENT0, GLES20.GL_TEXTURE_2D, this.mTextureHandle[0], 0);
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
    }

    public void bind()
    {
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, this.mFBOHandle[0]);
        GLES20.glViewport(0,0, this.mWidth, this.mHeight);
    }

    public void unBind()
    {
        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);
    }

    public void draw()
    {
        super.draw(this.mTextureHandle);
    }
}
