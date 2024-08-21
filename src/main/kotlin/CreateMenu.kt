import java.util.Scanner

class CreateMenu(
    scanner: Scanner,
    itemToCreate: String,
    onNameInput: (String) -> Unit,
) {
    init {
        while (true) {
            println("Создать $itemToCreate")
            println("Введите название:")
            if (scanner.hasNextLine()) {
                val input = scanner.nextLine()
                if (input.isNotBlank()) {
                    onNameInput(input)
                    break
                } else {
                    printError()
                }
            } else {
                printError()
                scanner.nextLine()
            }
            println()
        }
    }

    private fun printError() {
        println("Название не должно быть пустым")
    }
}