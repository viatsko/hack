//
//  IntegerToRoman.swift
//  LeetCode
//
//  Created by Valerii Iatsko on 10/7/20.
//

import Foundation

/*
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 */

class IntegerToRoman {
    func intToRoman(_ num: Int) -> String {
        let dict: KeyValuePairs = [
            1000: "M",
            900: "CM",
            500: "D",
            400: "CD",
            100: "C",
            90: "XC",
            50: "L",
            40: "XL",
            10: "X",
            9: "IX",
            5: "V",
            4: "IV",
            1: "I"
        ]

        var result = ""

        var n = num
        for (val, letters) in dict {
            while n >= val {
                n -= val
                result += letters
            }
        }

        return result
    }
}
