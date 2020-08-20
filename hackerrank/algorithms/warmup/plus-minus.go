package main

import "fmt"

func main() {
	var k int
	var t int

	var positive float32 = 0
	var negative float32 = 0
	var zeros float32 = 0

	fmt.Scan(&k)

	for i := 0; i < k; i++ {
		fmt.Scan(&t)

		if t == 0 {
			zeros += 1
		} else if t > 0 {
			positive += 1
		} else if t < 0 {
			negative += 1
		}
	}

	fmt.Printf("%.06f\n%.06f\n%.06f", positive / float32(k), negative / float32(k), zeros / float32(k))
}
