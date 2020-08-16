package main

import "fmt"

func main() {
	var n int
	var k int
	var count int = 0
	var pagenum int = 1

	fmt.Scan(&n)
	fmt.Scan(&k)

	for i := 0; i < n; i++ {
		var t int

		fmt.Scan(&t)

		var flag int = 0
		var problemnum int = 1

		for j, l := 0, 1; j < t; j, l = j + 1, l + 1 {
			if problemnum == pagenum {
				count++

				//fmt.Println(count)
			}

			problemnum++

			if l == k {
				l = 0

				pagenum++

				if j == t - 1 {
					flag = 1
				}
			}
		}

		if flag == 0 {
			pagenum++
		}
	}

	fmt.Println(count)
}
