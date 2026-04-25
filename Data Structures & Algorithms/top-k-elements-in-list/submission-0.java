class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        for(int i =0;i<nums.length;i++){
            int num = nums[i];
            int freq = freqs.getOrDefault(num, 0);
            freqs.put(num, freq+1);
        }

        PriorityQueue<F> maxHeap = new PriorityQueue<F>((a, b)->Integer.compare(b.freq, a.freq));
        for(Map.Entry<Integer, Integer> entry:freqs.entrySet()){
            maxHeap.add(new F(entry.getKey(), entry.getValue()));
        }

        int i =0;
        int[] result = new int[k];
        while(i<k){
            result[i]=maxHeap.poll().num;
            i++;
        }

        return result;
    }

    class F
    {
        public F(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        int num;
        int freq;
    }
}
