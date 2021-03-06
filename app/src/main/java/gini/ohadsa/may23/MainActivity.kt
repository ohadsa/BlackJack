package gini.ohadsa.may23

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import gini.ohadsa.may23.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var game : Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // with binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickListeners()
    }



    private fun initClickListeners() {
        binding.play.setOnClickListener{
            initGameViews()
            showGame()
        }
        binding.hitButton.setOnClickListener{
            game.hit()
            showGame()
        }

        binding.standButton.setOnClickListener{
            game.stand()
            showGame()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun showGame() {

        if(!game.isGameInProgress){
            binding.standButton.visibility = View.GONE
            binding.hitButton.visibility = View.GONE
            binding.play.visibility = View.VISIBLE
        }
        binding.tvPlayer.text = game.playerHand.getStrOfCards()
        binding.tvDealer.text = game.dealerHand.getStrOfCards()
        binding.tvDealerScore.text = game.dealerHand.getValue().toString()
        binding.tvPlayerScore.text = game.playerHand.getValue().toString()
        binding.tvWinner.text = "Winner : ${game.winner.name}"
        if (game.iSBlackJack)
            binding.tvWinner.text = "⭐  B-L-A-C-K-J-A-C-K ⭐ "


    }


    private fun initGameViews() {
        game = Game()

        binding.standButton.visibility = View.VISIBLE
        binding.hitButton.visibility = View.VISIBLE
        binding.play.visibility = View.GONE

    }
}