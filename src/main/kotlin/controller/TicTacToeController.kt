package controller

import javafx.application.Platform
import model.Board
import model.BoardModel
import model.Score
import model.ScoreModel
import tornadofx.Controller
import java.util.*
import kotlin.collections.set
import kotlin.concurrent.schedule

class TicTacToeController(private val test: Boolean = false) : Controller() {
    val board = BoardModel(Board())
    val score = ScoreModel(Score())
    private val boardSize = 3
    private val maxRoundsCount = 5
    private var sign = "X"
    private var movesCount = 0

    private fun isFieldEmpty(field: String): Boolean {
        return board.fields[field] == ""
    }

    fun fillField(field: String) {
        if (isFieldEmpty(field)) {
            movesCount++
            board.fields[field] = sign
            val win = checkBoardForWin(field)
            if (win != "0") {
                updateScore(win)
            } else if (win == "0" && movesCount == 9) {
                roundEnd()
            }
            changeSign()
        }
    }

    private fun changeSign() {
        sign = if (sign == "X") "O" else "X"
    }

    private fun checkBoardForWin(field: String): String {
        //check row
        val row = field[0]
        for (col in 0 until boardSize) {
            if (board.fields["$row$col"] != sign)
                break
            if (col == boardSize - 1)
                return sign
        }
        //check col
        val column = field[1]
        for (r in 0 until boardSize) {
            if (board.fields["$r$column"] != sign)
                break
            if (r == boardSize - 1)
                return sign
        }
        //check diag
        if (field[0] == field[1]) {
            for (i in 0 until boardSize) {
                if (board.fields["$i$i"] != sign)
                    break
                if (i == boardSize - 1) {
                    return sign
                }

            }
        }
        //check anti-diag
        if ((Integer.parseInt(field.substring(0, 1)) + Integer.parseInt(field.substring(1))) == (boardSize - 1)) {

            for (i in 0 until boardSize) {
                if (board.fields["$i${(boardSize - 1) - i}"] != sign)
                    break
                if (i == boardSize - 1) {
                    return sign
                }

            }
        }
        return "0"
    }

    private fun updateScore(sign: String) {
        if (sign == "X") {
            score.x.value++
            if (score.x.value == maxRoundsCount) {
                score.won.value = "X WINS"
                score.isGameOver.value = true
            }
        } else {
            score.o.value++
            if (score.o.value == maxRoundsCount) {
                score.won.value = "O WINS"
                score.isGameOver.value = true
            }
        }
        roundEnd()
    }

    private fun roundEnd() {
        score.isRoundOver.value = true
        if(test){
            resetRound()
            score.isRoundOver.value = false
        }else{
            Timer().schedule(5000) {
                Platform.runLater {
                    score.isRoundOver.value = false
                    resetRound()
                }
            }
        }

    }

    private fun resetRound() {
        sign = "X"
        board.fields.forEach { t, _ -> board.fields[t] = "" }
        movesCount = 0
    }

    fun resetGame() {
        resetRound()
        score.x.value = 0
        score.o.value = 0
        score.isRoundOver.value = false
        score.isGameOver.value = false
    }
}