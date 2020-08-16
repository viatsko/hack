package main

import "fmt"

func main() {
	var h int
	var m int
	var s int
	var d string

	fmt.Scanf("%d:%d:%d%s", &h, &m, &s, &d)

	if d == "PM" && h != 12 {
		h += 12
	}

	if d == "AM" && h == 12 {
		h = 0
	}

	fmt.Printf("%02d:%02d:%02d", h, m, s)
}
