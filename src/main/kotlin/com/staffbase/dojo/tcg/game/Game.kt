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
    players[player].addManaSlot()
    players[player].refillMana()
    players[player].draw(1)
  }

  private fun playerCanAct(player: Int): Boolean {
    TODO()
  }

  /**
   * @throws InvalidActionException if the card cannot be played.
   */
  fun playCard(player: Int, target: Int, action: Action.PlayCard) {
    players[player].consumeMana(players[0].hand[action.index])
  }

  private fun declareWinner() {
    TODO()
  }
}
