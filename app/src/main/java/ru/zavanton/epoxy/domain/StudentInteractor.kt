package ru.zavanton.epoxy.domain

import io.reactivex.Single
import ru.zavanton.epoxy.data.StudentRepository

class StudentInteractor constructor(
    private val studentRepository: StudentRepository
) {

    fun fetchStudents(): Single<List<Student>> = studentRepository.getStudents()
}