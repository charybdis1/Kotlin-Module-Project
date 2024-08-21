import java.util.Scanner

class SelectMenu(
    private val scanner: Scanner,
    listName: String,
    itemToCreate: String,
    dataItems: Collection<MenuItem>,
    onItemSelected: (Int) -> Unit,
) {
    init {
        while (true) {
            println(listName)
            val menuItems = mutableListOf<MenuItem>(
                TextItem("Создать $itemToCreate"),
                TextItem("Выход"),
            )
            menuItems.addAll(1, dataItems)

            menuItems.forEachIndexed { index, item ->
                println("$index. ${item.name}")
            }

            println("Введите номер пункта меню:")
            if (scanner.hasNextInt()) {
                val input = scanner.nextInt()
                skipNewline()
                if (input in 0 until menuItems.size) {
                    println("Выбран пункт меню $input")
                    println()
                    if (input == menuItems.size - 1) {
                        break
                    }
                    onItemSelected(input)
                } else {
                    println("Такого пункта нет в меню, повторите ввод")
                }
            } else {
                println("Вводите только числа")
                skipNewline()
            }
            println()
        }
    }

    private fun skipNewline() {
        scanner.nextLine()
    }
}