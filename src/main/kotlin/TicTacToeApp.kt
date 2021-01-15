import javafx.stage.Stage
import tornadofx.*
import view.MenuView
import view.TicTacToeStyle

class TicTacToeApp : App(MenuView::class, TicTacToeStyle::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.minHeight = 580.0
        stage.minWidth = 520.0
    }

    companion object {
        const val appName: String = "Tic-Tac-Toe"
    }
}
fun main(args: Array<String>){
    launch<TicTacToeApp>()
}