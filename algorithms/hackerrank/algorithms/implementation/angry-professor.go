package main

import "fmt"

func main() {
	var k int

	fmt.Scan(&k)

	for i := 0; i < k; i++ {
		var s int
		var a int

		fmt.Scan(&s)
		fmt.Scan(&a)

		var onTime int = 0
		for j := 0; j < s; j++ {
			var t int

			fmt.Scan(&t)

			if t <= 0 {
				onTime += 1
			}
		}

		if onTime >= a {
			fmt.Println("NO")
		} else {
			fmt.Println("YES")
		}
	}
}
