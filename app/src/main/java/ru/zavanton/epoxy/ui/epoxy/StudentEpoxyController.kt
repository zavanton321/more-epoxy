package ru.zavanton.epoxy.ui.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import ru.zavanton.epoxy.domain.Student

class StudentEpoxyController : TypedEpoxyController<List<Student>>() {

    override fun buildModels(students: List<Student>) {
        students.forEachIndexed { index, student ->
            StudentEpoxyModel_()
                .id(index)
                .firstName(student.firstName)
                .lastName(student.lastName)
                .age(student.age)
                .addTo(this)
        }
    }
}