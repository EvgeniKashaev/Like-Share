package ru.netology.nmedia

import java.math.BigDecimal
import java.math.RoundingMode

object UIFormatter {
    fun format(count: Int): String =
        when (count) {
            in 0..999 -> count.toString()
            in 1000..999_999 -> {
                val number = BigDecimal(count)

                val result = number.divide(BigDecimal(1_000), 1, RoundingMode.FLOOR)

                result.toPlainString() + "K"
            }

            else -> {

                val number = BigDecimal(count)

                val result = number.divide(BigDecimal(1_000_000), 1, RoundingMode.FLOOR)

                result.toPlainString() + "M"
            }


        }
}
