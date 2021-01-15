package model

import javafx.beans.property.SimpleMapProperty
import javafx.collections.FXCollections

class Board {
    private val keys = mutableListOf<String>()

    init {
        for (i in 0..2) {
            for (j in 0..2) {
                keys.add("$i$j")
            }
        }
    }

    val fieldsProperty = SimpleMapProperty(
        this,
        "fields",
        FXCollections.observableMap(keys.map { it to "" }.toMap())
    )

}