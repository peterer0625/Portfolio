package com.example.kt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

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
    private int[] mColorHandle = new int[1];
    private int[] mTextureCoordinateHandle = new int[1];

    private int[] mTextureHandle = new int[1];

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

    private float mColorArray[] = {
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f};

    private float mTextureCoordinateArray[] = {
            0.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 1.0f,
            1.0f, 0.0f};

    private short mIndexArray[] = { 0, 1, 2,
            1, 2, 3};

    private static int sBytesPerFloat = 4;
    private static int sBytesPerShort = 2;

    private int[] mProgram = new int[1];
    private int[] mProgramPositionHandle = new int[1];
    private int[] mProgramColorHandle = new int[1];
    private int[] mProgramTextureCoordinateHandle = new int[1];

    private int[] mFragmentProgramColorHandle = new int[1];
    private int[] mFragmentProgramTextureHandle = new int[1];
    private float[] mColor = new float[4];

    private String mVsCode =
            "attribute vec4 vPosition;\n" +
                    "attribute vec4 vColor;\n" +
                    "attribute vec2 vTextureCoordinate;\n" +
                    "varying vec4 color;\n" +
                    "varying vec2 textureCoordinate;\n" +
                    "void main(){\n" +
                    "    color = vColor;\n" +
                    "    textureCoordinate = vTextureCoordinate;\n" +
                    "    gl_Position = vPosition;\n" +
                    "}";

    private String mPsCode =
            "precision mediump float;\n" +
                    "uniform sampler2D u_Texture;\n" +
                    "uniform vec4 uColor;\n" +
                    "varying vec4 color;\n" +
                    "varying vec2 textureCoordinate;\n" +
                    "void main(){\n" +
                    "    gl_FragColor = uColor + color + texture2D(u_Texture, textureCoordinate);\n" +
                    "}";

    public Cube()
    {
        this.initPosition();
        this.initColorData();
        this.initTextureCoordinateData();
        this.initIndex();
        this.initShader();

        this.initTexture();

        this.setColors(0.0f, 0.0f, 0.0f);
    }

    private void initPosition()
    {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mPositionArray.length * Cube.sBytesPerFloat);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(mPositionArray);
        floatBuffer.position(0);

        GLES20.glGenBuffers(1, mPositionHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mPositionHandle[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, floatBuffer.capacity() * Cube.sBytesPerFloat, floatBuffer, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
    }

    private void initIndex()
    {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mIndexArray.length * Cube.sBytesPerShort);
        byteBuffer.order(ByteOrder.nativeOrder());
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        shortBuffer.put(mIndexArray);
        shortBuffer.position(0);

        GLES20.glGenBuffers(1, mIndexHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, mIndexHandle[0]);
        GLES20.glBufferData(GLES20.GL_ELEMENT_ARRAY_BUFFER, shortBuffer.capacity() * 2, shortBuffer, GLES20.GL_STATIC_DRAW);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    private void initColorData()
    {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(mColorArray.length * Cube.sBytesPerFloat);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(mColorArray);
        floatBuffer.position(0);

        GLES20.glGenBuffers(1, mColorHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mColorHandle[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, floatBuffer.capacity() * Cube.sBytesPerFloat, floatBuffer, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
    }

    private void initTextureCoordinateData()
    {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.mTextureCoordinateArray.length * Cube.sBytesPerFloat);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(mTextureCoordinateArray);
        floatBuffer.position(0);

        GLES20.glGenBuffers(1, this.mTextureCoordinateHandle, 0);
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mTextureCoordinateHandle[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, floatBuffer.capacity() * Cube.sBytesPerFloat, floatBuffer, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
    }

    private void initShader()
    {
        int vertexShader = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER);
        GLES20.glShaderSource(vertexShader, this.mVsCode);
        GLES20.glCompileShader(vertexShader);

        int pixelShader = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER);
        GLES20.glShaderSource(pixelShader, this.mPsCode);
        GLES20.glCompileShader(pixelShader);

        this.mProgram[0] = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.mProgram[0], vertexShader);
        GLES20.glAttachShader(this.mProgram[0], pixelShader);
        GLES20.glLinkProgram(this.mProgram[0]);

        GLES20.glUseProgram(this.mProgram[0]);
        this.mProgramPositionHandle[0] = GLES20.glGetAttribLocation(this.mProgram[0],"vPosition");
        this.mProgramColorHandle[0] = GLES20.glGetAttribLocation(this.mProgram[0],"vColor");
        this.mProgramTextureCoordinateHandle[0] = GLES20.glGetAttribLocation(this.mProgram[0],"vTextureCoordinate");

        this.mFragmentProgramTextureHandle[0] = GLES20.glGetUniformLocation(this.mProgram[0],"u_Texture");
        this.mFragmentProgramColorHandle[0] = GLES20.glGetUniformLocation(this.mProgram[0],"uColor");
    }

    private void initTexture()
    {
        Bitmap bitmap = BitmapFactory.decodeResource(Singleton.getContext().getResources(), R.drawable.doraemon);
        GLES20.glGenTextures(1, this.mTextureHandle, 0);

        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mTextureHandle[0]);
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();

        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);

        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_REPEAT);
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_REPEAT);

        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
    }

    public void draw(int[] textureHandle)
    {
        GLES20.glUseProgram(this.mProgram[0]);
        GLES20.glEnableVertexAttribArray(this.mProgramPositionHandle[0]);
        GLES20.glEnableVertexAttribArray(this.mProgramColorHandle[0]);
        GLES20.glEnableVertexAttribArray(this.mProgramTextureCoordinateHandle[0]);

        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, this.mIndexHandle[0]);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, this.mPositionHandle[0]);
        GLES20.glVertexAttribPointer(this.mProgramPositionHandle[0], 4, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, this.mColorHandle[0]);
        GLES20.glVertexAttribPointer(this.mProgramColorHandle[0], 4, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, this.mTextureCoordinateHandle[0]);
        GLES20.glVertexAttribPointer(this.mProgramTextureCoordinateHandle[0], 2, GLES20.GL_FLOAT, false, 0, 0);

        GLES20.glUniform4fv(this.mFragmentProgramColorHandle[0],1, this.mColor, 0);

        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        if (textureHandle == null)
        {
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, this.mTextureHandle[0]);
        }
        else
        {
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle[0]);
        }
        GLES20.glUniform1i(this.mFragmentProgramTextureHandle[0], 0);

        GLES20.glDrawElements(GLES20.GL_TRIANGLES, mIndexArray.length, GLES20.GL_UNSIGNED_SHORT, 0);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);

        GLES20.glDisableVertexAttribArray(this.mProgramPositionHandle[0]);
        GLES20.glDisableVertexAttribArray(this.mProgramColorHandle[0]);
        GLES20.glDisableVertexAttribArray(this.mProgramTextureCoordinateHandle[0]);
        GLES20.glUseProgram(0);
    }

    private void setColors(float r, float g, float b)
    {
        this.mColor[0] = r;
        this.mColor[1] = g;
        this.mColor[2] = b;
        this.mColor[3] = 1.0f;
    }
}

