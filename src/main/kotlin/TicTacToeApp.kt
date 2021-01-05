import javafx.stage.Stage
import tornadofx.*

class TicTacToeApp : App(MenuView::class, TicTacToeStyle::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.isResizable = false
    }

    companion object {
        const val appName: String = "Tic-Tac-Toe"
    }
}
fun main(args: Array<String>){
    launch<TicTacToeApp>()
}