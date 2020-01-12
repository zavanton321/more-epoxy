package ru.zavanton.epoxy.ui.epoxy

import com.airbnb.epoxy.EpoxyController
import ru.zavanton.epoxy.ItemStudentBindingModel_
import ru.zavanton.epoxy.domain.Student

class StudentEpoxyController : EpoxyController() {

    private val students: MutableList<Student> = mutableListOf()

    override fun buildModels() {
        students.forEachIndexed { index, student ->
            ItemStudentBindingModel_()
                .id(index)
                .student(student)
                .addTo(this)
        }
    }

    fun updateStudents(data: List<Student>) {
        students.clear()
        students.addAll(data)
    }
}