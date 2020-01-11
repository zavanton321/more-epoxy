package ru.zavanton.epoxy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.epoxy.R
import ru.zavanton.epoxy.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent
            .mainActivityComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadStudents()
    }

    private fun loadStudents() {
        presenter.loadStudents()
    }
}
