package com.staffbase.dojo.tcg.game

class PlayerDiedException(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
class InvalidActionException(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
