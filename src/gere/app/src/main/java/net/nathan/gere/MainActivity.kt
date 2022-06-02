package net.nathan.gere

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.nathan.gere.databinding.ActivityMainBinding
//import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val format = "dd-MM-yyyy"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // take current date
        //val currentDate = getCurrentDate()

        // create an calendar instance
        val calendar = Calendar.getInstance()

        val date = DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            checking(calendar)
        }

        binding.calcule.setOnClickListener {
            DatePickerDialog(this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)).show()
        }


    }


    /*
    * return the current date

    private fun getCurrentDate(): Date {
        //val sdf = SimpleDateFormat(format, Locale.FRANCE)
        return Calendar.getInstance().time
    }

    private fun updateLabel(calendar: Calendar) {
        val sdf = SimpleDateFormat(format, Locale.FRANCE)
        val dateInit = calendar.time
        val convention = 14
        binding.textD.setText(sdf.format(dateInit))
        calendar.add(Calendar.DAY_OF_MONTH, convention)
        val dateOv = calendar.time
        binding.textO.setText(sdf.format(dateOv))
    }
    */

    private fun checking(selected : Calendar){
        //val sdf = SimpleDateFormat(format, Locale.FRANCE)
        val now = Calendar.getInstance().time
        val selectedDate = selected.time
        val comp = now.compareTo(selectedDate)
        when{
            // this section was making in paste
            comp < 0 ->{
                Toast.makeText(this, R.string.error_cal, Toast.LENGTH_SHORT).show()
            }
            else ->{
                Toast.makeText(this, "correct !!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}