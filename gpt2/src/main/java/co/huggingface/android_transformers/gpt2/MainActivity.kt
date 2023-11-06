package co.huggingface.android_transformers.gpt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.radiobutton.MaterialRadioButton
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import co.huggingface.android_transformers.gpt2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val gpt2: co.huggingface.android_transformers.gpt2.ml.GPT2Client by viewModels()
    private val llm: co.huggingface.android_transformers.gpt2.ml.LLMNextWord by viewModels()

    private var radioGroup: RadioGroup? = null
    private lateinit var radioButton: MaterialRadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bind layout with ViewModel
        binding.vm = gpt2
//        binding.llm_vm = llm

        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this

    }


    fun onRadioButtonClicked(view: View) {

        val listOfTokens = llm.promptToken()

        // Assigning id of RadioGroup
        radioGroup = findViewById(R.id.radioGroup)

        // Get the clicked radio button instance
        radioButton = radioGroup?.let { findViewById(it.checkedRadioButtonId) }!!
        if (radioButton != null) {
            Log.d("RADIO", "${radioButton.text} is checked!")
            Toast.makeText(applicationContext,"On click : ${radioButton.text}",
                Toast.LENGTH_SHORT).show()
        }


//        if (view is MaterialRadioButton) {
//            val checked = view.isChecked
//
//            when (view.getId()) {
//                R.id.tokenOption1 ->
//                    if (checked) {
//                        Log.d("RADIO", "${radioButton.text} is checked")
//                    }
//                R.id.tokenOption2 ->
//                    if (checked) {
//                        Log.d("RADIO", "${radioButton.text} is checked")
//                    }
//                R.id.tokenOption3 ->
//                    if (checked) {
//                        Log.d("RADIO", "${radioButton.text} is checked")
//                    }
//            }
//        }
    }
}
