package main

import "fmt"

func abs(x int) int {
	if (x < 0) {
		return -x
	}

	return x
}

func main() {
	var k int
	var t int

	var firstDiagSum int = 0
	var secondDiagSum int = 0

	fmt.Scan(&k)

	var aidx int = 0
	var bidx int = k - 1

	for i := 0; i < k; i++ {
		for j := 0; j < k; j++ {
			fmt.Scan(&t)

			if j == aidx {
				fmt.Println(t)
				firstDiagSum += t
			}

			if j == bidx {
				fmt.Println(t)
				secondDiagSum += t
			}
		}

		aidx += 1
		bidx -= 1
	}

	fmt.Print(abs(firstDiagSum - secondDiagSum))
}
