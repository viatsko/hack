//
//  LongestSubstringWithoutRepeatingCharacters.swift
//  LeetCode
//
//  Created by Valerii Iatsko on 10/7/20.
//

import Foundation

class LongestSubstringWithoutRepeatingCharacters {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        guard s.count > 0 else { return 0 }

        let sArr = Array(s)

        var lastIndexes: [Character: Int] = [:]

        var result = Int.min

        var windowStart = 0
        for windowEnd in 0..<sArr.count {
            let rightCharacter = sArr[windowEnd]

            if let seenIndex = lastIndexes[rightCharacter] {
                while windowStart <= seenIndex {
                    let leftCharacter = sArr[windowStart]
                    lastIndexes[leftCharacter] = nil
                    windowStart += 1
                }
            }

            lastIndexes[rightCharacter] = windowEnd

            result = max(result, windowEnd - windowStart + 1)
        }

        return result
    }
}

