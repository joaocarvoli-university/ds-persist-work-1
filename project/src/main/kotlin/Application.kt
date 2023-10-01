import ui.MainScreen

object Application {
    fun runApp(args: Array<String>){
        println("------------- Starting application -------------")
        while(true){
            if(MainScreen.showOptions()){
                break
            }
        }
        println("------------- Closing application -------------")
    }
}