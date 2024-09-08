package com.example.memorize

import android.app.Activity
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UIManager(
    private val appController: AppController
) {
    private lateinit var textView: TextView
    private lateinit var activity: Activity

    fun init(activity: Activity) {
        this.activity = activity
        activity.setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(activity.findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textView = activity.findViewById(R.id.text)
        textView.setOnClickListener {
            appController.addNum()
        }
        textView.text = appController.textString
    }

    fun setText(text:String) {
        textView.text = text
    }
}