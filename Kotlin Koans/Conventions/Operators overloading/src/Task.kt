import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval,1)

operator fun MyDate.plus(interval : RepeatableTimeInterval) = this.addTimeIntervals(interval.timeInterval, interval.num)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
data class RepeatableTimeInterval(val timeInterval: TimeInterval, val num: Int)

private operator fun TimeInterval.times(i: Int): RepeatableTimeInterval = RepeatableTimeInterval(this,i)
