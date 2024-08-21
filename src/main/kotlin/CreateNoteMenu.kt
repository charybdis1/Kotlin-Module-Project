import java.util.Scanner

class CreateNoteMenu(
    scanner: Scanner,
    onTextInput: (String) -> Unit,
) {
    init {
        while (true) {
            println("Введите текст заметки:")
            if (scanner.hasNextLine()) {
                val input = scanner.nextLine()
                if (input.isNotBlank()) {
                    onTextInput(input)
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
        println("Текст не должен быть пустым")
    }
}