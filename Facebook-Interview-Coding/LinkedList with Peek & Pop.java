LinkedList with Peek & Pop
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=158720&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3090%255D%255Bvalue%255D%3D2%26searchoption%255B3046%255D%255Bvalue%255D%3D2%26searchoption%255B3046%255D%255Btype%255D%3Dradio%25252%2B6sortid%253D311%26searchop_tion%255B3090%255D%255Btype%255D%3Dradio&page=1

给一个linkedlist，里面的element都排序好了，但是是一个blackbox，有三个function可以调用。
pop()随机pop出最前面或最后面的element，peek()随机偷看最前面或最后面的element，isEmpty()回传linkedlist是不是空了。
问设计一个资料结构，list或是array都可以，把linkedlist里面所有的element都拿出来，并保持他们的排序。followup是如果不能用peek()该怎么做。

两个链表 small 和  large 
所有pop出来的点 都先接到small的末尾上 如果再pop出来的点比small末尾的那个值要小 就把small末尾的这个点接到large后面 再把这个pop出来的接到small后面
比如 1->5->7->9->11
不管先pop出来1 或者11 都先接到small的后面 假设这里pop出来11 就是small->11 
然后再pop出来的点就和这个末尾比较 如果这里pop出来的是9 那么就把11放到上面 Large->11 small->9 
然后如果pop出来1 那么就变成 Large->11->9 small->1
然后如果pop出来7 Large->11->9 small->1->7
然后如果pop出来5 Large->11->9->7 smal->1->5
这样应该就能保证顺序不乱 最后把两个链表拼起来就行了

// class PeekPopLinkedList {

// }

// public LinkedList peekPop() {
// 	PeekPopLinkedList small = null, large = null;
// 	while (!isEmpty()) {
// 		PeekPopLinkedList tmp = pop();
// 		if (tmp.val < small)
// 	}
// }


