package ru.zavanton.epoxy.data

import io.reactivex.Single
import ru.zavanton.epoxy.di.ActivityScope
import ru.zavanton.epoxy.domain.Student
import javax.inject.Inject

@ActivityScope
class StudentRepository @Inject constructor() {

    fun getStudents(): Single<List<Student>> =
        Single.just(
            listOf(
                Student("Mike", "Tyson", 43),
                Student("Jack", "Stones", 32),
                Student("Tom", "Carp", 41),
                Student("Nick", "Abs", 22),
                Student("Tony", "Noes", 56),
                Student("James", "Zav", 46),
                Student("Ron", "Tick", 61),
                Student("Don", "Williams", 12),
                Student("Leo", "Jackson", 32),
                Student("Raph", "Obers", 36),
                Student("Sue", "Nides", 64)
            )
        )
}