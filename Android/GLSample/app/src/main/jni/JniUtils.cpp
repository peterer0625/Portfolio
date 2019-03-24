//
// Created by KT on 3/24/2019.
//

#include "com_example_kt_glsample_JniUtils.h"
#include <GLES3/gl3.h>

void JNICALL Java_com_example_kt_glsample_JniUtils_glReadPixels
    (JNIEnv *env, jclass cls, jint x, jint y, jint width, jint height, jint format, jint type)
{
    glReadPixels(x, y, width, height, format, type, 0);
}