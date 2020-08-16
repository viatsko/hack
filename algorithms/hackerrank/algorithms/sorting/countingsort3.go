package main

import "fmt"

func main() {
	var n int

	fmt.Scan(&n)

	var arr []int = make([]int, 100)

	for i := 0; i < n; i++ {
		var x int
		var s string

		fmt.Scanf("%d %s", &x, &s)

		arr[x] += 1
	}

	var oldAns int = 0

	for i := 0; i < 100; i++ {
		oldAns += arr[i]

		fmt.Printf("%d ", oldAns)
	}
}
