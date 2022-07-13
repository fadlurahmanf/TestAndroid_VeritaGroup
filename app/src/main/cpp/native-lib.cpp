
#include <jni.h>
#include <string>


extern "C" JNIEXPORT jstring JNICALL
Java_com_gibox_testandroid_AppController_baseUrl(JNIEnv *env,jobject /* this */){
    std::string baseUrl = "https://reqres.in/"; /* prod */
    return env->NewStringUTF(baseUrl.c_str());
}