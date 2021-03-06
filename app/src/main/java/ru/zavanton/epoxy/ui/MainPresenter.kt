package ru.zavanton.epoxy.ui

import io.reactivex.disposables.CompositeDisposable
import ru.zavanton.epoxy.di.ActivityScope
import ru.zavanton.epoxy.domain.StudentInteractor
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(
    private val studentInteractor: StudentInteractor
) {

    private val disposables = CompositeDisposable()
    var view: MainActivity? = null

    fun loadStudents() {

        val data = studentInteractor.fetchStudents()

        disposables.add(data.subscribe(
            {
                view?.showStudents(it)
            },
            {
                Timber.e("Failed to get students")
            }
        ))
    }
}