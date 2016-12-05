String matching: naive
 
public int strStr(String haystack, String needle) {
        int j;
        for(int i=0;i<=haystack.length()-needle.length();i++) {
            for(j=0;j<needle.length();j++){
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
            }
            if(j == needle.length()) return i;
        }
        return -1;
}

Bubble sort
void bubbleSort(int ar[])
{
  for (int i = (ar.length - 1); i >= 0; i--)
  {
      for (int j = 1; j ≤ i; j++)
      {
        if (ar[j-1] > ar[j])
        {
              int temp = ar[j-1];
              ar[j-1] = ar[j];
              ar[j] = temp;
  } } } }

void selectionSort(int[] ar){
  for (int i = 0; i ‹ ar.length-1; i++)
  {
      int min = i;
      for (int j = i+1; j ‹ ar.length; j++)
            if (ar[j] ‹ ar[min]) min = j;
      int temp = ar[i];
      ar[i] = ar[min];
      ar[min] = temp;
} }

void insertionSort(int[] ar)
{
  for (int i=1; i ‹ ar.length; i++)
  {
      int index = ar[i]; int j = i;
      while (j > 0 && ar[j-1] > index)
      {
          ar[j] = ar[j-1];
          j--;
      }
      ar[j] = index;
} }


Merge sort
public class MergeSort {
   private static void merge(int[] array, int low, int mid, int high) {
        int[] helper = new int[array.length];
        // copy array to helper
        for (int k = low; k <= high; k++) {
            helper[k] = array[k];
        }
        // merge array[low...mid] and array[mid + 1...high]
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            // k means current location
            if (i > mid) {
            // no item in left part
                array[k] = helper[j];
                j++;
            } else if (j > high) {
            // no item in right part
                array[k] = helper[i];
                i++;
            } else if (helper[i] > helper[j]) {
            // get smaller item in the right side
                array[k] = helper[j];
                j++;
            } else {
            // get smaller item in the left side
                array[k] = helper[i];
                i++;
            }
        }
    }

    public static void sort(int[] array, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }
}

Quick sort

public class Sort {
    public static void quickSort2(int[] array, int l, int u) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        if (l >= u) return;
        int pivot = array[l];
        int left = l + 1;
        int right = u;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] >= pivot) {
                right--;
            }
            if (left > right) break;
            // swap array[left] with array[right] while left <= right
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        /* swap the smaller with pivot */
        int temp = array[right];
        array[right] = array[l];
        array[l] = temp;

        quickSort2(array, l, right - 1);
        quickSort2(array, right + 1, u);
    }

    public static void quickSort(int[] array) {
        quickSort2(array, 0, array.length - 1);
    }
}

Heap sort

import java.util.Arrays;
import java.util.Scanner;

class HeapSort {
        private static Scanner sc;

        public static void main(String args[]) {
                sc = new Scanner(System.in);

                System.out.println("Enter no of terms");
                int n = sc.nextInt();

                System.out.println("Enter the terms");
                int arr[] = new int[n];
                for (int i = 0; i < n; i++)
                        arr[i] = sc.nextInt();

                System.out.println("The unsorted array is:");
                System.out.println(Arrays.toString(arr));

                heap(arr);

                System.out.println("The sorted array is:");
                System.out.println(Arrays.toString(arr));
        }

        static void heapify(int a[], int n, int i) {
                int max, child;
                child = 2 * i + 1;
                max = i;
                if (child < n)
                        if (a[child] > a[max])
                                max = child;
                if (child + 1 < n)
                        if (a[child + 1] > a[max])
                                max = child + 1;
                if (max != i) {
                        int temp = a[i];
                        a[i] = a[max];
                        a[max] = temp;
                        heapify(a, n, max);
                }
        }

        static void buildheap(int a[]) {
                for (int i = a.length / 2 - 1; i >= 0; i--)
                        heapify(a, a.length, i);
        }

        static void heap(int a[]) {
                buildheap(a);
                for (int i = a.length - 1; i >= 1; i--) {
                        int temp = a[0];
                        a[0] = a[i];
                        a[i] = temp;
                        heapify(a, i, 0);
                }
        }
}

Heap Sort:

def Parent(i): return i/2
def Left(i): return 2*i
def Right(i): return 2*i+1

def Heapify(A, i, n): # A is "almost a heap" (except root); fix it so all of A is a heap
    l = Left(i)
    r = Right(i)
    if l <= n and A[l] > A[i]: largest = l
    else: largest = i
    if r <= n and A[r] > A[largest]:
        largest = r
    if largest != i:
        A[i], A[largest] = A[largest], A[i]
        Heapify(A, largest, n)

def HeapLength(A): return len(A)-1

def BuildHeap(A): # build a heap A from an unsorted array
    n = HeapLength(A)
    for i in range(n/2,-1,-1):
        Heapify(A,i,n)

def HeapSort(A): # use a heap to build sorted array from the end
    BuildHeap(A)
    HeapSize=HeapLength(A)
    for i in range(HeapSize,-1,-1):
        A[0],A[i]=A[i],A[0] # largest element is a root of heap, put it at the end of array
        HeapSize=HeapSize-1 # shrink heap size by 1 to get next largest element
        Heapify(A,0,HeapSize)

counting and radix sort
#!/usr/bin/env python

def counting_sort(array, maxval):
    """in-place counting sort"""
    n = len(array)
    m = maxval + 1
    count = [0] * m               # init with zeros
    for a in array:
        count[a] += 1             # count occurences
    i = 0
    for a in range(m):            # emit
        for c in range(count[a]): # - emit 'count[a]' copies of 'a'
            array[i] = a
            i += 1
    return array

print counting_sort( [1, 4, 7, 2, 1, 3, 2, 1, 4, 2, 3, 2, 1], 7 )


// bucketSort(arr[], n)
public class BucketSort {
    private static final int DEFAULT_BUCKET_SIZE = 5;

    public static void sort(Integer[] array) {
        sort(array, DEFAULT_BUCKET_SIZE);
    }

    public static void sort(Integer[] array, int bucketSize) {
        if (array.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        Integer minValue = array[0];
        Integer maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // Initialise buckets
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Distribute input array values into buckets
        for (int i = 0; i < array.length; i++) {
            buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
        }

        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            InsertionSort.sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }
    }
}



// Radix Sort

class Radix {
 
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
 
 
    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }}


Linked list reversal recursive
Ans:

def reverseList(self, head):
     if head is None:
          return None
     if head.next is None:
          return head
     l = self.reverseList(head.next)
     head.next.next = head
     head.next = None
     return l

Iterative:
      def reverse(self, head):
          # write your code here
          if not head:
            return head
          prev = None
          curr = head
          while curr:
              temp = curr.next
              curr.next = prev
              prev = curr
              curr = temp
return prev


Prime number generation/Sieve of Eratosthenes:
The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). For the more mathematically inclined readers, you can read more about its algorithm complexity on Wikipedia.

/* Generate a prime list from 0 up to n, using The Sieve of Erantosthenesparam n The upper bound of the prime list (including n)param prime[] An array of truth value whether a number is prime*/void prime_sieve(int n, bool prime[]) {
  prime[0] = false;
  prime[1] = false;
  int i;
  for (i = 2; i <= n; i++)
    prime[i] = true;

  int limit = sqrt(n);
  for (i = 2; i <= limit; i++) {
    if (prime[i]) {
      for (int j = i * i; j <= n; j += i)
        prime[j] = false;
    }
  }}

BST to sorted DLL  
class TreeList {
    /*     helper function -- given two list nodes, join them          together so the second immediately follow the first.         Sets the .next of the first and the .previous of the second.    */
    public static void join(Node a, Node b) {
        a.right = b;
        b.left = a;
    }
    
class TreeList {
    /*
     helper function -- given two list nodes, join them
     together so the second immediately follow the first.
     Sets the .next of the first and the .previous of the second.
    */
    public static void join(Node a, Node b) {
        a.right = b;
        b.left = a;
    }

    
    /*
     helper function -- given two circular doubly linked
     lists, append them and return the new list.
    */
    public static Node append(Node a, Node b) {
        // if either is null, return the other
        if (a==null) return(b);
        if (b==null) return(a);
        
        // find the last node in each using the .previous pointer
        Node part1 = a.left;
        Node part3 = b.left;
        
        // join the two together to make it connected and circular
        join(part1, b);
        join(part3, a);
        
        return(a);
    }

    public static Node treeToList(Node root) {
        // base case: empty tree -> empty list
        if (root==null) return(null);
        
        // Recursively do the subtrees (leap of faith!)
        Node part1 = treeToList(root.left);
        Node part3 = treeToList(root.right);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.left = root;
        root.right = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (part1, root, part3)
        part1 = append(part1, root);
        part1 = append(part1, part3);
        
        return(part1);
    }
}


// 3 Sum [The solution set must not contain duplicate triplets.]
>>>>>>> 333de611c480eab554cd1f121959c2b52711c3b6

class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def threeSum(self, nums):
        nums.sort()
        ans =[]
        n = len(nums)
        for i in range(n-1):
            j = i+1
            k = n-1
            while (i != j and i!=k) and j< k:
                if (nums[j] + nums[k] + nums[i] == 0) and (sorted([nums[j], nums[k], nums[i]]) not in ans):
                    ans.append(sorted([nums[j], nums[k], nums[i]]))
                elif nums[j] + nums[k] > - nums[i]:
                    k -= 1
                else:
                    j += 1
        return ans

3 Sum Closest variant:

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
   def threeSumClosest(self, nums, target):
        nums.sort()
        ans = sys.maxint # infinity
        n = len(nums)
        for i in range(n-1):
            j = i+1
            k = n-1
            while (i != j and i!=k) and j < k:
                sum = nums[j] + nums[k] + nums[i]
                if abs(ans-target) > abs(sum - target):
                    ans = sum
                if sum > target:
                    k -= 1
                else:
                    j += 1
        return ans

4 Sum: variant

class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[][]}
    def fourSum(self, nums, target):
        solution = []
        nums.sort()
        n = len(nums)
        if n < 4:
            return []
        for i in range(n):
            for j in range(i+1, n):
                a, b = j+1, n-1  # if you start a from 0, it will time out.
                while a < b:
                    sum = nums[i] + nums[j] + nums[a] + nums[b]
                    if sum == target:
                        x = sorted([nums[i], nums[j], nums[a], nums[b]])
                        if x not in solution:
                            solution.append(x)
                        a += 1 
                        b -= 1
                    elif sum < target:
                        a += 1
                    else:
                        b -= 1
        return solution


kth smallest in a bst
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @param {integer} k
    # @return {integer}
    def kthSmallest(self, root, k):
        stack = collections.deque(maxlen=k)
        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if k == 1:
                return root.val
            k -= 1
            root = root.right



Q. Huffman encoding Algorithm: The Huffman encoding algorithm has two main steps:

Create a binary tree containing all of the items in the source by successively combining the least occurring two elements in the list until there is only one node which all others spring from. For each item in the sequence, walk down the tree from the root to the node labelled with the item — add a 0 for each time you take the left branch and a 1 for each time you take the right branch.

class Node(object):
    left = None
    right = None
    item = None
    weight = 0

    def __init__(self, i, w):
        self.item = i
        self.weight = w

    def setChildren(self, ln, rn):
        self.left = ln
        self.right = rn

    def __repr__(self):
        return "%s - %s — %s _ %s" % (self.item, self.weight, self.left, self.right)

    def __cmp__(self, a):
        return cmp(self.weight, a.weight)


from itertools import groupby
from heapq import *

itemqueue =  [Node(a,len(list(b))) for a,b in groupby(sorted(input))]
heapify(itemqueue)
while len(itemqueue) > 1:
    l = heappop(itemqueue)
    r = heappop(itemqueue)
    n = Node(None, r.weight+l.weight)
    n.setChildren(l,r)
    heappush(itemqueue, n)

codes = {}

def codeIt(s, node):
    if node.item:
        if not s:
            codes[node.item] = "0"
        else:
            codes[node.item] = s
    else:
        codeIt(s+"0", node.left)
        codeIt(s+"1", node.right)

codeIt("",itemqueue[0])

def huffman(input):
    # above code 

    return codes, "".join([codes[a] for a in input])

>>> from huffman import *
>>> input = "aababcabcd"
>>> huffman(input)
({'a': '0', 'c': '111', 'b': '10', 'd': '110'}, '0010010111010111110')
>>> len(input) * 8, len(huffman(input)[1])
(80, 19)
>>> input = "the quick brown fox jumps over the lazy dog" 
>>> huffman(input)
({' ': '00', 'a': '10000', 'c': '10011', 'b': '110000', 'e': '1010', 'd': '111111', 'g': '110111', 'f': '01001', 'i': '110101', 'h': '11110', 'k': '110011', 'j': '111110', 'm': '110001', 'l': '110010', 'o': '1011', 'n': '01000', 'q': '10010', 'p': '110110', 's': '110100', 'r': '11101', 'u': '0101', 't': '11100', 'w': '01111', 'v': '10001', 'y': '01100', 'x': '01110', 'z': '01101'}, '111001111010100010010010111010110011110011001100001110110110111101000000100110110111000111110010111000111011011010000101110001101011101001110011110101000110010100000110101100001111111011110111')
>>> len(input) * 8, len(huffman(input)[1])
(344, 192)
>>> import urllib
>>> input = urllib.urlopen("http://docs.python.org/lib/front.html").read()
>>> len(input) * 8, len(huffman(input)[1])
(57808, 36340)
>>> input = file("wrnpc12.txt").read()
>>> len(input) * 8, len(huffman(input)[1])
(26281320, 14962010)

From: http://www.techrepublic.com/article/huffman-coding-in-python/ 

￼￼ 25. Rotate matrix


class Solution:
"""
@param matrix: A list of lists of integers
@return: Nothing
"""
def rotate(self, matrix):
# write your code here
n = len(matrix)
for i in range(n/2):
    for j in range(i, n-i-1):
        tmp = matrix[i][j]
        matrix[i][j] = matrix[n-1-j][i]
        matrix[n-1-j][i] = matrix[n-1-i][n-1-j]
        matrix[n-1-i][n-1-j] = matrix[j][n-1-i]
        matrix[j][n-1-i] = tmp

Generic algorithm:
for(r = 0; r < m; r++)
{
   for(c = 0; c < n; c++)
   {
      // Hint: Map each source element indices into
      // indices of destination matrix element.
       dest_buffer [ c ] [ m - r - 1 ] = source_buffer [ r ] [ c ];
   }
}
Another method from Stackoverflow[highly voted]:
O(n^2) time and O(1) space algorithm ( without any workarounds and hanky-panky stuff! )
Rotate by +90:
    Transpose
    Reverse each row

class Solution(object):
class Solution(object):
    def reverse(self, row):
        n = len(row)
        i, j = 0, n-1
        while i <= j:
            row[i], row[j] = row[j], row[i]
            i += 1
            j -= 1


    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n-1):
            for j in range(i+1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        for i in range(n):
            self.reverse(matrix[i])

1. Diameter of a tree: Definition: The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree.

class Height {
    int height;
}

public class DiameterOfTree {
    public int diameter(Node root) {
        Height height = new Height();
        return diameter(root, height);
    }

    private int diameter(Node root, Height height) {
        if (root == null) return 0;
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        int dial = diameter(root.left, leftHeight);
        int diar = diameter(root.right, rightHeight);
        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
        return Math.max(Math.max(dial, diar), (1 + leftHeight.height + rightHeight.height));
    }
}

   //iterative postorder . For preorder, reverse order of step1 and step2 and you don’t need outputStack
   public static void postorderTraversal(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> outputStack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node n = stack.pop();
            if(n != null) {
                outputStack.push(n);
                stack.push(n.left); // step1
                stack.push(n.right); // step 2. Reverse 1 and 2 to get preorder. 
            }
        }
        while(!outputStack.isEmpty()) {
            System.out.print(outputStack.pop().val +" ");
        }
    }


# Inorder Iterative (DFS)
def in_order_traverse_iter(root):
    stack = []; result = []
    node = root
    while True:
        while node:
            stack.append(node)
            node = node.left
        if not stack: break
        node = stack.pop()
        result.append(node.val)
        node = node.right
    return result

# Preorder Iterative (DFS)
def preorder_traverse_iter(root):
    stack = [root]; result = []
    while stack: # Use while !
        node = stack.pop()
        if node: # check if node !
            result.append(node.val)
            stack.append(node.right)
            stack.append(node.left)
    return result 


Infix to postfix and evaluate postfix
"""
Definition of ExpressionTreeNode:
class ExpressionTreeNode:
    def __init__(self, symbol):
        self.symbol = symbol
        self.left, self.right = None, None
"""
class MyNode():
    def __init__(self, val, s):
        self.left = None
        self.right = None
        self.val = val
        self.node = ExpressionTreeNode(s)

class Solution:
    # @param expression: A string list
    # @return: The root of expression tree
    def build(self, expression):
        # write your code here
        if not expression:
            return None
        root = self.buildTree(expression)
        return self.copyTree(root)

    def copyTree(self, root):
        if not root:
            return None
        root.node.left = self.copyTree(root.left)
        root.node.right = self.copyTree(root.right)
        return root.node

    def buildTree(self, expression):
        stack = []
        val = 0
        base = 0
        for i, s in enumerate(expression):
            #get priority
            if s == "(":
                base += 10
                #bracket doesn't add into stack, just continue
                continue
            elif s == ")":
                base -= 10
                continue
            val = self.getVal(s, base)
            curr = MyNode(val, s)
            while stack and val <= stack[-1].val:
                curr.left = stack.pop()
            if stack:
                stack[-1].right = curr
            stack.append(curr)
        if not stack:
            return None
        return stack[0]

    def getVal(self, s, base):
        if s == "+" or s == "-":
            return 1 + base
        elif s == "*" or s == "/":
            return 2 + base

        return sys.maxint


Median of a data stream

class MedianFinder {

    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue(); // try for Collections.reverseOrder()

    public void addNum(int num) {
        large.add((long) num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
              ? large.peek()
              : (large.peek() + small.peek()) / 2.0;
    }
};

nQueen
def totalNQueens(self, n):
    self.res = 0
    self.dfs([-1]*n, 0)
    return self.res

def dfs(self, board, index):
    if index == len(board):
        self.res += 1
        return 
    for i in xrange(len(board)):
        if self.check(board, index, i):
            board[index] = i
            self.dfs(board, index+1)

# check whether kth queen can be placed# in column jdef check(self, board, k, j):
    for i in xrange(k):
        if board[i] == j or k-i == abs(j-board[i]):
            return False
    return True

 regex pattern matching

public class Solution {
    public boolean isMatch(String string, String pattern){
        return matchRegexRecursive(string.toCharArray(), pattern.toCharArray(), 0, 0);
    }

    private boolean matchRegexRecursive(char text[], char pattern[], int pos1, int pos2){
        //if pos2 has reached end of pattern means pos2 should also reach end of text for match
        //to happen
        if(pos2 == pattern.length) { 
            return pos1 == text.length;
        } 

        //if next character is not * means either current value at pattern and text should be same
        //or current value at pattern should be . in which case you can skip one character of text
        if(pos2 == pattern.length - 1 || pattern[pos2+1] != '*') {
            return (pos1 < text.length && (text[pos1] == pattern[pos2] || pattern[pos2] == '.')) \
                    && matchRegexRecursive(text, pattern, pos1+1, pos2+1);
        }

        //if we have case like abc and ad*bc so here we totally skip d*
        if(matchRegexRecursive(text, pattern, pos1, pos2+2)){
            return true;
        }

        //For case like abbc and ab*c match first b with b* and then next b to c. If that does not work out
        //then try next b with b* and then c with c and so on.
        //if pattern current val is . then skip one character at time from text till we either reach end of text
        //or a match is found
        while(pos1 < text.length && (text[pos1] == pattern[pos2] || pattern[pos2] == '.')){
            if( matchRegexRecursive(text, pattern, pos1+1, pos2+2)){
                return true;
            }
            pos1++;
        }
        return false;
    }

}

//DP approach

    /**
    * Dynamic programming technique for regex matching.
    */
    public boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }


Logic: [Thoughts], from: http://pengbos.com/algorithms/leetcode-regular-expression-matching-solution
String match, and it is a typical DP problem.

create a two dimension table dp[s.length()+1][p.length()+1]

so dp[i][j] means whether string [0, i-1] matches pattern [0, j-1]

and dp[i+1][j+1] means whether string [0, i] matches pattern [0, j]

to initialize, dp[0][0] should be true, which means empty string matches empty string.

and dp[i][0] should be always false, when string is not empty, but the pattern is empty.

and dp[0][j] depends on whether there are ‘’, because * could match empty string, for example ‘a’ could match an empty string

to get the value dp[i+1][j+1]:

1. the simplest way, if s[i]p[j]|| p[j]’.’, that means we need to check whether s[0, i-1] matches p[0, j-1]

dp[i+1][j+1] = dp[i][j]

2. the complicated way, if(p[j]==’*’), that means we need to check the wildcard

the wildcard may take effective from 0 time to many times

if the wild card plays 0 time, then it matches an empty string with the previous character.

in this scenario, dp[i+1][j+1] = dp[i+1][j-1]

if the wild card plays once, then dp[i+1][j+1] = dp[i][j-1] && (s[i]==p[j-1] || p[j-1] == ‘.’)

if the wild card plays many times, the dp[i+1][j+1] = dp[i][j+1] && (s[i]==p[j-1] || p[j-1] == ‘.’)

3. the other scenarios, the default value “false” will be populated for the rest.

# For . and * problem
# dp
# Time:  O(m * n)
# Space: O(m * n)
class Solution2:
    # @return a boolean
    def isMatch(self, s, p):
        result = [[False for j in xrange(len(p) + 1)] for i in xrange(len(s) + 1)]

        result[0][0] = True
        for i in xrange(2, len(p) + 1):
            if p[i-1] == '*':
                result[0][i] = result[0][i-2]

        for i in xrange(1,len(s) + 1):
            for j in xrange(1, len(p) + 1):
                if p[j-1] != '*':
                    result[i][j] = result[i-1][j-1] and (s[i-1] == p[j-1] or p[j-1] == '.')
                else:
                    result[i][j] = result[i][j-2] or (result[i-1][j] and (s[i-1] == p[j-2] or p[j-2] == '.'))

        return result[len(s)][len(p)]


# For ? and * problem : Wildcard matching problem Leetcode
# dp
# Time:  O(m * n)
# Space: O(m * n)
class Solution3:
    # @return a boolean
    def isMatch(self, s, p):
        result = [[False for j in xrange(len(p) + 1)] for i in xrange(len(s) + 1)]

        result[0][0] = True
        for i in xrange(1, len(p) + 1):
            if p[i-1] == '*':
                result[0][i] = result[0][i-1]
        for i in xrange(1,len(s) + 1):
            result[i][0] = False
            for j in xrange(1, len(p) + 1):
                if p[j-1] != '*':
                    result[i][j] = result[i-1][j-1] and (s[i-1] == p[j-1] or p[j-1] == '?')
                else:
                    result[i][j] = result[i][j-1] or result[i-1][j]

        return result[len(s)][len(p)]



Binary Search in a rotated sorted array
==============================
     def search(a, left, right, x):
          mid = left+ (right-left)/2
          if x == a[mid]:
               return mid
          if right <left:
               return -1
          #either the left half or right half must be normally ordered. Find out which side is normally ordered, and then use the normally ordered
          #half to figure out which side to search to find x
          if a[left] < a[mid]:  # left is normally ordered
               if x >= a[left] and x < a[mid]:
                    return search(a, left, mid-1, x) # search left
               else:
                    return search(a, mid+1, right,x) # search right
          elif a[mid] < a[left] # right is normally ordered
               if x > a[mid] and  x <= a[right]:
                    return search(a, mid+1, right, x) # search right
               else:
                    return search(a, left, mid-1, x) # search left
          elif a[left] == a[mid]: # left half is all repeats : 2,2,2,3,4,2
               if a[mid] != a[right]: # right is diff, search it
                    return search(a, mid+1, right, x) # search right
               else: #else, we have to search both sides
                     result = search(a, left, mid-1, x) # search left
                     if result == -1:
                         return search(a, mid+1, right, x) # search right
                     else:
                         return result
          return -1
          
Iterative Python [accepted on leetcode]:
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: bool
        """
        n = len(nums)
        lo, hi = 0, n-1
        while lo <= hi:
            mid = lo + (hi-lo)/2
            if nums[mid] == target:
                return True
            if nums[mid] > nums[lo]: # left half is sorted
                if nums[lo] <= target < nums[mid]:
                    hi = mid-1
                else:
                    lo = mid+1
            elif nums[mid] < nums[lo]: # right half is sorted
                if mid < n-1 and nums[mid+1] <= target <= nums[hi]:
                    lo = mid+1
                else:
                    hi = mid-1
            elif nums[mid] == nums[lo]:
                if nums[mid] != nums[hi]: # right half is diff
                    lo = mid+1
                else: #search both halfs
                    for i in range(lo, hi+1):
                        if nums[i] == target:
                            return True
                    else:
                        return False
        return False

Clone Graph
# Definition for a undirected graph node
# class UndirectedGraphNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []
from collections import deque
class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: UndirectedGraphNode
        :rtype: UndirectedGraphNode
        """
        if not node:
            return None
        queue = deque()
        mp = {}
        queue.append(node)
        copy_root = UndirectedGraphNode(node.label)
        print copy_root.label
        mp[node] = copy_root
        while queue:
            x = queue.popleft()
            print x.label
            copy_x = mp[x]
            for neighbor in x.neighbors:
                if neighbor not in mp:
                    copy_neighbor = UndirectedGraphNode(neighbor.label)
                    copy_x.neighbors.append(copy_neighbor)
                    mp[neighbor] = copy_neighbor
                    queue.append(neighbor)
                else:
                    copy_x.neighbors.append(mp[neighbor])

        return copy_root

# Definition for a undirected graph node
# class UndirectedGraphNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution(object):
    def clone_rec(self, root, map):
        if root is None:
            return None
        root_copy = UndirectedGraphNode(root.label)
        map[root] = root_copy

        for neighbor in root.neighbors:
            if neighbor not in map:
                root_copy.neighbors.append(self.clone_rec(neighbor, map))
            else:
                root_copy.neighbors.append(map[neighbor])
        return root_copy

    def cloneGraph(self, node):
        """
        :type node: UndirectedGraphNode
        :rtype: UndirectedGraphNode
        """
        map = {}
        return self.clone_rec(node, map)

Subsets of a list [power set]/permutation


Permutations : https://leetcode.com/problems/permutations/
public List<List<Integer>> permute(int[] nums) {
  List<List<Integer>> list = new ArrayList<>();
  // Arrays.sort(nums); // not necessary
  backtrack(list, new ArrayList<>(), nums);
  return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
  if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
  } else{
      for(int i = 0; i < nums.length; i++){
        if(tempList.contains(nums[i])) continue; // element already exists, skip
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
  }
}


Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}


Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/

public List<List<String>> partition(String s) {
  List<List<String>> list = new ArrayList<>();
  backtrack(list, new ArrayList<>(), s, 0);
  return list;
}

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
  if(start == s.length())
      list.add(new ArrayList<>(tempList));
  else{
      for(int i = start; i < s.length(); i++){
        if(isPalindrome(s, start, i)){
            tempList.add(s.substring(start, i + 1));
            backtrack(list, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
        }
      }
  }
}

public boolean isPalindrome(String s, int low, int high){
  while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
  return true;
}


	
//30. Combination: Picking 'k' items from a list of 'n' - Recursion 

public class Solution { 
    public List<List<Integer>> combine(int n, int k) { 
        List<List<Integer>> list = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>(); 
        backtrack(list, temp, n, k, 1); 
        return list; 
    } 
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int n, int k, int start){ 
        if(temp.size() == k) { list.add(new ArrayList<>(temp)); return; } 
        for(int i=start;i<=n;i++){ 
            temp.add(i); 
            backtrack(list, temp, n, k, i+1); 
            temp.remove(temp.size()-1); 
        } 
    } 
} 

Power set 
-=== 
Subsets : https://leetcode.com/problems/subsets/

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}


Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/

public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 

Combination Sum: Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.

Combination Sum : https://leetcode.com/problems/combination-sum/

public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}


//Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/

public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
   
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
} 




//Inorder successor in a BST:
class Solution(object):
    def inorderSuccessor(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        # If it has right subtree.
        if p and p.right:
            p = p.right
            while p.left:
                p = p.left
            return p

        # Search from root.
        successor = None
        while root and root != p:
            if root.val > p.val:
                successor = root
                root = root.left
            else:
                root = root.right

        return successor


//LRU Cache
 class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}

/**
 * Always add the new node right after head;
 */
private void addNode(DLinkedNode node){
    node.pre = head;
    node.post = head.post;
    
    head.post.pre = node;
    head.post = node;
}

/**
 * Remove an existing node from the linked list.
 */
private void removeNode(DLinkedNode node){
    DLinkedNode pre = node.pre;
    DLinkedNode post = node.post;
    
    pre.post = post;
    post.pre = pre;
}

/**
 * Move certain node in between to the head.
 */
private void moveToHead(DLinkedNode node){
    this.removeNode(node);
    this.addNode(node);
}

// pop the current tail. 
private DLinkedNode popTail(){
    DLinkedNode res = tail.pre;
    this.removeNode(res);
    return res;
}

private Hashtable<Integer, DLinkedNode> 
    cache = new Hashtable<Integer, DLinkedNode>();
private int count;
private int capacity;
private DLinkedNode head, tail;

public LRUCache(int capacity) {
    this.count = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    head.pre = null;
    
    tail = new DLinkedNode();
    tail.post = null;
    
    head.post = tail;
    tail.pre = head;
}

public int get(int key) {
    
    DLinkedNode node = cache.get(key);
    if(node == null){
        return -1; // should raise exception here.
    }
    
    // move the accessed node to the head;
    this.moveToHead(node);
    
    return node.value;
}


public void set(int key, int value) {
    DLinkedNode node = cache.get(key);
    
    if(node == null){
        
        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;
        
        this.cache.put(key, newNode);
        this.addNode(newNode);
        
        ++count;
        
        if(count > capacity){
            // pop the tail
            DLinkedNode tail = this.popTail();
            this.cache.remove(tail.key);
            --count;
        }
    }else{
        // update the value.
        node.value = value;
        this.moveToHead(node);
    }
    
}
//Shorter using APIs
import java.util.LinkedHashMap;
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}

//Hash table implementation 

import java.util.ArrayList;

public class Hasher<K, V> {
        private static class LinkedListNode<K, V> {
                public LinkedListNode<K, V> next;
                public LinkedListNode<K, V> prev;
                public K key;
                public V value;
                public LinkedListNode(K k, V v) {
                        key = k;
                        value = v;
                }
               
                public String printForward() {
                        String data = "(" + key + "," + value + ")";
                        if (next != null) {
                                return data + "->" + next.printForward();
                        } else {
                                return data;
                        }
                }
        }     
       
        private ArrayList<LinkedListNode<K, V>> arr;
        public Hasher(int capacity) {
                /* Create list of linked lists. */
                arr = new ArrayList<LinkedListNode<K, V>>();
                arr.ensureCapacity(capacity);
                for (int i = 0; i < capacity; i++) {
                        arr.add(null);
                }
        }
       
        /* Insert key and value into hash table. */
        public void put(K key, V value) {
                LinkedListNode<K, V> node = getNodeForKey(key);
                if (node != null) {
                        node.value = value; // just update the value.
                        return;
                }
               
                node = new LinkedListNode<K, V>(key, value);
                int index = getIndexForKey(key);
                if (arr.get(index) != null) {
                        node.next = arr.get(index);
                        node.next.prev = node;
                }
                arr.set(index, node);
        }
       
        /* Remove node for key. */
        public void remove(K key) {
                LinkedListNode<K, V> node = getNodeForKey(key);
                if (node.prev != null) {
                        node.prev.next = node.next;
                } else {
                        /* Removing head - update. */
                        int hashKey = getIndexForKey(key);
                        arr.set(hashKey, node.next);
                }
               
                if (node.next != null) {
                        node.next.prev = node.prev;
                }
        }
       
        /* Get value for key. */
        public V get(K key) {
                LinkedListNode<K, V> node = getNodeForKey(key);
                return node == null ? null : node.value;
        }
       
        /* Get linked list node associated with a given key. */
        private LinkedListNode<K, V> getNodeForKey(K key) {
                int index = getIndexForKey(key);
                LinkedListNode<K, V> current = arr.get(index);
                while (current != null) {
                        if (current.key == key) {
                                return current;
                        }
                        current = current.next;
                }
                return null;             
        }
       
        /* Really stupid function to map a key to an index. */
        public int getIndexForKey(K key) {
                return Math.abs(key.hashCode() % arr.size());
        }
       
        public void printTable() {
                for (int i = 0; i < arr.size(); i++) {
                        String s = arr.get(i) == null ? "" : arr.get(i).printForward();
                        System.out.println(i + ": " + s);
                }
        }


//K way merge
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
                @Override
                public int compare(ListNode l1, ListNode l2) { return l1.val-l2.val; }
            });

        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null){
                pq.offer(lists[i]); // we should be able to initialize from a list: PriorityQueue(Collection<? extends E> c)
            }
        }
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            if(l.next != null){
                pq.offer(l.next);
            }
            mergedList.next = l;
            mergedList = mergedList.next;
        }
        return head.next;
    }
}



Permutations : https://leetcode.com/problems/permutations/

public List<List<Integer>> permute(int[] nums) {
  List<List<Integer>> list = new ArrayList<>();
  // Arrays.sort(nums); // not necessary
  backtrack(list, new ArrayList<>(), nums);
  return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
  if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
  } else{
      for(int i = 0; i < nums.length; i++){
        if(tempList.contains(nums[i])) continue; // element already exists, skip
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
  }
}


Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/

public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
}

Reverse a string word by word

public void reverseWords(char[] s) {
    reverse(s, 0, s.length-1);  // reverse the whole string first
    int r = 0;
    while (r < s.length) {
        int l = r;
        while (r < s.length && s[r] != ' ')
            r++;
        reverse(s, l, r-1);  // reverse words one by one
        r++;
    }
}

public void reverse(char[] s, int l, int r) {
    while (l < r) {
        char tmp = s[l];
        s[l++] = s[r];
        s[r--] = tmp;
    }
}

Integer to English Words
public class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }
   
    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
}

Deck of Cards

public abstract class Card {
        private boolean available = true;
       
        /* number or face that's on card - a number 2 through 10,
        * or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace
        */
        protected int faceValue;
        protected Suit suit;

        public Card(int c, Suit s) {
                faceValue = c;
                suit = s;
        }
       
        public abstract int value();
       
        public Suit suit() {
                return suit;
        }
       
        /* returns whether or not the card is available to be given out to someone */
        public boolean isAvailable() {
                return available;
        }
       
        public void markUnavailable() {
                available = false;
        }
       
        public void markAvailable() {
                available = true;
        }
       
        public void print() {
                String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
                System.out.print(faceValues[faceValue - 1]);
                switch (suit) {
                case Club:
                        System.out.print("c");
                        break;
                case Heart:
                        System.out.print("h");
                        break;
                case Diamond:
                        System.out.print("d");
                        break;
                case Spade:
                        System.out.print("s");
                        break;                 
                }
                System.out.print(" ");
        }
}

Roman to integer and vice versa

class Solution:
    # @param {int} n The integer
    # @return {string} Roman representation
    def intToRoman(self, n):
        # Write your code here
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        symbols = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        result = ""
        index = 0
        while n:
            k = n / values[index]
            for j in range(k):
                result += symbols[index]
            n = n % values[index]
            index += 1
        return result

class Solution:
    # @param {string} s Roman representation
    # @return {int} an integer
    def romanToInt(self, s):
        # Write your code here
        map = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }
        if not s:
            return
        result = 0
        prev = 0
        for i in range(len(s)):
            curr = map[s[i]]
            if prev < curr:
                result += curr - 2 * prev
            else:
                result += curr
            prev = curr

return result


