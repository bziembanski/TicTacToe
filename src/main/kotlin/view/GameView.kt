package view

import TicTacToeApp
import controller.TicTacToeController
import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.layout.Priority
import tornadofx.*
import kotlin.system.exitProcess

class GameView : View(TicTacToeApp.appName) {
    private val controller: TicTacToeController by inject()

    override val root = borderpane {
        top {
            gridpane {
                alignment = Pos.CENTER
                label(controller.score.won) {
                    addClass("gameViewLabel")
                    visibleWhen { controller.score.isGameOver }
                    gridpaneConstraints {
                        columnRowIndex(0, 0)
                        hAlignment = HPos.LEFT
                        vAlignment = VPos.CENTER
                    }
                    gridpaneColumnConstraints {
                        isFillWidth = true
                        hgrow = Priority.ALWAYS
                    }
                }
                button("RESET") {
                    addClass("buttonView")
                    addClass("gameViewButton")
                    gridpaneConstraints {
                        columnRowIndex(2, 0)
                        hAlignment = HPos.RIGHT
                        vAlignment = VPos.CENTER
                    }
                    gridpaneColumnConstraints {
                        isFillWidth = true
                        hgrow = Priority.ALWAYS

                    }
                    action {
                        controller.resetGame()
                    }
                }
                button("EXIT") {
                    addClass("buttonView")
                    addClass("gameViewButton")
                    gridpaneConstraints {
                        columnRowIndex(2, 1)
                        hAlignment = HPos.RIGHT
                        vAlignment = VPos.CENTER
                    }
                    gridpaneColumnConstraints {
                        isFillWidth = true
                        hgrow = Priority.ALWAYS
                    }
                    action {
                        exitProcess(0)
                    }
                }
            }
        }
        left {
            vbox {
                label("X:") {
                    addClass("gameViewLabel")
                }
                label(controller.score.x) {
                    addClass("gameViewLabel")
                }
            }

        }
        right {
            vbox {
                label("O:") {
                    addClass("gameViewLabel")
                    addClass("rightLabel")
                }
                label(controller.score.o) {
                    addClass("gameViewLabel")
                    addClass("rightLabel")
                }
            }

        }
        center {
            gridpane {
                disableWhen { controller.score.isGameOver }
                addClass("boardView")
                alignment = Pos.CENTER
                useMaxWidth = true
                useMaxHeight = true
                useMaxSize = true
                for (i in 0..2) {
                    for (j in 0..2) {
                        button(controller.board.fields.valueAt("$i$j")) {
                            addClass("tileView")
                            alignment = Pos.CENTER
                            gridpaneConstraints {
                                columnRowIndex(j, i)
                            }
                            disableWhen { controller.score.isRoundOver }
                            action {
                                controller.fillField("$i$j")
                            }
                        }
                    }
                }
            }
        }
    }
}