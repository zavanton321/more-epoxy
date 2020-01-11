package ru.zavanton.epoxy.data

import io.reactivex.Single
import ru.zavanton.epoxy.domain.Student

class StudentRepository {

    fun getStudents(): Single<List<Student>> =
        Single.just(
            listOf(
                Student("Mike", "Tyson", 43),
                Student("Jack", "Stones", 43),
                Student("Tom", "Carp", 43),
                Student("Nick", "Abs", 43),
                Student("Tony", "Noes", 43),
                Student("James", "Zav", 43),
                Student("Ron", "Tick", 43),
                Student("Don", "Williams", 43),
                Student("Leo", "Jackson", 43),
                Student("Raph", "Obers", 43),
                Student("Sue", "Nides", 43)
            )
        )
}