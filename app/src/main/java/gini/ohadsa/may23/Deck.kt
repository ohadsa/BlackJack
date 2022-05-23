package gini.ohadsa.may23

import java.util.*
import java.util.Collections.shuffle

class Deck (private val cardDeck : Stack<Card> = Stack<Card>() ){
    init{
        var tmpList = mutableListOf<Card>()
        for(suit in SuitsEnum.values() )
            for(rank in RanksEnum.values()  )
                tmpList.add(Card(rank , suit))

        for( card in tmpList)
            cardDeck.push(card)
        shuffle()

    }

    fun shuffle() {
        cardDeck.shuffle()
    }

    fun dealCard(): Card {
        return cardDeck.pop()
    }





}


