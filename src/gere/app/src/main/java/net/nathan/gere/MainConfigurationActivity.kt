package net.nathan.gere

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.nathan.gere.databinding.ActivityMainConfigurationBinding

class MainConfigurationActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainConfigurationBinding

    val typePassword : Int = 129

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainConfigurationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val switcher = binding.switcher

        binding.nextButton.setOnClickListener(){

            if(switcher.currentView != binding.switchThree){
                if(switcher.currentView == binding.switchOne){
                    runCommandSwitchTwo()
                }
                switcher.showNext()
            }else{
                Toast.makeText(this, "vous avez atteint la limite", Toast.LENGTH_SHORT).show()
            }

        }



    }

    @SuppressLint("ClickableViewAccessibility")
    private fun runCommandSwitchTwo() {

        binding.editPassword.isEnabled = false
        binding.editConfirmPassword.isEnabled = false

        binding.usePassword.setOnCheckedChangeListener { compoundButton, b ->
            if (binding.usePassword.isChecked){
                // disable the
               binding.editPassword.isEnabled = true
               binding.editConfirmPassword.isEnabled = true

            }else{
                binding.editPassword.isEnabled = false
                binding.editConfirmPassword.isEnabled = false
            }
        }


        binding.showPassword.setOnClickListener(){

            if(binding.editPassword.isEnabled or binding.editConfirmPassword.isEnabled){
                if (binding.showPassword.isChecked){
                    // show password = 129
                    binding.editPassword.inputType = android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    binding.editConfirmPassword.inputType = android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

                }else{
                    binding.editPassword.inputType = typePassword
                    binding.editConfirmPassword.inputType = typePassword

                }
            }

        }
       // }
    }
}