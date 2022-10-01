package wyx.other;

import wyx.bean.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import wyx.bean.*;

public class record{
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top()+","+stack.toString());
        System.out.println(stack.getMin());
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> temp = new HashMap<>();
        int count=1;
        for (int i = 0,j=0; j < s.length(); j++) {
            if(temp.containsKey(s.charAt(j))) {
                i = Math.max(temp.get(s.charAt(j)), i); 
            }
            count = Math.max(count, j+1-i);
            temp.put(s.charAt(j), j+1);
        }
        return count;
    }

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                switch(String.valueOf(s.charAt(i))){
                    case ")":
                        if("(".equals(stack.pop()))
                            break ;
                        else return false;
                    case "}":
                        if("{".equals(stack.pop()))
                            break ;
                        else return false;
                    case"]":
                        if("[".equals(stack.pop()))
                            break ;
                        else return false;
                    default:
                        stack.add(String.valueOf(s.charAt(i)));
                        break;
                }
            }
            System.out.println("stack:"+stack.toString());
            return stack.isEmpty();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public static int reverse(int x) {
        if(x==0) return 0;
        boolean isNn = x < 0;
        String s = String.valueOf(x);
        if(isNn) s = s.substring(1);
    
        return 0;
    }

    private static String trim0 (String str){
        int len = str.length();
        int st = 0;
        char[] val = str.toCharArray();    /* avoid getfield opcode */

        while ((st < len) && (val[st] == '0')) {
            st++;
        }
        return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
    }

    private static String isSpace(String str){
        return str.trim();
    }

    //Unicode转中文方法
    private static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }
 
    //中文转Unicode
    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
    
    private static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    private static int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    private static int climbStairsforleecode(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    private static boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private static boolean isMirror(TreeNode t1,TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    private static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftLength = maxDepth(root.left);
            int rightLength = maxDepth(root.right);
            return Math.max(leftLength, rightLength) + 1;
        }
    }

    private static boolean isRoot(TreeNode tNode){
        if(tNode.left != null) {isRoot(tNode.left);}
        if(tNode.right != null) {isRoot(tNode.right);}
        return (tNode.left != null) && (tNode.right != null);
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i=0;i<prices.length;i++) {
            if(prices[i]<minPrice){
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return (int)set.iterator().next();
    }

    public int singleNumberForLeecode(int[] nums) {
        int singlel = 0;
        for (int i : nums) {
            singlel ^= i;
        }
        return singlel;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        Set<ListNode> listNodes = new HashSet<>();
        while(head != null){
            if(listNodes.contains(head.next)){
                return true;
            } else listNodes.add(head.next);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fastListNode = head.next;
        ListNode slowListNode = head;
        while(fastListNode != slowListNode){
            if(fastListNode == null || fastListNode.next ==null) return false;
            slowListNode = slowListNode.next;
            fastListNode = fastListNode.next.next;
        }
        return true;
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else map.put(i, 1);
        }
        Map.Entry<Integer,Integer> mEntry = null;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(mEntry==null || entry.getValue()>mEntry.getValue()) {
                mEntry = entry;
            }
        }
        return mEntry.getKey();
    }

    public int rob(int[] nums) {
        int count1=0,count2=0;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0) count2 = count2+nums[i];
            else count1 = count1+nums[i];
        }
        return Math.max(count1, count2);
    }

    public static void selectSort(int[] arr) {
        
        for(int i=0;i<arr.length - 1;i++){
            int min = i;
            for(int j=i+1;j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insterSort(int[] nums){
        for(int i=1; i<nums.length;i++) {
            for(int j=i;j>0;j--) {
                if(nums[j]<nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++) {
            boolean flag = true;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[i]<nums[i-1]) {
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left ==null && root.right==null) return 1;
        int min_depth = Integer.MAX_VALUE;
        if(root.left != null){
            min_depth = Math.min(min_depth,minDepth(root.left));
        }
        if(root.right != null){
            min_depth = Math.min(min_depth,minDepth(root.right));
        }
        return min_depth+1;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) { //递归
        if(head == null || head.next == null){return head;}
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int font = 0, end = arr.size() - 1;
        while(font < end) {
            if(!arr.get(font).equals(arr.get(end))) {
                return false;
            }
            font++;
            end--;
        }
        return true;
        
    }

}


class MinStack {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int x) {
        if(minStack.isEmpty() || x<minStack.peek()) minStack.add(x);
        else minStack.add(minStack.peek());
        stack.add(x);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return Arrays.toString(stack.toArray());
    }
}