package ru.zavanton.epoxy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.zavanton.epoxy.R
import ru.zavanton.epoxy.app.App
import ru.zavanton.epoxy.domain.Student
import ru.zavanton.epoxy.ui.epoxy.StudentEpoxyController
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    private val studentEpoxyController = StudentEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.view = this

        rvStudents.layoutManager = LinearLayoutManager(this)
        rvStudents.adapter = studentEpoxyController.adapter

        loadStudents()
    }

    fun showStudents(students: List<Student>) {
        Timber.d("zavanton - students: $students")

        studentEpoxyController.updateStudents(students)
        studentEpoxyController.requestModelBuild()
    }

    private fun inject() {
        App.appComponent
            .mainActivityComponent()
            .inject(this)
    }

    private fun loadStudents() {
        presenter.loadStudents()
    }
}
