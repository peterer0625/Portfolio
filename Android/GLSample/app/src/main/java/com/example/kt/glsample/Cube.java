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
    private int[] mIndexHandle = new int[1];


    //       +y     -z
    //       |     /
    //       |   /
    // -x    | /     +x
    // -----------------
    //      /|
    //    /  |
    //  /    |
    //+z     -y
    private float mPositionArray[] = {
            -1.0f,  1.0f,  0.0f, 1.0f,
            -1.0f, -1.0f,  0.0f, 1.0f,
             1.0f,  1.0f,  0.0f, 1.0f,
             1.0f, -1.0f,  0.0f, 1.0f};

    private short mIndexArray[] = { 0, 1, 2,
                                    1, 2, 3};

    private int[] mProgram = new int[1];
    private int[] mProgramPositionHandle = new int[1];
    private int[] mProgramColorHandle = new int[1];
    private float[] mColor = new float[4];

    private String mVsCode =
            "attribute vec4 vPosition;\n" +
            "void main(){\n" +
            "    gl_Position = vPosition;\n" +
            "}";

    private String mPSCode =
            "precision mediump float;\n" +
            "uniform vec4 uColor;\n" +
            "void main(){\n" +
            "    gl_FragColor = uColor;\n" +
            "}";

    public Cube()
    {
        this.initPosition();
        this.initIndex();
        this.initShader();

        this.setColors(1.0f, 1.0f, 0.0f);
    }

    private void initPosition()
    {
        int bytesPerFloat = 4;
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mPositionArray.length * bytesPerFloat);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(mPositionArray);
        floatBuffer.position(0);

        GLES20.glGenBuffers(1, mPositionHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mPositionHandle[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, floatBuffer.capacity() * bytesPerFloat, floatBuffer, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
    }

    private void initIndex()
    {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mIndexArray.length * 2);
        byteBuffer.order(ByteOrder.nativeOrder());
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer.put(mIndexArray);
        shortBuffer.position(0);

        GLES20.glGenBuffers(1, mIndexHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, mIndexHandle[0]);
        GLES20.glBufferData(GLES20.GL_ELEMENT_ARRAY_BUFFER, shortBuffer.capacity() * 2, shortBuffer, GLES20.GL_STATIC_DRAW);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    private void initShader()
    {
        int vertexShader = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER);
        GLES20.glShaderSource(vertexShader, this.mVsCode);
        GLES20.glCompileShader(vertexShader);

        int pixelShader = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER);
        GLES20.glShaderSource(pixelShader, this.mPSCode);
        GLES20.glCompileShader(pixelShader);

        this.mProgram[0] = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.mProgram[0], vertexShader);
        GLES20.glAttachShader(this.mProgram[0], pixelShader);
        GLES20.glLinkProgram(this.mProgram[0]);

        GLES20.glUseProgram(this.mProgram[0]);
        this.mProgramPositionHandle[0] = GLES20.glGetAttribLocation(this.mProgram[0],"vPosition");
        this.mProgramColorHandle[0] = GLES20.glGetUniformLocation(this.mProgram[0],"uColor");
    }

    public void draw()
    {
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mPositionHandle[0]);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, mIndexHandle[0]);

        GLES20.glUseProgram(this.mProgram[0]);
        GLES20.glEnableVertexAttribArray(this.mProgramPositionHandle[0]);
        GLES20.glVertexAttribPointer(this.mProgramPositionHandle[0], 4, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glUniform4fv(this.mProgramColorHandle[0],1, this.mColor, 0);

        GLES20.glDrawElements(GLES20.GL_TRIANGLES, mIndexArray.length, GLES20.GL_UNSIGNED_SHORT, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    private void setColors(float r, float g, float b)
    {
        this.mColor[0] = r;
        this.mColor[1] = g;
        this.mColor[2] = b;
        this.mColor[3] = 1.0f;
    }
}
