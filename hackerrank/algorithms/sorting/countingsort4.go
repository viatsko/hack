package main

import (
	"fmt"
	"bytes"
	"bufio"
	"os"
)

func main() {
	var n int
	var x int
	var s string

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &n)

	arr := [100]bytes.Buffer{}

	half := n / 2

	for i := 0; i < n; i++ {
		fmt.Fscan(in, &x)
		fmt.Fscan(in, &s)

		if i >= half {
			arr[x].WriteString(s + " ")
		} else {
			arr[x].WriteString("- ")
		}
	}

	var res bytes.Buffer
	for i := 0; i < 100; i++ {
		if arr[i].Len() > 0 {
			res.Write(arr[i].Bytes())
		}
	}

	fmt.Println(res.String())
}
