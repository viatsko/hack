package main

import (
	"fmt"
	"bufio"
	"os"
	"sort"
	"math"
)

type DiffNumbers struct {
	a int
	b int
}

func main() {
	var n int

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &n)

	var arr []int = make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(in, &arr[i])
	}

	sort.Ints(arr)

	var minDiff int = math.MaxInt32
	var a, b, diff int
	var diffNumbers []DiffNumbers

	for i := 0; i < n - 1; i++ {
		a = arr[i]

		b = arr[i + 1]

		diff = a - b

		if diff < 0 {
			diff = -diff
		}

		if diff < minDiff {
			minDiff = diff

			diffNumbers = nil

			diffNumbers = append(diffNumbers, DiffNumbers{a: a, b: b})
		} else if diff == minDiff {
			diffNumbers = append(diffNumbers, DiffNumbers{a: a, b: b})
		}
	}

	for _, diffPair := range diffNumbers {
		fmt.Printf("%d %d ", diffPair.a, diffPair.b)
	}
}
