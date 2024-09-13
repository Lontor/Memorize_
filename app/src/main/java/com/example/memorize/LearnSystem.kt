package com.example.memorize

class LearnSystem(collectionManager: CollectionManager) {
    fun getCard(collectionId: Long,cardsPerDay: Int):Card {
        return Card(1,"Atomic", "Атомный")
        //TODO
    }

    fun rateCard(currentCollectionId: Long?, card: Card, mark: Int) {
        //TODO
    }
}