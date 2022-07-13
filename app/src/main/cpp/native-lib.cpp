
#include <jni.h>
#include <string>


extern "C" JNIEXPORT jstring JNICALL
Java_com_gibox_testandroid_AppController_baseUrl(JNIEnv *env,jobject /* this */){
    std::string baseUrl = "put here your base URL"; /* prod */
    return env->NewStringUTF(baseUrl.c_str());
}