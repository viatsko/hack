package _67_add_binary

func reverse(runes []rune, length int) {
	for i, j := 0, length-1; i < length/2; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
}

func addBinary(a string, b string) string {
	result := make([]rune, 0)

	aChars := []rune(a)
	aLen := len(a)

	bChars := []rune(b)
	bLen := len(b)

	aIdx := aLen - 1
	bIdx := bLen - 1

	leftover := 0

	for aIdx >= 0 || bIdx >= 0 {
		aVal := 0

		if aIdx >= 0 && aChars[aIdx] == '1' {
			aVal = 1
		}

		bVal := 0

		if bIdx >= 0 && bChars[bIdx] == '1' {
			bVal = 1
		}

		sum := aVal + bVal + leftover

		if (sum & 1) == 0 {
			result = append(result, '0')
		} else {
			result = append(result, '1')
		}

		if sum > 1 {
			leftover = sum >> 1
		} else {
			leftover = 0
		}

		aIdx -= 1
		bIdx -= 1
	}

	for leftover > 0 {
		result = append(result, '1')
		leftover -= 1
	}

	reverse(result, len(result))

	return string(result)
}
