package com.example.memorize

import android.app.Activity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppController() : ViewModel() {
    private var _textString: String = "1"
    val textString get() = _textString

    val uiManager: UIManager = UIManager(this)

    @OptIn(DelicateCoroutinesApi::class)
    fun addNum() {
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                delay(1000)
                _textString = (_textString.toInt() + 1).toString()
                uiManager.setText(_textString)
            }
        }
    }
    fun init(activity: Activity) {
        uiManager.init(activity)
    }
}