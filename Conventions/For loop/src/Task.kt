class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var date = start
            override fun hasNext(): Boolean {
                return date <= end
            }

            override fun next(): MyDate {
                val now = date
                date = date.followingDate()
                return now
            }

        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}