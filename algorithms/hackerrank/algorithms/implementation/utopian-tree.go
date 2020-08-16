package main

import "fmt"

func main() {
	var t int
	var n int

	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		fmt.Scan(&n)

		var i int = 1

		for j := 0; j < n; j++ {
			if j % 2 == 0 {
				i *= 2
			} else {
				i += 1
			}
		}

		fmt.Println(i)
	}
}
