package main

import "fmt"

func main() {
	var t int

	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		var n int

		fmt.Scan(&n)

		var a[n] int

		for j := 0; j < n; j++ {
			fmt.Scan(&a[j])
		}
	}
}
