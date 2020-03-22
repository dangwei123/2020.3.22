给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

返回使 A 中的每个值都是唯一的最少操作次数。
class Solution {
    private int[] arr=new int[50000];
    public int minIncrementForUnique(int[] A) {
        Arrays.fill(arr,-1);
        int count=0;
        for(int i:A){
            int tmp=line(i);
            count+=tmp-i;
        }
        return count;
    }
    private int line(int n){
        int m=arr[n];
        if(m==-1){
            arr[n]=n;
            return n;
        }
        m=line(m+1);
        arr[n]=m;
        return m;
    }
}

给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    private Map<Node,Node> visited=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        visited.put(node,new Node(node.val,new ArrayList<>()));
        for(Node cur:node.neighbors){
            visited.get(node).neighbors.add(cloneGraph(cur));
        }
        return visited.get(node);
    }
}

给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
class Solution {
    private int count;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,0,S);
        return count;
    }
    private void dfs(int[] nums,int index,int sum,int target){
         if(index==nums.length&&sum==target){
            count++;
        }
        if(index==nums.length){
            return ;
        }
            sum+=nums[index];
            dfs(nums,index+1,sum,target);
            sum-=nums[index];
            sum-=nums[index];
            dfs(nums,index+1,sum,target);
    }
}

