package view

import TicTacToeApp
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import tornadofx.*
import kotlin.system.exitProcess

class MenuView : View(TicTacToeApp.appName) {
    override val root = borderpane {
        setPrefSize(800.0, 600.0)
        top {
            label(TicTacToeApp.appName) {
                addClass("title")
                BorderPane.setAlignment(this, Pos.CENTER)
            }
        }
        center {
            vbox {
                alignment = Pos.CENTER
                button("PLAY") {
                    addClass("buttonView")
                    action {
                        replaceWith<GameView>()
                    }
                }
                button("EXIT") {
                    addClass("buttonView")
                    action {
                        exitProcess(0)
                    }
                }
            }
        }
    }
}
