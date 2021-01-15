package controller

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaGetter

internal class TicTacToeControllerTest {
    @Test
    fun testCheckBoardForWin() {
        val controller = TicTacToeController(true)
        val checkBoardForWin =
            controller::class.memberFunctions.first { it.name == "checkBoardForWin" }.also { it.isAccessible = true }
        val resetRound =
            controller::class.memberFunctions.first { it.name == "resetRound" }.also { it.isAccessible = true }
        val boardSize = controller::class.memberProperties.first { it.name == "boardSize" }
            .also { it.isAccessible = true }.getter.call(controller) as Int
        val sign = "X"

        for (j in 0 until boardSize) {
            //columns wins
            for (i in 0 until boardSize) {
                controller.board.fields["$i$j"] = sign
                if (i == boardSize - 1) {
                    assertEquals(sign, checkBoardForWin.call(controller, "$i$j"))
                }
            }
            resetRound.call(controller)
            //rows wins
            for (i in 0 until boardSize) {
                controller.board.fields["$j$i"] = sign
                if (i == boardSize - 1) {
                    assertEquals(sign, checkBoardForWin.call(controller, "$j$i"))
                }
            }
            resetRound.call(controller)
        }
        //diagonal win
        for (i in 0 until boardSize) {
            controller.board.fields["$i$i"] = sign
            if (i == boardSize - 1) {
                assertEquals(sign, checkBoardForWin.call(controller, "$i$i"))
            }
        }
        resetRound.call(controller)
        //anti-diagonal win
        for (i in 0 until boardSize) {
            controller.board.fields["$i${boardSize - 1 - i}"] = sign
            if (i == boardSize - 1) {
                assertEquals(sign, checkBoardForWin.call(controller, "$i${boardSize - 1 - i}"))
            }
        }
    }

    @Test
    fun testUpdateScoreGameOver() {
        val controller = TicTacToeController(true)
        val maxRoundsCount = controller::class.memberProperties.first { it.name == "maxRoundsCount" }
            .also { it.isAccessible = true }.getter.call(controller) as Int
        val updateScore =
            controller::class.memberFunctions.first { it.name == "updateScore" }.also { it.isAccessible = true }

        val signs = listOf("X", "O")
        for (sign in signs) {
            for (i in 1..maxRoundsCount) {
                updateScore.call(controller, sign)
                if (i == 1) assertFalse(controller.score.isGameOver.value)
                if (sign == "X")
                    assertEquals(i, controller.score.x.value)
                else if (sign == "O")
                    assertEquals(i, controller.score.o.value)
            }
            assertTrue(controller.score.isGameOver.value)
            if (sign == "X")
                assertEquals("X WINS", controller.score.won.value)
            else if (sign == "O")
                assertEquals("O WINS", controller.score.won.value)
            controller.resetGame()
        }
    }
}