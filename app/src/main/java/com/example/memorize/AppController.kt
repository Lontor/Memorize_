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
    val collectionManager: CollectionManager = CollectionManager()

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

    fun addCard(collectionName: String, cardName: String, cardTranslation: String) {
        val card: Card = Card(collectionName, cardName, cardTranslation)
        collectionManager.addCard(card)
    }

    fun getCollections(){
        collectionManager.getCollections()
    }


    fun init(activity: Activity) {
        uiManager.init(activity)
    }
}