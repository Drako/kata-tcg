package com.staffbase.dojo.tcg.game

/**
 * Controllers implement the behaviour of the players by examining both states and returning an action to be done.
 */
interface Controller {
  fun play(ownState: PlayerState, enemyState: PlayerState): Action
}
