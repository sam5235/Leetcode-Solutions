// { Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}


// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i = n/2 -1; i >= 0; i--){
            heapify(arr, n,i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int root = i;
        int left = getLeft(i);
        int right = getRight(i);
        if(arr[left] > arr[root] && left < n){
          root = left;  
         }
         if(arr[right] > arr[root] && right < n){
             root = right;
         }
         if(root != i){
             int temp = arr[i];
             arr[i] = arr[root];
             arr[root] = temp;
             heapify(arr, n, root);
         }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        for(int i = n-1; i >= 0; i--){
            int temp = arr[i];
            arr [i] = arr [0];
            arr [0] = temp;
            heapify(arr, i, 0);
        }
        
    }
    private int getLeft(int i){
        return (2 * i) +1;
    }
     private int getRight(int i){
        return (2 * i) +2;
    }
 }
 
 