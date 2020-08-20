package main

import (
	"fmt"
	"bufio"
	"os"
)

func main() {
	var t, n int
	var a []int

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &t)

	for i := 0; i < t; i++ {
		fmt.Fscan(in, &n)

		a = make([]int, n)

		var right, left int

		for j := 0; j < n; j++ {
			fmt.Fscan(in, &a[j])

			right += a[j]
		}

		if n == 1 {
			fmt.Println("YES")
		} else {
			var isSolved bool = false

			for k := 0; k < n - 1; k++ {
				if k > 0 {
					left += a[k - 1]
				}

				right -= a[k]

				if left == right {
					fmt.Println("YES")
					isSolved = true
					break
				}
			}

			if !isSolved {
				fmt.Println("NO")
			}
		}
	}
}
