import java.util.Scanner

fun main() {

    val archivesSet = mutableSetOf<Archive>()

    val scanner = Scanner(System.`in`)

    SelectMenu(
        scanner,
        "Список архивов",
        "архив",
        archivesSet
    ) { archiveIndex ->
        if (archiveIndex == 0) {
            createArchive(scanner, archivesSet)
        } else {
            selectArchive(archivesSet, archiveIndex, scanner)
        }
    }
}

private fun selectArchive(
    archivesSet: MutableSet<Archive>,
    archiveIndex: Int,
    scanner: Scanner
) {
    val archive = archivesSet.elementAt(archiveIndex - 1)
    SelectMenu(
        scanner,
        "Список заметок в архиве ${archive.name}",
        "заметку",
        archive.notes
    ) { noteIndex ->
        if (noteIndex == 0) {
            createNote(scanner, archive)
        } else {
            val note = archive.notes.elementAt(noteIndex - 1)
            println("Заметка ${note.name}:")
            println(note.text)
        }
    }
}

private fun createNote(scanner: Scanner, archive: Archive) {
    CreateMenu(scanner, "заметку") { noteName ->
        val note = Note(noteName)
        if (archive.notes.add(note)) {
            println("Заметка с названием $noteName создана")
            CreateNoteMenu(scanner) {
                note.text = it
            }
        } else {
            println("Заметка с названием $noteName уже существует")
        }
    }
}

private fun createArchive(
    scanner: Scanner,
    archivesSet: MutableSet<Archive>
) {
    CreateMenu(scanner, "архив") { archiveName ->
        if (archivesSet.add(Archive(archiveName))) {
            println("Архив с названием $archiveName создан")
        } else {
            println("Архив с названием $archiveName уже существует")
        }
    }
}