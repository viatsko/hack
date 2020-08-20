package main

import (
	"fmt"
	"bufio"
	"os"
)

func maxInt(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

type Direction struct {
	x int
	y int
}

var max, current int
var dirs []Direction = []Direction{
	Direction{x: 0, y: 1},
	Direction{x: 0, y: -1},
	Direction{x: 1, y: 0},
	Direction{x: -1, y: 0},
	Direction{x: 1, y: 1},
	Direction{x: 1, y: -1},
	Direction{x: -1, y: 1},
	Direction{x: -1, y: -1}}

func dfs(visited *[][]bool, a *[][]int, i int, j int, m int, n int) {
	(*visited)[i][j] = true
	current += 1
	max = maxInt(max, current)

	for _, dir := range dirs {
		i1 := i + dir.x
		j1 := j + dir.y

		if 0 <= i1 && i1 < m && 0 <= j1 && j1 < n && !(*visited)[i1][j1] && (*a)[i1][j1] == 1 {
			dfs(visited, a, i1, j1, m, n)
		}
	}
}

func main() {
	var m, n int

	in := bufio.NewReader(os.Stdin)

	var a [][]int

	fmt.Fscan(in, &m)

	fmt.Fscan(in, &n)

	for i := 0; i < m; i++ {
		var row []int

		for j := 0; j < n; j++ {
			var tmp int

			fmt.Fscan(in, &tmp)

			row = append(row, tmp)
		}

		a = append(a, row)
	}

	var visited [][]bool

	for i := 0; i < m; i++ {
		var row []bool

		for j := 0; j < n; j++ {
			row = append(row, false)
		}

		visited = append(visited, row)
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] && a[i][j] == 1 {
				current = 0
				dfs(&visited, &a, i, j, m, n)
			}
		}
	}

	fmt.Println(max)
}
