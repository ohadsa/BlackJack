package gini.ohadsa.may23

class Hand (var cards : MutableList<Card>? = null ){


    fun addCard(card : Card){

        if(cards == null )
            cards = mutableListOf(card)
        else {
            cards?.add(card)
        }
    }


    fun getValue():Int{
        var result = 0
        var numOfAces = 0
        cards?.forEach { card ->
            result += card.rank.value
            if(card.rank == RanksEnum.ACE )
                numOfAces++
        }

        if (result > 21 && numOfAces > 0 ){
            while(result > 21 && numOfAces > 0 ) {
                result -= 10
                numOfAces--
            }
        }
        return result
    }


    fun getStrOfCards(): CharSequence? {
        var str = StringBuffer()
        if(cards != null ) {
            for (card in cards!!){
                str.append(card.rank).append(", ")
            }
        }
        return str
    }

}