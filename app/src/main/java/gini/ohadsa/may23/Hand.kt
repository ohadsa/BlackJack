package gini.ohadsa.may23

class Hand (private var cards : MutableList<Card>? = null ){


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


    fun getStrOfCards(): String {
        val str = StringBuffer()
        if(cards != null ) {
            for (card in cards!!){
                str.append(card.rank).append(card.suits.value).append("   ")
            }
        }

        return str.substring(0,str.length-3).toString()
    }

}