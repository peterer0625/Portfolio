package com.example.kt.glsample;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by KT on 2018/1/24.
 */

public class Cube
{
    private int[] mPositionHandle = new int[1];

    private float mPositionArray[] = { -1.0f,  1.0f, -1.0f,
                                     -1.0f,  1.0f,  1.0f,
                                     1.0f,  1.0f,  1.0f,
                                     1.0f,  1.0f, -1.0f,
                                     -1.0f, -1.0f, -1.0f,
                                     -1.0f, -1.0f,  1.0f,
                                     1.0f, -1.0f,  1.0f,
                                     1.0f, -1.0f, -1.0f };

    private short mIndexArray[] = { 0, 1, 2,
                                    0, 2, 3,
                                    4, 6, 5,
                                    4, 7, 6,
                                    2, 6, 7,
                                    2, 7, 3,
                                    0, 4, 1,
                                    1, 4, 5,
                                    1, 5, 6,
                                    1, 6, 2,
                                    0, 3, 4,
                                    3, 7, 4 };

    public Cube()
    {
        this.initPosition();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mIndexArray.length * 2);
        byteBuffer.order(ByteOrder.nativeOrder());
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer.put(mIndexArray);
        shortBuffer.position(0);
    }

    private void initPosition()
    {
        int bytesPerFloat = 4;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mPositionArray.length * bytesPerFloat);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(mPositionArray);
        floatBuffer.position(0);

        GLES20.glGenBuffers(1, mPositionHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mPositionHandle[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, floatBuffer.capacity() * bytesPerFloat, floatBuffer, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
    }
}
