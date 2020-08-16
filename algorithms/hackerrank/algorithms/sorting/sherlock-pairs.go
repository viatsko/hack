package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var t int

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &t)

	for i := 0; i < t; i++ {
		var n, cnt int
		var a []int = make([]int, 1000001)

		fmt.Fscan(in, &n)

		for j := 0; j < n; j++ {
			var tmp int

			fmt.Fscan(in, &tmp)

			a[tmp] += 1
		}

		for j := 0; j <= 1000000; j++ {
			if a[j] >= 2 {
				cnt += a[j] * (a[j] - 1)
			}
		}

		fmt.Println(cnt)
	}
}
