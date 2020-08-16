package main

import (
	"bufio"
	"fmt"
	"os"
)

type Direction struct {
	x int
	y int
}

var dirs []Direction = []Direction{
	Direction{x: 0, y: 1},
	Direction{x: 0, y: -1},
	Direction{x: 1, y: 0},
	Direction{x: -1, y: 0}}

func isInsideMatrix(x int, y int, n int, m int) bool {
	return x >= 0 && y >= 0 && x < n && y < m
}

var current int

func dfs(a *[][]rune, m int, n int, x int, y int, px int, py int) bool {
	if (*a)[x][y] == '*' {
		return true
	}

	var cc int = 0

	var flag bool = false

	for i := 0; i < 4; i++ {
		var nx int = x + dirs[i].x
		var ny int = y + dirs[i].y

		if (!isInsideMatrix(nx, ny, n, m)) || (nx == px && ny == py) || ((*a)[nx][ny] == 'X') {
			continue
		}

		if dfs(a, m, n, nx, ny, x, y) {
			flag = true
		}

		cc++
	}

	if flag && cc > 1 {
		current++
	}

	return flag
}

func main() {
	var t, n, m, g int
	var mx, my int
	var a [][]rune

	in := bufio.NewReader(os.Stdin)

	fmt.Fscan(in, &t)

	for ii := 0; ii < t; ii++ {
		fmt.Fscan(in, &n)

		fmt.Fscan(in, &m)

		for i := 0; i < n; i++ {
			var s string

			fmt.Fscan(in, &s)

			var row []rune = []rune(s)

			for j := 0; j < m; j++ {
				if row[j] == 'M' {
					mx, my = i, j
				}
			}

			a = append(a, row)
		}

		fmt.Fscan(in, &g)

		current = 0

		dfs(&a, m, n, mx, my, -1, -1)

		if current == g {
			fmt.Println("Impressed")
		} else {
			fmt.Println("Oops!")
		}

		a = nil
	}
}
