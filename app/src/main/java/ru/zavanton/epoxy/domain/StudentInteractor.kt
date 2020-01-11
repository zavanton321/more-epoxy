package ru.zavanton.epoxy.domain

import io.reactivex.Single
import ru.zavanton.epoxy.data.StudentRepository
import ru.zavanton.epoxy.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class StudentInteractor @Inject constructor(
    private val studentRepository: StudentRepository
) {

    fun fetchStudents(): Single<List<Student>> = studentRepository.getStudents()
}