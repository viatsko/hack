package main
import "fmt"

func main() {
	var k int
	var t uint64
	var summ uint64 = 0

	fmt.Scan(&k)

	for i := 0; i < k; i++ {
		fmt.Scan(&t)
		summ += t
	}

	fmt.Print(summ)
}
