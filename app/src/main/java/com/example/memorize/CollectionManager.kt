package com.example.memorize

import CardCollection

class CollectionManager {
    fun addCard(card: Card){

    }

    fun getCollections():ArrayList<CardCollection> {
        return arrayListOf(CardCollection("Test1", 18),CardCollection("Test2", 112), CardCollection("Test3", 1800))
        //TODO
    }

    fun getCardList(): ArrayList<Pair<String, String>> {
        return arrayListOf(Pair("Hi", "Привет"),Pair("World", "Мир"), Pair("Map", "Карта"))
        //TODO
    }

    fun editCard(card: Card) {
        //TODO
    }

    fun deleteCard(collectionId: Long, cardId: Long) {
        //TODO
    }
}