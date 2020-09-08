class CombinationIterator {
  private characters: string;
  private combinationLength: number;
  private mask: number;

  constructor(characters: string, combinationLength: number) {
    this.characters = characters;
    this.combinationLength = combinationLength;
    this.mask =
      (1 << characters.length) - (1 << (characters.length - combinationLength));
  }

  next(): string {
    const result = [];
    for (let i = 0; i < this.characters.length; i++) {
      if (this.mask & (1 << (this.characters.length - i - 1))) {
        result.push(this.characters[i]);
      }
      if (result.length === this.combinationLength) {
        break;
      }
    }

    this.mask--;
    while (
      this.mask > 0 &&
      this.bitCount(this.mask) !== this.combinationLength
    ) {
      this.mask--;
    }

    return result.join("");
  }

  hasNext(): boolean {
    return this.mask > 0;
  }

  private bitCount(n: number): number {
    return n.toString(2).match(/1/g)?.length || 0;
  }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = new CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
