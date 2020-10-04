Dot Product & Variations

1.Basic Dot Product
// assume a, b have same length
public int dotProduct(int[] a, int[] b){
	int res = 0;
	for (int i = 0; i < a.length; i++)
		res += a[i] * b[i];
	return res;
}


2.Dot product of sparse vector
You have 2 sparse vectors (large number of 0’s). First tell me a way to represent and store them, and then find the dot product.
面试官先问每个vector很大，不能在内存中存下怎么办，我说只需存下非零元素和他们的下标就行，然后问面试官是否可用预处理后的
这两个vector非零元素的index和value作为输入，面试官同意后写完O(M*N)的代码(输入未排序，只能一个个找)，MN分别是两个vector长度。

又问这两个输入如果是根据下标排序好的怎么办，是否可以同时利用两个输入都是排序好这一个特性，最后写出了O(M + N)的双指针方法，
每次移动pair里index0较小的指针，如果相等则进行计算，再移动两个指针。

class Node {
	int idx, val;
	public Node(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}
// O(m + n) - like merge sort
public int SparseVectorProduct(int[] a, int[] b){
	List<Node> l1 = new ArrayList<>();
	List<Node> l2 = new ArrayList<>();
	for (int i = 0; i < a.length; i++)
		if (a[i] != 0)		l1.add(new Node(i, a[i]));
	for (int i = 0; i < b.length; i++)
		if (b[i] != 0)		l2.add(new Node(i, b[i]));
	int res = 0, i = 0, j = 0;
	while (i < l1.size() && j < l2.size()) {
		if (l1.get(i).idx < l2.get(j).idx) 		i++;
		else if (l1.get(i).idx > l2.get(j).idx)		j++;
		else	res += l1.get(i++).val * l2.get(j++).val;
	}
	return res;
}



3.long & short vector
如果一个 vector 比另一个大很多怎么办，答对于小的 vector 里 每一个(index， value)，在大的里 binary search。然后问了复杂度。

Time: O(n*logm) 

又问如果两个数组一样长，且一会sparse一会dense怎么办。他说你可以在two pointer的扫描中内置一个切换二分搜索的机制。
看差值我说过，设计个反馈我说过，他说不好。他期待的解答是，two pointers找到下个位置需要m次比较，而直接二分搜需要log(n)次比较。
那么在你用two pointers方法移动log(n)次以后，就可以果断切换成二分搜索模式了。


// Binary search如果找到了一个元素index，那就用这次的index作为下次binary search的开始。可以节约掉之前的东西，不用search了。
// 然后问，如果找不到呢，如何优化。说如果找不到，也返回上次search结束的index，然后下次接着search。
// 就是上一次找到了，就用这个index继续找这次的；如果找不到，也有一个ending index，就用那个index当starting index。
// 比如[1, 89，100]，去找90；如果不存在，那么binary search的ending index应该是89，所以下次就从那个index开始。
// 如果找不到，会返回要插入的位置index + 1，index是要插入的位置，我写的就是返回要插入的index的。
// 但是不管返回89还是100的index都无所谓，反正只差一个，对performance没有明显影响的。
public int sparseVectorProduct(int[] a,int[] b){
	List<Node> l1 = new ArrayList<>();
	List<Node> l2 = new ArrayList<>();
	for (int i = 0; i < a.length; i++
		if (a[i] != 0)		l1.add(new Node(i, a[i]));
	for (int i = 0; i < b.length; i++
		if (b[i] != 0)		l1.add(new Node(i, b[i]));
	if (l1.size() > l2.size()) {
		List<Node> tmp = l1;
		l1 = l2;
		l2 = tmp;
	}
	// [20, 98] [0,1,2,3,..,19,21,..,100]
	// [0,48]->[0,23]->[11,23]->[17,23]->[20,23]->[20,20]
	int i = 0, j = l2.size() - 1, res = 0;
	for (Node n1 : l1) {
		j = l2.size() - 1;
    	while (i <= j) {
        	int mid = i + (j - i) / 2;
       		if (l2.get(mid).idx == n1.idx) 	res += n1.val * l2.get(mid).val;
        	else if (l2.get(mid).idx < n1.idx) 	i = mid + 1;
        	else 	j = mid - 1;
    	}
    }
	return res;
}

// 楼主:暴力双循环，skip 0.
// 面试官:不急着写，你想想有什么好办法存vector？
// 琢磨了好久，说要不我们用hashmap存value和index
// 面试官继续追问，hashmap会有空的空间，我们有memory限制，你怎么办
// 楼主:那用arraylist存pair？
// 面试官：这个还差不多，那你打算怎么求解？
// 楼主：排序，two pointer？
// 面试官：好，你写吧。写完后追问了时间复杂度





