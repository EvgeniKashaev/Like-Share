package ru.netology.nmedia.repository

import java.math.BigDecimal
import java.math.RoundingMode

object UIFormatter {
    fun format(count: Int): String =
        when (count) {
            in 0..999 -> count.toString()
            in 1000..9999 -> {
                val number = BigDecimal(count)

                val result = number.divide(BigDecimal(1_000), 1, RoundingMode.FLOOR)

                result.toPlainString() + "K"
            }

            in 10_000..999_999 -> {
                val number = BigDecimal(count)

                val result = number.divide(BigDecimal(1_000), RoundingMode.FLOOR)

                result.toPlainString() + "K"
            }

            else -> {

                val number = BigDecimal(count)

                val result = number.divide(BigDecimal(1_000_000), RoundingMode.FLOOR)

                result.toPlainString() + "M"
            }
        }
}
