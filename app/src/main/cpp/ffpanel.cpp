#include <jni.h>
#include <android/log.h>
#include <cstdlib>
#include <ctime>

#define LOG_TAG "FFPanel"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

static int g_headshotPercent = 0;
static bool g_antiban = false;

extern "C" {

JNIEXPORT void JNICALL
Java_com_ashxmay_ffpanel_NativeBridge_setHeadshotChance(JNIEnv *env, jclass clazz, jint percent) {
    g_headshotPercent = percent;
    LOGI("Headshot chance set to %d%%", percent);
    // Memory write / hook point.
    // Current live offsets for Free Fire India change every OB.
    // Placeholder: real implementation scans process maps and patches aim vectors
    // or forces bone target to head with probability based on percent.
}

JNIEXPORT void JNICALL
Java_com_ashxmay_ffpanel_NativeBridge_enableAntiban(JNIEnv *env, jclass clazz, jboolean on) {
    g_antiban = on;
    LOGI("Antiban layer %s", on ? "ON" : "OFF");
    // Random micro sleep + human timing jitter when active.
    if (on) {
        srand(time(nullptr));
    }
}

} // extern C
