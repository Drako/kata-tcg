package com.staffbase.dojo.tcg.game

/**
 * Class representing a player's state.
 *
 * Methods of this class are used to modify or query said state.
 * The Player class is not active itself.
 */
class Player(
  life: Int,
  deck: List<Int>
) : PlayerState {
  override var life: Int = life
    private set

  override var mana: Int = 0
    private set

  var deck: List<Int> = deck
    private set

  override var hand: List<Int> = listOf()
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
  fun consumeMana(amount: Int): Boolean {
    TODO()
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
}
