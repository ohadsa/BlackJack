package gini.ohadsa.may23

import java.util.*

class Deck (private val cardDeck : Stack<Card> = Stack<Card>() ){
    init{
        for(suit in SuitsEnum.values() )
            for(rank in RanksEnum.values()  )
                cardDeck.push(Card(rank , suit))
        shuffle()
    }

    private fun shuffle() {
        cardDeck.shuffle()
    }

    fun dealCard(): Card {
        return cardDeck.pop()
    }





}


