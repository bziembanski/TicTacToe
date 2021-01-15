package model

import tornadofx.ItemViewModel

class ScoreModel(score: Score) : ItemViewModel<Score>(score) {
    val x = bind(autocommit = true) {
        item.xProperty
    }
    val o = bind(autocommit = true) {
        item.oProperty
    }
    val isGameOver = bind(autocommit = true) {
        item.isGameOverProperty
    }
    val isRoundOver = bind(autocommit = true) {
        item.isRoundOverProperty
    }
    val won = bind(autocommit = true) {
        item.wonProperty
    }
}