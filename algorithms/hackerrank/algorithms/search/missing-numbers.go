package main

import (
	"fmt"
	"bufio"
	"os"
	"sort"
)

func main() {
	var n, m int
	var a map[int]int = make(map[int]int)
	var ans map[int]int = make(map[int]int)

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &n)

	for i := 0; i < n; i++ {
		var tmp int

		fmt.Fscan(in, &tmp)

		a[tmp] += 1
	}

	fmt.Fscan(in, &m)

	for i := 0; i < m; i++ {
		var tmp int

		fmt.Fscan(in, &tmp)

		a[tmp] -= 1

		if a[tmp] < 0 {
			ans[tmp] = 1
		}
	}

	var keys []int

	for k, _ := range ans {
		keys = append(keys, k)
	}

	sort.Ints(keys)

	for _, k := range keys {
		fmt.Printf("%d ", k)
	}
}
