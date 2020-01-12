package ru.zavanton.epoxy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import ru.zavanton.epoxy.R
import ru.zavanton.epoxy.app.App
import ru.zavanton.epoxy.databinding.ActivityMainBinding
import ru.zavanton.epoxy.domain.Student
import ru.zavanton.epoxy.ui.epoxy.StudentEpoxyController
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityMainBinding
    private lateinit var studentEpoxyController: StudentEpoxyController

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        presenter.view = this

        studentEpoxyController = StudentEpoxyController()
        binding.rvStudents.layoutManager = LinearLayoutManager(this)
        binding.rvStudents.adapter = studentEpoxyController.adapter

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
