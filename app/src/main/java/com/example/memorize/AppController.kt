package com.example.memorize

import CardCollection
import android.app.Activity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppController() : ViewModel() {
    private val collectionManager = CollectionManager()
    private val learnSystem = LearnSystem(collectionManager)

    private var currentCollectionId:Long? = null
    private var cardsPerPage = 20
    private var cardsPerDay = 20
    private var pageNumber = 0

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

    //Draw methods

    fun getCollections(){
        uiManager.drawCollectionList(collectionManager.getCollections())
    }

    fun getCardList(collectionId: Long, firstCardIndex:Int, cardCount:Int) {
        uiManager.drawCardList(collectionManager.getCardList())
    }

    //Card management methods

    fun deleteCard(collectionId: Long, cardId:Long) {
        collectionManager.deleteCard(collectionId, cardId)
    }

    fun addCard(collectionId: Long, cardName: String, cardTranslation: String) {
        val card: Card = Card(collectionId, cardName, cardTranslation)
        collectionManager.addCard(card)
    }

    fun editCard(collectionId: Long, cardName: String, cardTranslation: String) {
        val card: Card = Card(collectionId, cardName, cardTranslation)
        collectionManager.editCard(card)
    }

    //Learn system methods

    fun startLearning(collectionId: Long) {
        uiManager.showCard(learnSystem.getCard(collectionId, cardsPerDay))
    }

    fun rateCard(card: Card, mark:Int) {
        learnSystem.rateCard(currentCollectionId,card,mark)
    }

    fun init(activity: Activity) {
        uiManager.init(activity)
    }
}