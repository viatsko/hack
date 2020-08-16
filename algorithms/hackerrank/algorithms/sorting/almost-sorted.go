package main

import (
	"fmt"
	"bufio"
	"os"
	"sort"
)

var a []int
var b []int

func reverse(ll int, rr int) {
	for ll < rr {
		var temp int = a[ll]
		a[ll] = a[rr]
		a[rr] = temp
		ll++
		rr--
	}
}

func main() {
	var n, d int

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &n)

	a = make([]int, n)
	b = make([]int, n)

	for i := 0; i < n; i++ {
		fmt.Fscan(in, &d)

		a[i] = d
		b[i] = d
	}

	sort.Ints(b)

	var canSwap bool = true
	var p1 int = -1
	var p2 int = -1
	for i := 0; i < n; i++ {
		if a[i] == b[i] {
			continue
		}

		if p1 == -1 {
			p1 = i
			continue
		}

		if p2 == -1 {
			p2 = i
			continue
		}

		canSwap = false
		break
	}

	if p1 == -1 {
		fmt.Println("yes")

		return
	}

	if canSwap && p1 != -1 && p2 != -1 && b[p1] == a[p2] && b[p2] == a[p1] {
		fmt.Println("yes")
		fmt.Printf("swap %d %d\n", p1 + 1, p2 + 1)
		return
	}

	var reversed bool = false
	var canReverse bool = true
	var i int = 0

	for i < n - 1 {
		if a[i] < a[i + 1] {
			i++
			continue
		}

		if reversed {
			canReverse = false
			break
		}

		var j int = i

		for j < n - 1 && a[j] > a[j + 1] {
			j++
		}

		p1 = i
		p2 = j

		reverse(i, j)

		reversed = true
	}

	if canReverse && (p2 - p1 > 1) {
		fmt.Println("yes")
		fmt.Printf("reverse %d %d\n", p1 + 1, p2 + 1)
	} else {
		fmt.Print("no")
	}
}
