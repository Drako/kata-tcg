package com.grossweber.dojo.tcg.game

/**
 * The state of a player.
 */
interface PlayerState {
  /**
   * The current health points of the player.
   */
  val life: Int

  /**
   * The current mana of the player.
   */
  val mana: Int

  /**
   * The hand cards of the player.
   */
  val hand: List<Int>
}
