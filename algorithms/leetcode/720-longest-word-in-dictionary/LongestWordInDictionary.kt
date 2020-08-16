class LongestWordInDictionary {
    fun longestWord(words: Array<String>): String {
        words.sort()

        val set = HashSet<String>()

        var result = ""

        for (word in words) {
            if (word.length == 1 || set.contains(word.dropLast(1))) {
                if (word.length > result.length) {
                    result = word
                }

                set.add(word)
            }
        }

        return result
    }
}
