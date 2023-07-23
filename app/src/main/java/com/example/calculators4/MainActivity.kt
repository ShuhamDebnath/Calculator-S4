package com.example.calculators4

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.example.calculators4.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFour: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSix: Button
    private lateinit var buttonSeven: Button
    private lateinit var buttonEight: Button
    private lateinit var buttonNine: Button
    private lateinit var buttonZero: Button

    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var buttonEquals: Button

    private lateinit var buttonClear: Button
    private lateinit var buttonCloseBracket: Button
    private lateinit var buttonDot: Button
    private lateinit var buttonDel: Button
    private lateinit var buttonOpenBracket: Button


    private lateinit var displayMain: TextView
    private lateinit var displayHint: TextView
    private lateinit var mode: ImageView
    private var isLastEqualClicked = false
    private var isNightMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()

        setMode()
        setStatusBar()

        clearHintDisplay()
        clearMainDisplay()
        buttons()

    }

    private fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.button_bg)
            if (!isNightMode) {
                window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    private fun setMode() {
        isNightMode = isNightModeActivated()
        if (isNightMode) {
//            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            isNightMode = true
            setNightMode()
        } else {
//            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
            isNightMode = false
            setDayMode()
        }
    }

    private fun isNightModeActivated(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }

    private fun initialize() {
        buttonOne = binding.one
        buttonTwo = binding.two
        buttonThree = binding.three
        buttonFour = binding.four
        buttonFive = binding.five
        buttonSix = binding.six
        buttonSeven = binding.seven
        buttonEight = binding.eight
        buttonNine = binding.nine
        buttonZero = binding.zero

        buttonAdd = binding.add
        buttonSub = binding.subtract
        buttonMul = binding.multiply
        buttonDiv = binding.divide
        buttonEquals = binding.equal

        buttonClear = binding.clearScreen
        buttonCloseBracket = binding.closeBracket
        buttonDot = binding.dot
        buttonDel = binding.delete
        buttonOpenBracket = binding.openBracket

        displayMain = binding.display2
        displayHint = binding.display1
        mode = binding.modeSelect
    }

    private fun buttons() {

        buttonZero.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonZero.text.toString())
        }
        buttonOne.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonOne.text.toString())
        }
        buttonTwo.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonTwo.text.toString())
        }
        buttonThree.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonThree.text.toString())
        }
        buttonFour.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonFour.text.toString())
        }
        buttonFive.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonFive.text.toString())
        }
        buttonSix.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonSix.text.toString())
        }
        buttonSeven.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonSeven.text.toString())
        }
        buttonEight.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonEight.text.toString())
        }
        buttonNine.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonNine.text.toString())
        }
        buttonDot.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonDot.text.toString())
        }
        buttonZero.setOnClickListener {
            if (isLastEqualClicked) {
                clearMainDisplay()
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonZero.text.toString())
        }
        buttonAdd.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonAdd.text.toString())
        }
        buttonSub.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonSub.text.toString())
        }
        buttonMul.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonMul.text.toString())
        }
        buttonDiv.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonDiv.text.toString())
        }
        buttonOpenBracket.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonOpenBracket.text.toString())
        }
        buttonCloseBracket.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            displayMain.text = addText(buttonCloseBracket.text.toString())
        }
        buttonClear.setOnClickListener {
            if (isLastEqualClicked) {
                isLastEqualClicked = false
            }
            if (displayMain.text == "") {
                clearHintDisplay()
            } else {
                clearMainDisplay()
            }
        }
        buttonDel.setOnClickListener {
            if (displayMain.text != "") {
                val text = displayMain.text.toString()
                clearMainDisplay()
                displayMain.text = text.substring(0, text.length - 1)
            }
        }
        buttonEquals.setOnClickListener {
            isLastEqualClicked = true
            calculateResult()
        }

        mode.setOnClickListener {
            isNightMode = !isNightMode
            if (isNightMode) {
//                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
                setNightMode()
            } else {
//                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show()
                setDayMode()
            }
        }

    }

    private fun setDayMode() {
//        Toast.makeText(this, "Day", Toast.LENGTH_SHORT).show()
        mode.setImageResource(R.drawable.light_mode)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun setNightMode() {

//        Toast.makeText(this, "Night", Toast.LENGTH_SHORT).show()
        mode.setImageResource(R.drawable.dark_mode)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun addText(string: String): String {
        return "${displayMain.text}${string}"
    }

    private fun clearHintDisplay() {
        displayHint.text = null
    }

    private fun clearMainDisplay() {
        displayMain.text = null
    }

    private fun getInputOperation(): String {
        displayHint.text = displayMain.text
        var expression = displayMain.text.toString()
        expression = expression.replace(Regex("÷"), "/")   // ALT + 0247 -> ÷
        expression = expression.replace(Regex("×"), "*")   // ALT + 0215 -> ×
        return expression
    }

    private fun calculateResult() {

        try {
            val expression = getInputOperation()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //Show Error
                displayMain.text = getString(R.string.error)
            } else {
                //Show Result
                displayMain.text = DecimalFormat("0.########").format(result).toString()
            }

        } catch (e: Exception) {
            //Show Error
            displayMain.text = getString(R.string.error)
        }


        //Process with Rhino engine
//        val engine = ScriptEngineManager().getEngineByName("rhino")
//        val result = expression.toString()
//        clearExpression()
//        expression.append(engine.eval(result))
    }

}