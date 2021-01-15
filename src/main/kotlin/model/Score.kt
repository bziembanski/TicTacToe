package model

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class Score(x: Int = 0, o: Int = 0) {
    val xProperty = SimpleIntegerProperty(this, "X", x)

    val oProperty = SimpleIntegerProperty(this, "o", o)

    val isGameOverProperty = SimpleBooleanProperty(this, "isGameOver", false)

    val isRoundOverProperty = SimpleBooleanProperty(this, "isRoundOver", false)

    val wonProperty = SimpleStringProperty(this, "won", "TIE")
}