# Kotlin Code Dojo #01

## Einführung

Der Fokus der Veranstaltung liegt darauf, TTD (Test Driven Development) zu üben
und sich ein wenig mit Best Practices in Kotlin auseinander zu setzen.

Es wird die aktuelle Sprachversion 1.3 genutzt und es stehen potenziell Coroutinen zur Verfügung.
Für Dependency Injection kommt [Koin](https://insert-koin.io/docs/1.0/getting-started/kotlin/) zum Einsatz.

Für Tests stehen zur Verfügung:

* [kotlin.test](https://kotlinlang.org/api/latest/kotlin.test/index.html) mit [kotlin.test.junit5](https://kotlinlang.org/api/latest/kotlin.test/kotlin.test.junit5/index.html)
* [JUnit 5](https://junit.org/junit5/docs/current/user-guide/) einschließlich der experimentellen parametrisierten Tests
* [AssertK](https://github.com/willowtreeapps/assertk)
* [Mockito Kotlin](https://github.com/nhaarman/mockito-kotlin)
* [Koin Test](https://insert-koin.io/docs/1.0/getting-started/junit-test/)

Es gelten die allgemeinen Code Dojo Regeln:

* Zuerst Tests schreiben
* Kleinstmögliche Schritte

Ebenfalls soll der TDD Zyklus angewendet werden:

1. Fehlschlagenden Test schreiben (gitmoji: `:white_check_mark:`)
2. Getestetes Verhalten implementieren (gitmoji: `:sparkles:`)
3. Refaktorieren (gitmoji: `:recycle:`)

Nach jedem entsprechenden Schritt, sollte der aktuelle Stand committed werden.
Dazu sind die obigen Gitmojis zu verwenden.

## Die Aufgabe

Das Ziel ist es, ein kleines Sammelkartenspiel zu implementieren.
Die Regeln sind wie folgt:

### Preparation

* Each player starts the game with 30 Health and 0 Mana slots
* Each player starts with a deck of 20 Damage cards with the following Mana costs: 0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8
* From the deck each player receives 3 random cards has his initial hand

### Gameplay

* The active player receives 1 Mana slot up to a maximum of 10 total slots
* The active player’s empty Mana slots are refilled
* The active player draws a random card from his deck
* The active player can play as many cards as he can afford. Any played card empties Mana slots and deals immediate damage to the opponent player equal to its Mana cost.
* If the opponent player’s Health drops to or below zero the active player wins the game
* If the active player can’t (by either having no cards left in his hand or lacking sufficient Mana to pay for any hand card) or simply doesn’t want to play another card, the opponent player becomes active

### Special Rules

* Bleeding Out: If a player’s card deck is empty before the game is over he receives 1 damage instead of drawing a card when it’s his turn.
* Overload: If a player draws a card that lets his hand size become >5 that card is discarded instead of being put into his hand.
* Dud Card: The 0 Mana cards can be played for free but don’t do any damage either. They are just annoyingly taking up space in your hand.

## Hinweise

Es existiert bereits ein Fundament um einige Paradigmen, sowie die grundlegende Nutzung einiger der Bibliotheken zu veranschaulichen.
Der vorgefundene Code kann prinzipiell komplett umgeschrieben werden. Teilweise wird dies sogar notwendig sein.

Eine grafische Oberfläche, oder Nutzerinteraktion im Allgemeinen, ist für den Anfang nicht erforderlich.
In erster Linie sollen die Regeln des Spiels umgesetzt werden.
