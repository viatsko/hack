package main

import "fmt"

func main() {
	var t int
	var n int

	fmt.Scan(&t)

	for i := 0; i < t; i++ {
		fmt.Scan(&n)

		var nc int = n
		var c int = 0

		for nc != 0 {
			var d int = nc % 10

			if d != 0 && n % d == 0 {
				c += 1
			}

			nc = nc / 10
		}

		fmt.Println(c)
	}
}
