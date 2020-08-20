package main

import (
	"fmt"
	"bufio"
	"os"
)

func merge(a *[]int, start int, end int) int {
	if end - start <= 1 {
		return 0
	}

	if end - start == 2 {
		if (*a)[start] > (*a)[start + 1] {
			var tmp int = (*a)[start]
			(*a)[start] = (*a)[start + 1]
			(*a)[start + 1] = tmp
			return 1
		}

		return 0
	}

	var mid int = start + (end - start) / 2
	var count int = merge(a, start, mid) + merge(a, mid, end)

	var a1 []int = make([]int, mid - start)
	copy(a1[:], (*a)[start:mid])
	var index int = start
	var i, j int = 0, mid

	for i < len(a1) && j < end {
		if a1[i] <= (*a)[j] {
			(*a)[index] = a1[i]
			i++
		} else if a1[i] > (*a)[j] {
			(*a)[index] = (*a)[j]
			count += mid - start - i
			j += 1
		}

		index += 1
	}

	for i < len(a1) {
		(*a)[index] = a1[i]
		index += 1
		i += 1
	}

	for j < end {
		(*a)[index] = (*a)[j]
		index += 1
		j += 1
	}

	return count
}

func main() {
	in := bufio.NewReader(os.Stdin)

	var t int

	fmt.Fscan(in, &t)

	for j := 0; j < t; j++ {
		var n int

		fmt.Fscan(in, &n)

		var a []int = make([]int, n)

		for i := 0; i < n; i++ {
			fmt.Fscan(in, &a[i])
		}

		fmt.Println(merge(&a, 0, n))
	}
}
