package model

import tornadofx.ItemViewModel

class BoardModel(board: Board) : ItemViewModel<Board>(board) {
    val fields = bind(autocommit = true) {
        item.fieldsProperty
    }
}