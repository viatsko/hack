//
//  RomanToInteger.swift
//  LeetCode
//
//  Created by Valerii Iatsko on 10/7/20.
//

import Foundation

class Solution {
    func romanToInt(_ s: String) -> Int {
        let dict: [Character: Int] = [
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        ]

        var result = 0
        var prev = -1

        for ch in s.reversed() {
            if let curr = dict[ch] {
                if (curr >= prev) {
                    result += curr
                } else {
                    result -= curr
                }

                prev = curr
            }
        }

        return result
    }
}
