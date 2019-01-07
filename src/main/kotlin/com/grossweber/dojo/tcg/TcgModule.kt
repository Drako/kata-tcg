package com.grossweber.dojo.tcg

import com.grossweber.dojo.tcg.game.AiController
import com.grossweber.dojo.tcg.game.Controller
import com.grossweber.dojo.tcg.game.Game
import com.grossweber.dojo.tcg.game.Player
import org.koin.dsl.module.module

private const val PLAYER_DEFAULT_LIFE = 30
private val PLAYER_DEFAULT_DECK = listOf(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8)

val TcgModule = module {
  factory {
    Player(
        life = PLAYER_DEFAULT_LIFE,
        deck = PLAYER_DEFAULT_DECK.shuffled()
    )
  }

  // to get different controllers, a factory can be used
  // or one could modify the Game instantiation below
  single { AiController() as Controller }

  single {
    Game(
        players = listOf(get(), get()),
        controllers = listOf(get(), get())
    )
  }
}
