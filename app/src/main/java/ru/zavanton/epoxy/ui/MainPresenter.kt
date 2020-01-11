package ru.zavanton.epoxy.ui

import io.reactivex.disposables.CompositeDisposable
import ru.zavanton.epoxy.domain.StudentInteractor
import timber.log.Timber

class MainPresenter constructor(
    private val studentInteractor: StudentInteractor
) {

    private val disposables = CompositeDisposable()

    fun loadStudents() {

        val data = studentInteractor.fetchStudents()

        disposables.add(data.subscribe(
            {
                Timber.d("zavanton - students: $it")
            },
            {
                Timber.e("Failed to get students")
            }
        ))
    }
}