---
layout: post
title:  "Binary Search: First And Last Occurences of Element In An Array"
date:   2019-08-26 09:00:18 +0200
categories: interviews
---

Binary search is one of the most important CS fundamental algorithms used to efficiently improve your programm runtimes.

It's strong when we work with sorted contiguous data structures such as e. g. array or list.

Here, I want to explain two common tasks where we can apply binary search and how to implement those.

For the sake of simplicity, I'll be writting binary search in recursive manner, but everything can be rewritten in iterative manner too.

# Finding first occurrence of element in an array

Reference array:

```
[5,7,7,8,8,10]
```

For each of binary search implementations we need to answer three questions:
* What does it mean that we find the needed element?
* When we need to move binary search window to the left?
* When we need to move binary search window to the right?

For this problem the answers are:
* If we are at element we are searching, meaning arr[mid] == x and we are either at position 0 (mid = 0) or previous element is less than target (arr[mid - 1] < x)
* If arr[mid] is greater than target or previous condition was not satisfied (because even if arr[mid] == x we still need to move left to find the first occurrence)
* Otherwise just move right

{% highlight java %}
public int findFirst(int arr[], int low, int high, int x) {
    if (high >= low) {
        int mid = (high - low) / 2 + low;

        // If we are at element we are searching, meaning arr[mid] == x and we are either at position 0 (mid = 0) or previous element is less than target (arr[mid - 1] < x)
        if (
            (arr[mid] == x) &&
            (mid == 0 || arr[mid - 1] < x)
        ) {
            return mid;
        // If arr[mid] is greater than target or previous condition was not satisfied (because even if arr[mid] == x we still need to move left to find the first occurrence)
        } else if (arr[mid] >= x) {
            return findFirst(arr, low, (mid - 1), x);
        // Otherwise just move right
        } else {
            return findFirst(arr, (mid + 1), high, x);
        }
    }

    return -1;
}
{% endhighlight %}

# Finding last occurence of element in in array

Reference array:

```
[5,7,7,8,8,10]
```

Yet again, three questions:
* What does it mean that we find the needed element?
* When we need to move binary search window to the left?
* When we need to move binary search window to the right?

For this problem the answers are:
* If we are at element we are searching, meaning arr[mid] == x and we are either at last position (mid = arr.length - 1) or next element is greater than target (arr[mid + 1] > x)
* If arr[mid] is greater than target
* Otherwise just move right

{% highlight java %}
public int findLast(int arr[], int low, int high, int x) {
    if (high >= low) {
        int mid = (high - low) / 2 + low;

        // If we are at element we are searching, meaning arr[mid] == x and we are either at last position (mid = arr.length - 1) or next element is greater than target (arr[mid + 1] > x)
        if (
            (arr[mid] == x) &&
            (mid == arr.length - 1 || arr[mid + 1] > x)
        ) {
            return mid;
        //  If arr[mid] is less than target
        } else if (arr[mid] > x) {
            return findLast(arr, low, (mid - 1), x);
        } else {
            return findLast(arr, (mid + 1), high, x);
        }
    }

    return -1;
}
{% endhighlight %}

You can practice both algorithms right now here:

* [LeetCode 34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
