LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_LDLIBS := -lGLESv2
LOCAL_MODULE := JniUtils
LOCAL_SRC_FILES =: JniUtils.cpp
include $(BUILD_SHARED_LIBRARY)