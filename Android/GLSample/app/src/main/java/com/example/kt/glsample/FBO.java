package com.example.kt.glsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLES31;
import android.opengl.GLES31Ext;
import android.opengl.GLUtils;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class FBO extends Cube{
    private int[] mFBOHandle = new int[1];
    private int[] mTextureHandle = new int[1];

    private int[] mPBOHandle = new int[1];

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

        GLES30.glGenBuffers(1, mPBOHandle, 0);
        GLES30.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, mPBOHandle[0]);
        GLES30.glBufferData(GLES30.GL_PIXEL_PACK_BUFFER, this.mWidth * this.mHeight * 4, null,GLES30.GL_STATIC_READ);
        GLES30.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, 0);
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

    public void read()
    {
        //GLES20.glReadPixels(0, 0, this.mWidth, this.mHeight, GLES30.GL_RGBA, GLES30.GL_UNSIGNED_BYTE, ib);

        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, this.mFBOHandle[0]);

        GLES30.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, mPBOHandle[0]);
        JniUtils.glReadPixels(0, 0, this.mWidth, this.mHeight, GLES30.GL_RGBA, GLES30.GL_UNSIGNED_BYTE);

        int pixel[] = new int[this.mWidth * this.mHeight];
        ByteBuffer byteBuffer = (ByteBuffer)GLES30.glMapBufferRange(GLES30.GL_PIXEL_PACK_BUFFER, 0, this.mWidth * this.mHeight * 4, GLES30.GL_MAP_READ_BIT);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.position(0);
        intBuffer.get(pixel, 0 , this.mWidth * this.mHeight);

        GLES30.glUnmapBuffer(GLES30.GL_PIXEL_PACK_BUFFER);
        GLES30.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, 0);

        GLES20.glBindFramebuffer(GLES20.GL_FRAMEBUFFER, 0);

        Bitmap bitmap = Bitmap.createBitmap(pixel, this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        File file = new File("/sdcard/KT.png");
        try
        {
            file.createNewFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try (FileOutputStream out = new FileOutputStream("/sdcard/KT.png"))
        {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        bitmap.recycle();
    }
}
