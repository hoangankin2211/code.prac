open class InsertIntevals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.size == 0) {
            return arrayOf<IntArray>(newInterval)
        }   

        var result = arrayOf<IntArray>(newInterval)
        for (i in 0..intervals.size - 1){
            var resultLast = result.last()
            result = result.copyOfRange(0, result.size-1) 
            result = result.plus(resultLast.merge(intervals[i]))
        }

        return result;
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
        var check = this.canMerge(array)
        if (check == 0) {
            var start = Math.min(first(), array.first())
            var end = Math.max(last(), array.last())
            return arrayOf(intArrayOf(start, end))
        }
        if (check == -1){
            return arrayOf(this,array)
        }
        return arrayOf(array,this)
    }
}
