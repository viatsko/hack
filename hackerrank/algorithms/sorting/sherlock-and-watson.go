package main

import (
	"fmt"
	"bufio"
	"os"
)

func main() {
	var n, k, q int
	var a []int

	in := bufio.NewReader(os.Stdin)

	fmt.Fscanf(in, "%d %d %d", &n, &k, &q)

	a = make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(in, &a[i])
	}

	if k >= n {
		k = k % n
	}

	for i := 0; i < q; i++ {
		var query int

		fmt.Fscan(in, &query)

		fmt.Println(a[(n - k + query) % n])
	}
}
