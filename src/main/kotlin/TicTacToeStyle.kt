import javafx.scene.paint.Color
import tornadofx.*

class TicTacToeStyle : Stylesheet() {
    companion object {
        val title by cssclass("title")
        val buttonView by cssclass("buttonView")
        val gameViewLabel by cssclass("gameViewLabel")
        val gameViewButton by cssclass("gameViewButton")
        val rightLabel by cssclass("rightLabel")
        val tileView by cssclass("tileView")
        val boardView by cssclass("boardView")
    }

    init {
        title {
            fontSize = 30.px
            padding = box(100.px, 0.px, 0.px, 0.px)
        }
        buttonView {
            fontSize = 30.px
            minWidth = 200.px
            padding = box(0.px, 0.px, 30.px, 0.px)
            borderInsets = multi(box(0.px, 0.px, 30.px, 0.px))
            backgroundInsets = multi(box(0.px, 0.px, 30.px, 0.px))
        }
        gameViewLabel {
            fontSize = 20.px
            padding = box(30.px, 0.px, 0.px, 30.px)
            borderInsets = multi(box(30.px, 0.px, 0.px, 30.px))
            backgroundInsets = multi(box(30.px, 0.px, 0.px, 30.px))
        }
        gameViewButton {
            padding = box(30.px, 30.px, 0.px, 0.px)
            borderInsets = multi(box(30.px, 30.px, 0.px, 0.px))
            backgroundInsets = multi(box(30.px, 30.px, 0.px, 0.px))
        }
        rightLabel {
            padding = box(30.px, 30.px, 0.px, 0.px)
            borderInsets = multi(box(30.px, 30.px, 0.px, 0.px))
            backgroundInsets = multi(box(30.px, 30.px, 0.px, 0.px))
        }
        tileView {
            borderRadius += box(0.px)
            borderWidth += box(1.px)
            borderColor += box(Color.BLACK)
            backgroundColor += c("#f4f4f4")
            minHeight = 125.px
            minWidth = 125.px
            fontSize = 40.px
        }
        boardView {
            padding = box(30.px)
        }
    }
}