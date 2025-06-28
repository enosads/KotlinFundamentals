package desafios

import java.time.LocalDateTime

// Task data class with required properties
data class Task(
    val id: Int,
    val title: String,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        private var nextId = 1

        fun generateId(): Int {
            return nextId++
        }
    }
}

// Sealed class for operation results
sealed class OperationResult {
    data class Success(val message: String) : OperationResult()
    data class Error(val message: String) : OperationResult()
}

// TaskManager class with required methods
class TaskManager {
    private val tasks = mutableListOf<Task>()

    // Add a new task
    fun addTask(title: String, description: String? = null): OperationResult {
        try {
            require(title.isNotEmpty()) { "Title cannot be empty" }

            val id = Task.generateId()
            val task = Task(id, title, description)
            tasks.add(task)

            return OperationResult.Success("Tarefa adicionada com sucesso! ID: $id")
        } catch (e: IllegalArgumentException) {
            return OperationResult.Error(e.message ?: "Unknown error")
        }
    }

    // List all tasks
    fun listAllTasks() {
        println("Tarefas:")
        tasks.forEach { task ->
            val (title, isCompleted) = task
            println("($title, $isCompleted)")
        }
    }

    // Find task by ID
    fun findTaskById(id: Int): Task? {
        return tasks.find { it.id == id }
    }

    // Update task status
    fun updateTaskStatus(id: Int, isCompleted: Boolean): OperationResult {
        try {
            val task = findTaskById(id)
            require(task != null) { "Task with ID $id not found" }

            val index = tasks.indexOf(task)
            tasks[index] = task.copy(isCompleted = isCompleted)

            return OperationResult.Success("Status da tarefa ID $id atualizado para $isCompleted")
        } catch (e: IllegalArgumentException) {
            return OperationResult.Error(e.message ?: "Unknown error")
        }
    }

    // Delete task
    fun deleteTask(id: Int): OperationResult {
        try {
            val task = findTaskById(id)
            require(task != null) { "Task with ID $id not found" }

            tasks.remove(task)

            return OperationResult.Success("Tarefa com ID $id removida com sucesso")
        } catch (e: IllegalArgumentException) {
            return OperationResult.Error(e.message ?: "Unknown error")
        }
    }

    // Filter tasks by completion status
    fun filterTasks(completed: Boolean): List<Task> {
        return tasks.filter { it.isCompleted == completed }
    }
}

// Extension function to convert Task to formatted string
fun Task.toFormattedString(): String {
    return "ID: $id | Título: $title | Concluído: $isCompleted | Criado em: $createdAt"
}

// Extension function to count completed tasks
fun List<Task>.countCompleted(): Int {
    return count { it.isCompleted }
}

fun main() {
    val taskManager = TaskManager()

    // Add tasks
    val result1 = taskManager.addTask("Comprar pão")
    println(result1)

    val result2 = taskManager.addTask("Estudar Kotlin")
    println(result2)

    val result3 = taskManager.addTask("Fazer exercícios")
    println(result3)

    // List all tasks
    println()
    taskManager.listAllTasks()

    // Update task status
    val updateResult = taskManager.updateTaskStatus(1, true)
    println(updateResult)

    // List completed tasks
    println()
    println("Tarefas concluídas:")
    taskManager.filterTasks(true).forEach {
        println(it.toFormattedString())
    }

    // Delete task
    val deleteResult = taskManager.deleteTask(2)
    println(deleteResult)
}
