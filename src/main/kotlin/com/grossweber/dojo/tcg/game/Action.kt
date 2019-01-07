package com.grossweber.dojo.tcg.game

sealed class Action {
  /**
   * End the turn for the player prematurely.
   */
  object Pass : Action()

  /**
   * Play the [index]th card from the current player's hand.
   *
   * @param index Which card to play.
   */
  class PlayCard(val index: Int) : Action()
}
