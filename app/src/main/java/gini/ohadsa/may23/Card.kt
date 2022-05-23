package gini.ohadsa.may23

data class Card (val rank : RanksEnum , val suits : SuitsEnum )
enum class RanksEnum(val value :Int){
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), PRINCE(10), QUEEN(10), KING(10), ACE(11)
}

enum class SuitsEnum(val value: Char){ DIAMONDS('♦'), CLUBS('♣'), HEARTS('♥'), SPADES('♠') }