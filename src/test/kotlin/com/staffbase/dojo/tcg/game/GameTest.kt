package com.staffbase.dojo.tcg.game

import assertk.assert
import assertk.assertions.isEqualTo
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.staffbase.dojo.tcg.AbstractTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
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
    verify(defaultGame.players[0], times(1)).draw(1)
  }

  @Test
  fun `At the start of the turn the current player should receive a mana slot`() {
    declareMock<Player>()
    defaultGame.startTurn(0)
    verify(defaultGame.players[0], times(1)).addManaSlot()
  }

  @Test
  fun `At the start of the turn the current player should refill the mana`() {
    declareMock<Player>()
    defaultGame.startTurn(0)
    verify(defaultGame.players[0], times(1)).refillMana()
  }

  @ParameterizedTest
  @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8])
  fun `Playing a card consumes mana`(cost: Int) {
    declareMock<Player>()
    whenever(defaultGame.players[0].hand).thenReturn(listOf(cost))
    defaultGame.playCard(0, 1, Action.PlayCard(0))
    verify(defaultGame.players[0], times(1)).consumeMana(cost)
  }
}
