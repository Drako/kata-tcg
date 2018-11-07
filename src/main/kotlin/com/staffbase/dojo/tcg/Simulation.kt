package com.staffbase.dojo.tcg

import com.staffbase.dojo.tcg.game.Game
import org.koin.log.EmptyLogger
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject

fun main() {
  startKoin(listOf(TcgModule), logger = EmptyLogger())
  object : KoinComponent {
    val game: Game by inject()
  }.game.play()
}
