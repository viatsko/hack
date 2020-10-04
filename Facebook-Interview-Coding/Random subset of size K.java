Random subset of size K

[See @ Wikipedia] // https://en.wikipedia.org/wiki/Reservoir_sampling#Algorithm_R



public int[] selectKItems(int[] nums, int k){
    Random r = new Random();
    int[] res = new int[k];
    for (int i = 0; i < k; i++)
        res[i] = nums[i];
    for (int i = k; i < nums.length; i++) {
        int j = r.nextInt(i + 1);
        if (j < k)
            res[j] = nums[i]; // 1/i to be replaced, (i - 1) / i remains -> [(i - 1) / i] * [k / (i - 1)] = k / i : in i-th iteration
    }
    return res;
}


It can be shown that when the algorithm has finished executing, each item in S has equal probability (i.e. k/length(S)) of being chosen for the reservoir. 

To see this, consider the following proof by [induction]. 

After the (i-1) th round, let us assume, the probability of a number being in the reservoir array is k/(i-1). 
Since the probability of the number being replaced in the ith round is 1/i, the probability that it survives the ith round is (i-1)/i. 
Thus, the probability that a given number is in the reservoir after the ith round is the product of these two probabilities, 
i.e. the probability of being in the reservoir after the (i-1)th round, and surviving replacement in the ith round. 
This is (k/(i-1)) * ((i-1)/i)=k/i. Hence, the result holds for i, and is therefore true by induction.
k/i,(i+1-k)/ (i+1)

