package com.pepivsky.myspinnerdatepicker

/*import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.**/
import android.app.DatePickerDialog
import android.content.res.Configuration
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.TimeZone

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextTextPersonName)

        editText.setOnClickListener {
            openSpinnerBirthdayDialog()
        }
    }


    private fun openSpinnerBirthdayDialog() {
        val calendar = Calendar.getInstance().apply {
            add(Calendar.YEAR, -18)
        }

        DatePickerDialog(this, R.style.SpinnerDatePickerDialog, { _, year, month, dayOfMonth ->
            //Toast.makeText(this, formatDate(year, month, dayOfMonth), Toast.LENGTH_SHORT).show()
            //editText.setText(formatDate(year, month, dayOfMonth))
            editText.setText("$year-$month-$dayOfMonth")

        },
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        ).apply {
            datePicker.maxDate = Date().time
        }.show()
    }


    private fun formatDate(date: Date) = SimpleDateFormat.getDateInstance().apply { timeZone = TimeZone.getTimeZone("UTC") }.format(date)

    private fun formatDate(year: Int, month: Int, dayOfMonth: Int) = formatDate(Calendar.getInstance().apply {
        timeZone = TimeZone.getTimeZone("UTC")
        set(year, month, dayOfMonth)
    }.time)


}