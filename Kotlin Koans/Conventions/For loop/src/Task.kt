class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var current = start
            override fun hasNext(): Boolean {
                return current <= end
            }

            override fun next(): MyDate {
                if(hasNext()) {
                    val res = current
                    current = current.followingDate()
                    return res
                }
                throw NoSuchElementException()
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}