package main

import (
	"bufio"
	"os"
	"fmt"
)

func main() {
	in := bufio.NewReader(os.Stdin)

	var t int
	var m int
	var n int

	var a []int

	fmt.Fscan(in, &t)

	for i := 0; i < t; i++ {
		var b map[int]int = make(map[int]int)

		fmt.Fscan(in, &m)

		fmt.Fscan(in, &n)

		a = make([]int, n)

		for j := 0; j < n; j++ {
			fmt.Fscan(in, &a[j])

			b[a[j]] = j
		}

		for j := 0; j < n; j++ {
			if val, ok := b[m - a[j]]; ok {
				if j != val {
					fmt.Printf("%d %d\n", j + 1, val + 1)
					break
				}
			}
		}
	}
}
