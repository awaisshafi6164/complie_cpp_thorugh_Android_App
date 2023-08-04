#include <jni.h>
#include <string>
#include <iostream>
using namespace std;

extern "C" JNIEXPORT jint JNICALL
Java_com_example_cpp_1compiler_MainActivity_getAnswer(JNIEnv *env, jobject thiz, jint num1,
                                                      jint num2, jstring check_btn) {

    const char* operatorStr = env->GetStringUTFChars(check_btn, nullptr);
    std::string operatorString(operatorStr);

    int result = 0;

    if (operatorString == "+") {
        result = num1 + num2;
    } else if (operatorString == "-") {
        result = num1 - num2;
    } else if (operatorString == "*") {
        result = num1 * num2;
    } else if (operatorString == "/") {
        if (num2 != 0) {
            result = num1 / num2;
        } else {
            result = -1;
        }
    } else {
        result = -2;
    }

    env->ReleaseStringUTFChars(check_btn, operatorStr);

    return result;
}