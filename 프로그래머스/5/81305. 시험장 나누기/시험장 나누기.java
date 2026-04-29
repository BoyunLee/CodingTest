import java.util.*;

class Solution {
    public int solution(int k, int[] num, int[][] links) {
        int answer = 0;
        int left=0;
        int right=0;
        int size=num.length;
        int[] parent = new int[size];
        int[] indegree = new int[size]; 
        Arrays.fill(parent, -1);
        
        for(int i=0;i<size;i++){
            left=Math.max(left,num[i]);
            right+=num[i];
            if(links[i][0]!=-1)
            {
                indegree[i]++;
                parent[links[i][0]]=i;
            }
            if(links[i][1]!=-1)
            {
                indegree[i]++;
                parent[links[i][1]]=i;
            }
        }
        while(left<right){
            int mid=(left+right)/2;
            int count=check(num,links,mid,parent, indegree,size);
            if(count+1<=k){
                right=mid;
            }
            else{
                left=mid+1;
            }
            
        }
        return left;
    }
    int check(int[] num,int[][] links, int mid, int[] parent, int[] indegree, int size){
        int count=0;
        int[] clear=new int[size];
        int[] copy=Arrays.copyOf(num,size);
        Queue<Integer> q=new ArrayDeque<>();
        PriorityQueue<Integer>[] pq=new PriorityQueue[size];
        
        for(int i=0;i<size;i++){
            pq[i]=new PriorityQueue<>(Collections.reverseOrder());
            if(indegree[i]==clear[i])
                q.add(i);
        }
        
        while(!q.isEmpty()){
            int temp=q.poll();
            int p=parent[temp];
            if(p==-1)
                continue;
            pq[p].add(copy[temp]);
            clear[p]++;
            if(clear[p]==indegree[p]){
                for(int childsum:pq[p]){
                    copy[p] +=childsum;
                }
                while(!pq[p].isEmpty()&&copy[p]>mid){
                    count++;
                    copy[p]-=pq[p].poll();
                }
                q.add(p);
            }
                
        }
        return count;
    }
}