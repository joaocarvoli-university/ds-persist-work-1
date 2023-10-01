package ui

import ui.screens.compress.CompressFileScreen
import ui.screens.convert.ConvertCsvToJsonScreen
import ui.screens.convert.ConvertCsvToXmlScreen
import ui.screens.dataProfiling.CsvDataProfilingScreen
import ui.screens.registerData.RegisterDataInCSVScreen
import ui.screens.validation.SHA256GeneratorScreen
import utils.TextsOptions

object MainScreen {
    private var closeScreen = false

    fun showOptions(): Boolean {
        println("> MAIN MENU: Select the option for the functionality <")
        TextsOptions.mainScreenOptions.forEachIndexed { index, item ->
            println("(${index + 1}) - $item")
        }
        print("> insert value: ")
        val mainScreenOptionInput : Int = readln().toInt()

        when(mainScreenOptionInput){
            1 -> while (true) if(RegisterDataInCSVScreen.showOptions()) break
            2 -> ConvertCsvToJsonScreen.showOptions()
            3 -> ConvertCsvToXmlScreen.showOptions()
            4 -> CsvDataProfilingScreen.showOptions()
            5 -> CompressFileScreen.showOptions()
            6 -> SHA256GeneratorScreen.showOptions()
            7 -> closeScreen = true
        }

        return closeScreen
    }
}