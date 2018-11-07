package com.staffbase.dojo.tcg.game

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEqualTo
import assertk.assertions.isTrue
import com.staffbase.dojo.tcg.AbstractTest
import org.junit.jupiter.api.Test
import org.koin.standalone.get
import org.koin.standalone.inject
import kotlin.test.assertEquals

class PlayerTest : AbstractTest() {
  private val defaultPlayer: Player by inject()

  @Test
  fun `Default player fulfills requirements`() {
    // Each player starts the game with 30 Health and 0 Mana slots
    // Each player starts with a deck of 20 Damage cards with the following Mana costs:
    //   0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8
    // From the deck each player receives 3 random cards has his initial hand
    with(defaultPlayer) {
      assert(life).isEqualTo(30)
      assert(mana).isEqualTo(0)
      assert(manaSlots).isEqualTo(0)
      assert(deck.size).isEqualTo(17)
      assert(hand.size).isEqualTo(3)

      val cardCounts = (deck + hand).groupingBy { it }.eachCount()
      assert(cardCounts[0]).isEqualTo(2)
      assert(cardCounts[1]).isEqualTo(2)
      assert(cardCounts[2]).isEqualTo(3)
      assert(cardCounts[3]).isEqualTo(4)
      assert(cardCounts[4]).isEqualTo(3)
      assert(cardCounts[5]).isEqualTo(2)
      assert(cardCounts[6]).isEqualTo(2)
      assert(cardCounts[7]).isEqualTo(1)
      assert(cardCounts[8]).isEqualTo(1)
    }
  }

  @Test
  fun `Players start with differing cards`() {
    val secondPlayer: Player = get()

    assert(defaultPlayer.deck).isNotEqualTo(secondPlayer.deck)
    assert(defaultPlayer.hand).isNotEqualTo(secondPlayer.hand)
  }

  @Test
  fun `Add mana slot increases the number of mana slots`() {
    val beforeSlot = defaultPlayer.manaSlots
    defaultPlayer.addManaSlot()
    val afterSlot = defaultPlayer.manaSlots
    assertEquals(expected = beforeSlot + 1, actual = afterSlot)
  }

  @Test
  fun `Check if mana slot count inceases only to ten`() {
    repeat(11) {
      defaultPlayer.addManaSlot()
    }
    assertEquals(defaultPlayer.manaSlots, 10)
  }

  @Test
  fun `Mana can be refilled`() {
    val expectedManaSlots = 4

    repeat(expectedManaSlots) {
      defaultPlayer.addManaSlot()
    }

    assert(defaultPlayer.mana).isEqualTo(0)
    defaultPlayer.refillMana()
    assert(defaultPlayer.mana).isEqualTo(expectedManaSlots)
  }

  @Test
  fun `Consuming mana reduce available mana`() {
    defaultPlayer.addManaSlot()
    defaultPlayer.refillMana()

    val manaConsumed = defaultPlayer.consumeMana(1)

    assert(defaultPlayer.mana).isEqualTo(0)
    assert(manaConsumed).isTrue()
  }


}
