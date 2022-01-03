data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if ((year - other.year) != 0) return year - other.year
        if ((month - other.month) != 0) return month - other.month
        if ((dayOfMonth - other.dayOfMonth) != 0) return dayOfMonth - other.dayOfMonth
        return 0
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
