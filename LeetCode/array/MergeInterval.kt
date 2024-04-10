class MergeIntevals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }

        intervals.sortWith(Comparator { a, b -> a.first().compareTo(b.first()) })

        var result = arrayOf<IntArray>(intervals.first())

        for (i in 1..intervals.size - 1) {
            var resultLast = result.last()

            if (resultLast.canMerge(intervals[i]) != 0) {
                print(resultLast.first().toString() + " " + resultLast.last().toString() )
                return result.plus(intervals.copyOfRange(i, intervals.size))
            }

            result = result.copyOfRange(0, result.size - 1)
            result = result.plus(resultLast.merge(intervals[i]))
        }

        return result
    }

    fun IntArray.canMerge(array: IntArray): Int {

        if (last() < array.first()) {
            return -1
        }
        if (first() > array.last()) {
            return 1
        }
        return 0
    }

    fun IntArray.merge(array: IntArray): Array<IntArray> {
        var start = Math.min(first(), array.first())
        var end = Math.max(last(), array.last())
        return arrayOf(intArrayOf(start, end))
    }
}
