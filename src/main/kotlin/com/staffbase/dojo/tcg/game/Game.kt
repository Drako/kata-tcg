package com.staffbase.dojo.tcg.game

class Game(
  val players: List<Player>,
  val controllers: List<Controller>
) {
  init {
    assert(players.size == 2)
    assert(controllers.size == 2)
  }

  /**
   * Main loop of the game.
   *
   * @todo Might need some exception handling.
   */
  fun play() {
    var currentPlayer = 0
    var otherPlayer = 1

    while (allPlayersAreAlive()) {
      startTurn(currentPlayer)
      ActionLoop@ while (playerCanAct(currentPlayer)) {
        val action = controllers[currentPlayer].play(players[currentPlayer], players[otherPlayer])
        when (action) {
          Action.Pass -> break@ActionLoop
          is Action.PlayCard -> playCard(currentPlayer, otherPlayer, action)
        }
      }
      currentPlayer = otherPlayer.also { otherPlayer = currentPlayer }
    }
    declareWinner()
  }

  private fun allPlayersAreAlive(): Boolean {
    TODO()
  }

  fun startTurn(player: Int) {
    // The active player draws a random card from his deck
    players[player].draw(1)
    // TODO: The active player receives 1 Mana slot up to a maximum of 10 total slots
    // TODO: The active player’s empty Mana slots are refilled
  }

  private fun playerCanAct(player: Int): Boolean {
    TODO()
  }

  /**
   * @throws InvalidActionException if the card cannot be played.
   */
  private fun playCard(player: Int, target: Int, action: Action.PlayCard) {
    TODO()
  }

  private fun declareWinner() {
    TODO()
  }
}
