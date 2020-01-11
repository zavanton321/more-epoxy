package ru.zavanton.epoxy.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_student.view.*
import ru.zavanton.epoxy.R
import ru.zavanton.epoxy.domain.Student

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private val students: MutableList<Student> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_student, parent, false)
        )

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    fun updateStudents(data: List<Student>) {
        students.clear()
        students.addAll(data)
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvFirstName: TextView = itemView.tvFirstName
        private val tvLastName: TextView = itemView.tvLastName
        private val tvAge: TextView = itemView.tvAge

        fun bind(student: Student) {
            tvFirstName.text = student.firstName
            tvLastName.text = student.lastName
            tvAge.text = student.age.toString()
        }
    }
}
