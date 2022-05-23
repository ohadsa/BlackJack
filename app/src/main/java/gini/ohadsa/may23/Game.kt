package gini.ohadsa.may23

class Game(private val mDeck : Deck = Deck(), val  playerHand : Hand = Hand(), val dealerHand : Hand = Hand(), var  isGameInProgress : Boolean = true, var  iSBlackJack : Boolean = false, var winner : Winner = Winner.SOON) {


    enum class Winner { PLAYER, DEALER, TIE, SOON }
    init{
        playerHand.addCard(mDeck.dealCard())
        dealerHand.addCard(mDeck.dealCard())
        playerHand.addCard(mDeck.dealCard())

        if(playerHand.getValue() ==  BlackJack ) {
            isGameInProgress = false
            iSBlackJack = true
            winner = Winner.PLAYER
        }
    }

    fun hit(){
        playerHand.addCard(mDeck.dealCard())
        if(playerHand.getValue() >  BlackJack ){
            isGameInProgress = false
            winner = Winner.DEALER
        }
        if(playerHand.getValue() ==  BlackJack){
            stand()
        }
    }

    fun stand() {
       while(dealerHand.getValue() < 17 ) {
           dealerHand.addCard(mDeck.dealCard())
       }

        when{
            dealerHand.getValue() > BlackJack && playerHand.getValue() > BlackJack -> winner = Winner.TIE
            dealerHand.getValue() > BlackJack  -> winner = Winner.PLAYER
            playerHand.getValue() > BlackJack -> winner = Winner.DEALER
            playerHand.getValue() > dealerHand.getValue()  -> winner = Winner.PLAYER
            dealerHand.getValue() > playerHand.getValue() -> winner = Winner.DEALER
            dealerHand.getValue() == playerHand.getValue() -> winner = Winner.TIE
        }
        isGameInProgress = false
    }


}

var BlackJack = 21