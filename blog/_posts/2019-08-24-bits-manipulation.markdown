---
layout: post
title:  "Bits Manipulation"
date:   2019-08-24 09:00:18 +0200
categories: interviews
---

Bits Manipulation is a topic rarely seen in programming interviews, but superuseful for any programmer. The most seen usecase of bit manipulation is probably masks when you are optimizing a storage for a pre-known set of flags.

Basic bit operations are `& (AND), | (OR), ^ (XOR), ~ (NOT), left and right shifts <<, >>, <<<, >>> (two last ones are meant for unsigned numbers)`

Here's how they all work:

### AND

```
AND - only keeps matching bits from two numbers

00011100
AND
00001110
=
00001100
```

### OR

```
OR - sets bit '1' if there's '1' at the same position in both numbers

00011100
OR
00001110
=
00011110
```

### XOR

```
XOR - sets bit '1' if bits are different in two numbers

00011100
XOR
00001110
=
00010010
```

In an attempt of making XOR even clearer, here's the table:

|A|B|^ (XOR)|
|0|0|0|
|0|1|1|
|1|0|1|
|1|1|0|

## Basic tricks

### A ^ A = 0

If you'll do XOR operation on a number itself, the result is 0.

This is cool as it allows us to solve problems like finding a non-repeating number in a sequence where each number repeats even number of times in a really nice way.

E. g. imagine you have an array of [3, 3, 2, 2, 1, 5, 3, 5, 3] and you need to find that single number. All you have to do is basically XOR everything through `for (int i = 0; i < nums.length; i++) { result ^= nums[i]; }`.

You can try it yourself here:

* [LeetCode: Single Number](https://leetcode.com/problems/single-number/)

Simple illustration to how it works:

```
result = 0
^ 3 result = 000 ^ 011 = 011
^ 3 result = 011 ^ 011 = 000
^ 2 result = 000 ^ 010 = 010
^ 2 result = 010 ^ 010 = 000
^ 1 result = 000 ^ 001 = 001
^ 5 result = 001 ^ 101 = 100
^ 3 result = 100 ^ 011 = 111
^ 5 result = 111 ^ 101 = 010
^ 3 result = 010 ^ 011 = 001
```

### A & 1 to check if number is odd or even (alternative to A % 2)

A & 1 basically gets last bit of a number and we know that if it's 1 then number is odd, if it's 0 it's even, e. g.:

```
2 & 1 = 10 & 1 = 0 (even)
3 & 1 = 11 & 1 = 1 (odd)
101 & 1 = 1100101 & 1 = 1 (odd)
```

### A >> 1 to divide number by two (alternative to Math.floor(A / 2))

Right shift operator is handy in removing one last bit from a number

```
2 >> 1 = 10 >> 1 = 1
101 >> 1 = 1100101 >> 1 = 110010 = 50 =)
```

Make your fellow colleagues excited (please no) writing:

{% highlight java %}
for (int i = 0; i < N >> 1 /* hope it's clear!!!111 */; i++) {}
{% endhighlight %}

Similar to this, `A << 1` can be used to multiply number by 2.

### Bitmasks operations

To set a bit at a position:

{% highlight java %}
bitmask |= (1 << position)
{% endhighlight %}

To remove a bit at a position:

{% highlight java %}
bitmask &= ~(1 << position)
{% endhighlight %}

To check the flag in a bitmask:

{% highlight java %}
bitmask & (1 << position)
{% endhighlight %}

To make it even more clear (or more confusing):

{% highlight java %}
final int FEATURE_A = 0x1; (or 1)
final int FEATURE_B = 0x2; (or 1 << 1)
final int FEATURE_C = 0x4; (or 1 << 2)
final int FEATURE_D = 0x8; (or 1 << 3)

if (currentUser.isAdmin) {
    currentUser.features |= (FEATURE_A|FEATURE_B);
}
{% endhighlight %}

Why would you use bitmasks during your day-to-day coding? Simple answer - bitmask is just 1 integer (so just 8 to 64 bits [usually]).

### Counting '1's in a number

The trick here is to use `>>` and `&` operators - we'll just be checking last bit of a number and removing it, see e. g.:

```
result = 0

a = 1111 (15)

a & 1 = 1, result += 1
a = a >> 1 = 111

a & 1 = 1, result += 1
a = a >> 1 = 11

a & 1 = 1, result += 1
a = a >> 1 = 1

a & 1 = 1, result += 1
a = a >> 1 = 0

We've got 4 as a result now!
```

There's a faster (on average) alternative though. You can just substract -1 from a number and it will turn last binary '1' into '0'. We can count how many times we dropped 1 from a number and that will be the answer too, e. g.:

{% highlight java %}
int result = 0;
while (a != 0) {
    a &= (a - 1);
    result++;
}
{% endhighlight %}

This algorithm is faster as it's runtime complexity is based on a number of '1's in a number, while the first one is based on number of bits in a number, so O(bits) vs O(ones).

Use `a = a & (a - 1)` to remove the last '1' bit of integer.

Also, in some problems it's asked to do something with the right-most '1' bit of integer, we can get it separately using `a & ~(a - 1)`

## Advanced tricks

### Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

This is a trick which one might apply to this problem:
* [LeetCode: Single Number II](https://leetcode.com/problems/single-number-ii/)

{% highlight java %}
/*
    for [3, 3, 3] by steps:
    x = 11 y = 0
    x = 0  y = 11
    x = 0  y = 0
*/
public int singleNumber(int[] nums) {
    int x = 0;
    int y = 0;
    
    for (int i = 0; i < nums.length; i++) {
        x = (x ^ nums[i]) & ~y;
        y = (y ^ nums[i]) & ~x;
    }
    
    return x;
}
{% endhighlight %}

We basically put a number into x container, then move it to y, then move it away completely (see comment for number 3). If you don't understand how it worked, take a piece of paper and draw the bits. (~0 = 11111111 for 32-bit int, btw).

### Parity Checks problem

Imagine a problem where you need to tell if number of 1 bits in number is odd or even (that's usually used in ECC memory).

We can apply the same formula we used for counting 1s, but what if we need to do it with a massively scaled up input (e. g. billions of numbers go through our program).

What we can do here (and I actually learned this trick from [EPI](https://elementsofprogramminginterviews.com/) book) is a lookupTable:

{% highlight java %}
public class CalculateParityLookup {
    private final static int BITMASK = 0xFFFF; // we need it to only keep last 16 bits of a number, it looks like 0b111111111111111
                                               // consider it working like a substring on a string where you only get last 16 characters

    /* for lookup table we use 16 bit key, which means ~ 65536 entries */
    private static int[] lookupTable = new int[BITMASK];
    private static void prefillLookupTable() {
        for (int i = 0; i < BITMASK; i++) {
            int word = i;
            int bits = 0;
            /*
                as we know we need to put a sequence in a table,
                there's much more efficient algorithm to this exists,
                consider this chunk as an illustration
             */
            while (word != 0) {
                word = word & (word - 1);
                bits++;
            }
            lookupTable[i] = bits & 1;
        }
    }

    private static short calculateParity(long word) {
        final int WORD_SIZE = 16;

        /* we split long (64 bit) integer into 16 bit chunks and lookup for a chunk in a lookup table */
        return (short) (
                lookupTable[(int) (word & BITMASK)] ^
                        lookupTable[(int) (word >>> (WORD_SIZE * 3) & BITMASK)] ^
                        lookupTable[(int) (word >>> (WORD_SIZE * 2) & BITMASK)] ^
                        lookupTable[(int) (word >>> (WORD_SIZE) & BITMASK)]
        );
    }
}
{% endhighlight %}

### Swapping bits

We can use XOR to swap two bits. Important thing there is that we need to check if they are different first.

{% highlight java %}
public static long swapBits(long x, int i, int j) {
    if (((x >>> i) & 1) == ((x >>> j) & 1)) {
        return x;
    }

    long bitmask = (1L << i) | (1L << j);

    return x ^ bitmask;
}
{% endhighlight %}

#### Reversing bits

Looks the same way as swap

{% highlight java %}
public static long reverseBits(long x) {
    for (int i = 0; i < 32; i++) {
        int j = 63 - i;

        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            x ^= (1L << i)|(1L << j);
        }
    }

    return x;
}
{% endhighlight %}
