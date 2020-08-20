class NumberOfSegmentsInAString {
    fun countSegments(s: String): Int {
        return (0 until s.length).count { s[it] != ' ' && (it == 0 || s[it - 1] == ' ') }
    }
}
