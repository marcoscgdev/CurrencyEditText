package com.marcoscg.currencyedittext

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import java.text.NumberFormat
import java.util.Locale
import java.util.Currency

class CurrencyEditText : AppCompatEditText {

    private var locale: Locale? = null
    private var currency: Currency? = null
    private var maxLength: Int = 30
    private var value = 0.0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        inputType = InputType.TYPE_CLASS_NUMBER
        locale = Locale.getDefault()
        currency = Currency.getInstance(locale)

        addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var cleanString = s.toString().replace("\\D+".toRegex(), "") // Get only digits

                // If max length is exceeded, remove new digit
                if (cleanString.length > maxLength) {
                    cleanString = cleanString.substring(0, cleanString.length - 1)
                }

                val parsed = cleanString.toDouble()

                value = parsed / 100

                val formatted = NumberFormat.getCurrencyInstance(locale).format(value)

                removeTextChangedListener(this) // Prevent calling this watcher when formatting the text

                setText(formatted)
                setSelection(getEndingSelection())

                addTextChangedListener(this)
            }
        })

        if (text.isNullOrEmpty()) {
            setText("0")
        }
    }

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)

        if (selectionEnd != getEndingSelection()) {
            setSelection(getEndingSelection())
        }
    }

    fun setLocale(locale: Locale) {
        this.locale = locale
        currency = Currency.getInstance(locale)

        setText((value * 100).toInt().toString())
    }

    fun setMaxLength(maxLength: Int) {
        this.maxLength = maxLength + 2 // Add number of decimals
    }

    fun getNumericValue(): Double {
        return value
    }

    private fun getEndingSelection(): Int {
        val string = text.toString()

        return if (string.isNotEmpty() && string.last().isDigit()) {
            // Currency symbol is on the left side
            string.length
        } else {
            // Currency symbol is on the right side, the cursor must be before it
            string.replace("[${currency?.symbol}\\s]".toRegex(), "").length
        }
    }

}