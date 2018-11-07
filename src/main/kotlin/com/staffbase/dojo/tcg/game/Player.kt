package com.staffbase.dojo.tcg.game

import kotlin.math.min

/**
 * Class representing a player's state.
 *
 * Methods of this class are used to modify or query said state.
 * The Player class is not active itself.
 */
open class Player(
  life: Int,
  deck: List<Int>
) : PlayerState {
  override var life: Int = life
    protected set

  override var mana: Int = 0
    protected set

  var deck: List<Int> = deck
    private set

  override var hand: List<Int> = listOf()
    protected set

  var manaSlots: Int = 0
    private set

  init {
    draw(3)
  }

  /**
   * Draw [numberOfCards] cards from the [deck] and put them onto the [hand].
   *
   * @param numberOfCards The number of cards to draw.
   * @throws PlayerDiedException if the player died.
   */
  fun draw(numberOfCards: Int = 1) {
    if (deck.size < numberOfCards) {
      TODO()
    } else {
      hand += deck.take(numberOfCards)
      deck = deck.drop(numberOfCards)
    }
  }



  /**
   * Consume [amount] mana points if possible.
   *
   * @param amount The amount of mana points to be consumed.
   * @return true, if enough mana was available, false otherwise.
   */
  fun consumeMana(amount: Int): Boolean = if (amount <= mana) {
    mana -= amount
    true
  } else {
    false
  }

  /**
   * Remove [amount] health points.
   *
   * @param amount The amount of health points to be removed.
   * @throws PlayerDiedException if the player died.
   */
  fun takeDamage(amount: Int) {
    TODO()
  }

  fun addManaSlots(amount: Int = 1) {
    manaSlots = min(10, manaSlots + amount)
  }

  fun addManaSlot() = addManaSlots()

  fun refillMana() {
    mana = manaSlots
  }
}
