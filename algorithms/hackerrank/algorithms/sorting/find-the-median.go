package main

import (
	"fmt"
	"bufio"
	"os"
	"sort"
)

func main() {
	var n int

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &n)

	var a []int = make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(in, &a[i])
	}

	sort.Ints(a)

	fmt.Print(a[n / 2])
}
