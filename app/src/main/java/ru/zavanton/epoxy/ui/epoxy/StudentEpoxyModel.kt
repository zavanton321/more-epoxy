package ru.zavanton.epoxy.ui.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_student.view.*
import ru.zavanton.epoxy.R

@EpoxyModelClass(layout = R.layout.item_student)
abstract class StudentEpoxyModel : EpoxyModelWithHolder<StudentEpoxyModel.StudentHolder>() {

    @EpoxyAttribute
    var firstName: String = ""

    @EpoxyAttribute
    var lastName: String = ""

    @EpoxyAttribute
    var age: Int = 0

    override fun bind(holder: StudentHolder) {
        holder.tvFirstName.text = firstName
        holder.tvLastName.text = lastName
        holder.tvAge.text = age.toString()
    }

    inner class StudentHolder : EpoxyHolder() {

        lateinit var tvFirstName: TextView
        lateinit var tvLastName: TextView
        lateinit var tvAge: TextView

        override fun bindView(itemView: View) {
            tvFirstName = itemView.tvFirstName
            tvLastName = itemView.tvLastName
            tvAge = itemView.tvAge

        }
    }
}