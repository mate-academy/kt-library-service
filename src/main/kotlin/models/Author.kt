package models

data class Author(private var name: String) {
    fun getName(): String {
        return name
    }

    fun setName(newName: String) {
        name = newName
    }
}
