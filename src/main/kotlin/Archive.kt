data class Archive(
    override val name: String,
) : MenuItem {
    val notes = mutableSetOf<Note>()
}