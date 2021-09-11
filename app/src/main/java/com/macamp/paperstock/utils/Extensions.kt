package com.macamp.paperstock.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.slf4j.LoggerFactory
import java.util.logging.Logger

inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}


inline fun <reified T:Any> logger() = LoggerFactory.getLogger(T::class.java)
fun Activity.toast(msg:String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(msg:String){
    Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
}

