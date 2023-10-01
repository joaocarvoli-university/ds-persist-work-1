package ui.screens.registerData

import utils.TextsOptions

object RegisterDataInCSVScreen {
    private var closeScreen = false

    fun showOptions(): Boolean {
        println("\n-----> REGISTER DATA MENU: Select the option for the functionality <-----")
        TextsOptions.registerDataScreenOptions.forEachIndexed { index, item ->
            println("(${index + 1}) - $item")
        }
        print("> insert value: ")
        val registerDataScreenOptionInput : Int = readln().toInt()

        when(registerDataScreenOptionInput){
            1 -> {
                RegisterProduct.showOptions()
                closeScreen = false
            }
            2 -> closeScreen = true
        }

        println()
        return closeScreen
    }
}