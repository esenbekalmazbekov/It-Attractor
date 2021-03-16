package com.company

import kotlin.collections.ArrayList

fun main() {
    val daysPrice = ArrayList<Int>()

    initDaysPrice(daysPrice)
//    daysPrice.addAll(arrayOf(1, 1, 3, 1, 2))

    print("max profit = ${getMaxValue(daysPrice)}")
}

fun getMaxValue(daysPrice: ArrayList<Int>): Int {
    if (daysPrice.size == 0) return 0
    if (daysPrice.size == 1) return daysPrice[0]
    if (daysPrice.size == 2) {
        return if (daysPrice[0] > daysPrice[1]){
            (daysPrice[0] + daysPrice[1])
        } else {
            (daysPrice[1] * 2)
        }
    }
    var profit = 0
    var count = daysPrice[daysPrice.size - 1]
    var max = daysPrice[daysPrice.size - 1]
    for(i in daysPrice.size - 2 downTo 0) {
        if (max >= daysPrice[i]) {
            count += max
        } else {
            profit += (count + daysPrice[i])
            max = daysPrice[i]
            count = 0
        }
    }
    profit += count
    return profit
}

fun initDaysPrice(daysPrice: ArrayList<Int>) {
    for (i in 0..99) {
        daysPrice.add((Math.random() * 100).toInt())
    }
}
