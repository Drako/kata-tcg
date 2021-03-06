package com.grossweber.dojo.tcg.game

import assertk.assert
import assertk.assertions.isEqualTo
import com.nhaarman.mockitokotlin2.verify
import com.grossweber.dojo.tcg.AbstractTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.koin.standalone.get
import org.koin.standalone.inject
import org.koin.test.declareMock

class GameTest : AbstractTest() {
  private val defaultGame: Game by inject()

  @Test
  fun `Game requires exactly two players`() {
    assertThrows<AssertionError> { Game(listOf(), listOf(get(), get())) }
    assertThrows<AssertionError> { Game(listOf(get()), listOf(get(), get())) }
    assertThrows<AssertionError> { Game(listOf(get(), get(), get()), listOf(get(), get())) }

    assert(defaultGame.players.size).isEqualTo(2)
  }

  @Test
  fun `Game requires exactly two controllers`() {
    assertThrows<AssertionError> { Game(listOf(get(), get()), listOf()) }
    assertThrows<AssertionError> { Game(listOf(get(), get()), listOf(get())) }
    assertThrows<AssertionError> { Game(listOf(get(), get()), listOf(get(), get(), get())) }

    assert(defaultGame.controllers.size).isEqualTo(2)
  }

  @Test
  fun `At the start of the turn the current player should draw a card`() {
    declareMock<Player>()
    defaultGame.startTurn(0)
    verify(defaultGame.players[0]).draw(1)
  }
}
