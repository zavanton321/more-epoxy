package ru.zavanton.epoxy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.zavanton.epoxy.R
import ru.zavanton.epoxy.data.StudentRepository
import ru.zavanton.epoxy.domain.StudentInteractor
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("zavanton - ok")

        loadStudents()
    }

    private fun loadStudents() {
        val presenter = MainPresenter(StudentInteractor(StudentRepository())) // TODO zavanton - replace by di
        presenter.loadStudents()
    }
}
