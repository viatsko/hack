//
//  TwoSum.swift
//  LeetCode
//
//  Created by Valerii Iatsko on 10/7/20.
//

import Foundation

class TwoSum {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict: [Int: Int] = [:]

        for i in 0..<nums.count {
            if let seenIndex = dict[target - nums[i]] {
                return [seenIndex, i]
            }

            dict[nums[i]] = i
        }

        return [-1, -1]
    }
}
