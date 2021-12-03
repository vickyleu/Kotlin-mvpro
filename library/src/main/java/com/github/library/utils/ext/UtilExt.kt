/*
 * Copyright (C) 2017 Ricky.yao https://github.com/vihuela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */

package com.github.library.utils.ext

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson

//Fragment
fun Fragment.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    val toast = ToastUtils.make()
    when (length) {
        Toast.LENGTH_SHORT -> {
            toast.setDurationIsLong(false)
            toast.show(msg)
        }
        Toast.LENGTH_LONG -> {
            toast.setDurationIsLong(true)
            toast.show(msg)
        }
    }
}

//Activity
fun Activity.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    val toast = ToastUtils.make()
    when (length) {
        Toast.LENGTH_SHORT -> {
            toast.setDurationIsLong(false)
            toast.show(msg)
        }
        Toast.LENGTH_LONG -> {
            toast.setDurationIsLong(true)
            toast.show(msg)
        }
    }
}

fun Activity.hideKeyboard(): Boolean {
    val view = currentFocus
    view?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
    return false
}

//Application
fun Application.getRunningProcessList(): MutableList<ActivityManager.RunningAppProcessInfo>? {
    val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    return am.runningAppProcesses
}

fun Application.getProcessName(): String? {
    val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    return am.runningAppProcesses
        ?.find { it.pid == android.os.Process.myPid() }
        ?.processName
}

fun Application.killCurrentProcess() {
    android.os.Process.killProcess(android.os.Process.myPid())
}

//gson
inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

//log
inline fun <reified T> T.L(message: Any, tag: String = T::class.java.simpleName) {
    Log.d(tag, message.toString())
}


