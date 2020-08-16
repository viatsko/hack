package main

import "fmt"

func calculate(x int) {
	var m = x

	for m % 3 != 0 {
		m -= 5

		if m < 0 {
			fmt.Println("-1")
			return
		}
	}

	for j := 0; j < m; j++ {
		fmt.Print("5")
	}

	for j := 0; j < (x - m); j++ {
		fmt.Print("3")
	}

	fmt.Println("")
}

func main() {
	var k int

	fmt.Scan(&k)

	for i := 0; i < k; i++ {
		var t int

		fmt.Scan(&t)

		calculate(t)
	}
}
