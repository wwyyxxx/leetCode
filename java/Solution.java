import java .util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.*;

import bean.*;
/*
 * @Author: Tungbo
 * @Date: 2021-07-06 14:44:26
 * @LastEditTime: 2021-08-03 15:53:42
 * @LastEditors: Tungbo
 * @Description: leecode: leetcode记录
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");

        // System.out.println(new Solution().validateStackSequences1(null,null));
        String parts = "123456".substring(0,5);
        System.out.println(new Solution().minWindow("ADOBECODEBANC","ABC"));
        // System.out.println(new Solution().pruneTree(null));
    }


    // 树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return isSameNode(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    private boolean isSameNode(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && isSameNode(A.left,B.left) && isSameNode(A.right,B.right);
    }

    // 正则表达式匹配
    public boolean isMatchOfMy(String s, String p) {
        int len = p.length();
        for(int i=0;i<len;i++){
            if(s.length()==0) return true;
            char temp = p.charAt(i);
            switch(temp){
                case '.':
                    s = s.substring(1);
                    break;
                case '*':
                    if(i!=0) {
                        char div = p.charAt(i-1);
                        s = sub(s,div);
                    }
                    break;
                default:
                    if(s.charAt(0) == temp) {
                        s = s.substring(1);
                    } else return false;
            }
        }
        return s.length() == 0;
    }
    public String sub(String s,char div){
        if(s.length() == 0) return "";
        if(div == '.') return "";
        if(s.charAt(0) == div) s = sub(s.substring(1),div);
        return s;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    
    // 二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tempLeft = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tempLeft);
        return root;
    }

    // 对称的二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode rootL,TreeNode rootR) {
        if(rootL == null && rootR == null) return true;
        if(rootL == null || rootR == null) return false;
        return rootL.val == rootR.val && isSymmetric(rootL.left,rootR.right) && isSymmetric(rootL.right,rootR.left);
    }

    // 表示数值的字符串
    public boolean isNumberMy(String s) {
        s = s.trim();
        int len = s.length();
        int count = 0;
        if(len == 0 || !Character.isDigit(s.charAt(s.length()-1))) return false;
        for(int i=0;i<len;i++) {
            if((s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == '.') && i == len-1) return false;
            if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && i ==0) return false;
            if(s.charAt(i) == '.') {
                count++;
                if(i == 0 || count > 1) return false;
            }
            if(!isNUm(s.charAt(i))) return false;
        }
        return true;
    }
    public boolean isNUm(char c) {
        return c =='0'||c =='1'||c =='2'||c =='3'||c =='4'||c =='5'||c =='6'||c =='7'||c =='8'||c =='9'||c =='-'||c =='+'||c =='e'||c =='E';
    }
    
    // 表示数值的字符串
    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int length = s.length();
        State state = State.STATE_INITIAL;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }
    public CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }
    enum State {
        STATE_INITIAL,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUMBER,
        STATE_END
    }
    enum CharType {
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }

    // 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        if(nums.length == 0) return nums;
        int left = 0, right = nums.length;
        while(left<right) {
            if(nums[left] % 2 ==0) {
                if(nums[right] %2 ==0) {
                    right--;
                } else{
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            } else {
                left++;
            }
        }
        return nums;
    }

    // 顺时针打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int left = 0, r = matrix[0].length -1, top = 0, row = matrix.length - 1, x=0;
        int[] result = new int[(row+1)*(r+1)];
        while(true) {
            for(int i = left;i<=r;i++) result[x++] = matrix[top][i]; //左到右
            if(++top > row) break;

            for(int i = top;i<=row;i++) result[x++] = matrix[i][r]; //上到下
            if(left > --r) break;

            for(int i = r;i>=left;i--) result[x++] = matrix[row][i]; //右到左
            if(top > --row) break;
            
            for(int i = row;i>=top;i--) result[x++] = matrix[i][left]; //下到上
            if(++left > row) break;
        }
        return result;
    }
    public int[] spiralOrder1(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }
        return res;
    }

    // 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while(fast!=null || k<0) {
            fast = fast.next;
            k--;
        }
        while(fast!= null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        Stack<Integer> stack = new Stack<>();
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        while(!stack.isEmpty()){
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return result.next;
    }

    // 复杂链表的复制
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        for(Node n = cur;n != null; n = n.next) {
            map.put(n, new Node(n.val));
        }
        for(Node n = cur;n != null; n = n.next) {
            map.get(n).next = n.next;
            map.get(n).random = n.random;
        }
        return map.get(head);
    }

    //栈的压入、弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i=0;i<pushed.length;i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    // 连续子数组的最大和
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i =1;i<nums.length;i++) {
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(nums[i],res);
        }
        return res;
    }

    //数组中出现次数超过一半的数字
    public int majorityElement(int[] nums) {
        int count = nums.length / 2;
        int res = nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
            if(map.get(nums[i]) == null) { map.put(nums[i], 1); }
            else {
                res = map.get(nums[i]) + 1;
                if(res>count) return nums[i];
                map.put(nums[i], res);
            }
        }
        return res;
    }

    // 从上到下打印二叉树
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        int[] r = new int[res.size()];
        for(int i =0;i<res.size();i++){
            r[i] = res.get(i);
        }
         return r;
    }

    // 从上到下打印二叉树
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        while(!queue.isEmpty()) {
            List<Integer> rows = new ArrayList<>();
            for (int i=queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                rows.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(rows);
        }
        return res;
    }

     // 从上到下打印二叉树3
     public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        while(!queue.isEmpty()) {
            List<Integer> rows = new ArrayList<>();
            for (int i=queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                rows.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) //Collections.reverse(rows);
            res.add(rows);
        }
        return res;
    }

    // 二叉树深度
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }},temp;
        int count =0;
        while(!queue.isEmpty()) {
            temp = new LinkedList<TreeNode>();
            for(TreeNode node : queue) {
                if(node.right!=null) temp.add(node.right);
                if(node.left!=null) temp.add(node.left);
            }
            queue = temp;
            count++;
        }
        return count;
    }

    // 第一个只出现一次的字符
    public char firstUniqChar(String s) {
         Map<Character, Boolean> dic = new LinkedHashMap<>();
        for(Entry<Character,Boolean> entrySet : dic.entrySet()){
        }
        char[] chars = s.toCharArray();
        List<Character> queue = new LinkedList<>();
        List<Character> temp = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if(!queue.contains(chars[i])) {
                queue.add(chars[i]);
            } else {
                temp.add(chars[i]);
            }
        }
        for(Character c:queue){
            if(!temp.contains(c)){
                return c;
            }
        }
        return ' ';
    }

    // 两个链表的第一个公共节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fast = headA;
        ListNode slow = headB;
        while(fast!=null || slow!=null) {
            if(fast == slow) return fast;
            fast = fast == null? headB : fast.next;
            slow = slow == null ? headA : slow.next;
        }
        return null;
    }

    // 两个链表的第一个公共节点
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Map<ListNode,Boolean> temp = new HashMap<>();
        ListNode nodeTemp = headA;
        while(nodeTemp != null) {
            temp.put(nodeTemp, true);
            nodeTemp = nodeTemp.next;
        }
        nodeTemp = headB;
        while(nodeTemp!= null) {
            if(temp.containsKey(nodeTemp)) return nodeTemp;
            nodeTemp = nodeTemp.next;
        }
        return null;
    }

    // 和为s的两个数字
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length;
        while(i<j) {
            if(target - nums[j] < nums[i]) j--;
            if(target - nums[j] > nums[i]) i++;
            if(target - nums[j] == nums[i]) break;
        }
        return new int[]{nums[i], nums[j]};
    }

    int resKth,k;
    // 二叉搜索树的第k大节点
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return resKth;
    }
    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k ==0) return;
        if(--k ==0) resKth = root.val;
        dfs(root.left);
    }

    // 和为s的连续正数序列
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2,s=3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] temp = new int[j-i+1];
                for(int k =i;k<=j;k++) {
                    temp[k-i] = k;
                }
                res.add(temp);
            }
            if(s>=target) {
                s-=i;
                i++;
            } else {
                j++;
                s +=j;
            }
        }
        return res.toArray(new int[0][]);
    }

    // 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }


    // 翻转单词顺序
    public String reverseWords(String s) {
        String str = s.trim();
        String[] words = str.split(" ");
        StringBuffer res = new StringBuffer();
        for(int i = words.length-1;i>=0;i--) {
            String st = words[i];
            if(st.equals("")) continue;
            res.append(st);
            if(i!=0) res.append(" ");
        }
        return res.toString();
    }

    // 翻转单词顺序
    public String reverseWords2(String s) {
        String str = s.trim();
        int i = s.length() -1, j = i;
        StringBuffer res = new StringBuffer();
        while(i>=0) {
            while(i>=0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i+1,j+1));
            res.append(" ");
            while(i>=0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }

    // 左旋转字符串
    public String reverseLeftWords(String s, int n) {
        char[] c = s.toCharArray();
        char[] temp = new char[n];
        for(int i = 0;i<n;i++) {
            temp[i] = c[i];
            c[i] = ' ';
        }
        return new String(c).trim()+new String(temp);
    }
    
    //在排序数组中查找数字 I
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }

    // 0～n-1中缺失的数字
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length -1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] > m) j = m - 1;
            else i = m + 1;
        }
        return i;
    }

    // 扑克牌中的顺子
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 2; i>=0;i--) {
            if(nums[i]==0) {
                count--;
                continue;
            }
            int temp = nums[i+1] - nums[i];
            if(temp > 3 || temp ==0) return false;
            else if(2==temp||temp == 3) {
                count+=temp-1;
            }
            
        }
        return count<=0;
    }


    //不用加减乘除做加法
    public int add(int a, int b) {
        while(b!=0) {
            int c = (a&b) <<1;
            a ^=b;
            b =c;
        }
        return a;
    }

    // 圆圈中最后剩下的数字
    public int lastRemaining(int n, int m) {
        List<Integer> res = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            res.add(i);
        }
        int index = 0;
        while(n>1) {
            index = (index + m - 1) % n;
            res.remove(index);
            n--;
        }
        return res.get(0);
    }

    // I. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while(root!=null) {
            if(root.val < p.val) {
                root = root.right;
            }
            if(root.val > q.val) {
                root = root.left;
            }
            else break;
        }
        return root;
    }

    //  II. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }


    //  II. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        if(right == null && left == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    
    // 字符串的排列
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfsPermutation(0);
        return res.toArray(new String[res.size()]);
    }
    void dfsPermutation(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfsPermutation(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    
    // 二叉树中和为某一值的路径
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    LinkedList<Integer> temp = new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfsPathSum(root,target);
        return result;
    }

    private void dfsPathSum(TreeNode root, int target) {
        if(root == null) return;
        temp.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList(temp));
        }
        dfsPathSum(root.left, target);
        dfsPathSum(root.right, target);
        temp.removeLast();
    }

    // 二叉搜索树的后序遍历序列
    public boolean verifyPostorder(int[] postorder) {
       return cur(postorder,0,postorder.length -1); 
    }

    private boolean cur(int[] postorder, int i, int j) {
        int p = i;
        while(p < postorder[j]) p++;
        int m = p;
        while(p > postorder[j]) p++;
        return j == p && cur(postorder,i,m) && cur(postorder,m+1,j);
    }

     // 二叉搜索树与双向链表
     Node pre,head;
     public Node treeToDoublyList(Node root) {
         if(root == null) return null;
         dfsTreeToDoublyList(root);
         head.left = pre;
         pre.right = head;
         return head;
     }
 
     private void dfsTreeToDoublyList(Node cur) {
         if(cur == null) return;
         dfsTreeToDoublyList(cur.left);
         if(pre == null) head = cur;
         else pre.right = cur;
         cur.left = pre;
         pre = cur;
         dfsTreeToDoublyList(cur.right);
     }

     
    //数组中数字出现的次数
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (Integer num : nums) {
            if(!temp.add(num)) {
                temp.remove(num);
            }
        }
        int[] result = new int[temp.size()];
        int index = 0;
        for (Integer i : temp) {
            result[index++] = i;
        }
        return result;
    }

    //数组中数字出现的次数2
    public int singleNumbers2(int[] nums) {
        HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
        for (Integer num : nums) {
            if(temp.containsKey(num)) {
                int count = temp.get(num);
                if(count == 2) temp.remove(num);
                else temp.put(num,count+1);
            } else {
                temp.put(num,1);
            }
        }
        return temp.keySet().iterator().next();
    }

    //把数组排成最小的数
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuffer s = new StringBuffer();
        for(int num :nums) {
            s.append(num);
        }
        return s.toString();
    }
    
    // 把数字翻译成字符串
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i < str.length(); i++) {
            String s = str.substring(i - 2, i);
            int c = s.compareTo("10") >= 0 && s.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    // 礼物的最大价值
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0) continue;
                if(i==0) grid[i][j] += grid[i][j-1];
                else if(j==0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    // 最长不含重复字符的子字符串
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic = new HashMap<Character,Integer>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp+1 : j -i;
            res = Math.max(tmp,res);
        }
        return res;
    }

    // 丑数
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    // 构建乘积数组
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        if(len == 0) return b;
        b[0] = 1;
        int temp =1;
        for (int i = 1;i<len;i++) {
            b[i] = b[i-1] * a[i-1];
        }
        for (int i = len - 2; i>=0; i--) {
            temp *= a[i+1];
            b[i] = temp * b[i];
        }
        return b;
    }

    // 把字符串转换成整数
    public static int strToInt(String str) {
        int sign = 1 ,i = 0 ,threshold = Integer.MAX_VALUE / 10;
        int len = str.length(),res = 0;
        // Char[] c = str.toCharArray();
        if(len == 0) return 0;
        while(str.charAt(i) == ' ') {
            i++;
            if(len == i) return 0;
        }
            
        if(str.charAt(i) == '-') sign = -1;
        if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for(int j = i; j < len; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if(res>threshold || res == threshold && str.charAt(j) > '7')
                return sign ==1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

    // n个骰子的点数
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    //股票的最大利润
    public int maxProfit(int[] prices) {
        int res = 0,min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if(i ==0) continue;
            if(min > prices[i]) min = prices[i];
            else {
                res = Math.max(res,prices[i] - min);
            }
        }
        return res;
    }

    // 求1+2+…+n
    public int sumNums(int n) {
        boolean x = n>1 && (n += sumNums(n-1))>0; 
        return n;
    }

    //滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        if(k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int j = 0,i = 1 - k; j < nums.length; i++,j++) {
            if(i>0 && dq.peekFirst() == nums[i-1]) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                dq.removeLast();
            }
            dq.addLast(nums[j]);
            if(i>=0) 
                res[i] = dq.peekFirst();
        }
        return res;
    }

    // 1～n 整数中 1 出现的次数
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n/10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += digit * high;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    // 数组中的逆序对
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1;j<nums.length; j++) {
                if(nums[i] > nums[j])count++;
            }
        }
        return count;
    }

    // 数组中的逆序对
    public static int reversePairs1(int[] nums) {
        int len = nums.length;
        if(len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy,0,len -1,temp);
    }


    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums,left,mid,temp);
        int rightPairs = reversePairs(nums,mid+1,right,temp);
        
        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs + rightPairs + crossPairs;
    }


    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid+1;
        int count = 0;
        for (int k = left;k<=right;k++) {
            if(i==mid+1) {
                nums[k] = temp[j];
                j++;
            } else if(j==right+1) {
                nums[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += mid - i +1;
            }
        }
        return count;
    }

    // 数字序列中某一位的数字
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    // 整数除法
    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        boolean sign = (a > 0) ^ (b > 0);
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i > 0; i--) {
            if((a>>>i) -b >=0) {
                a -= (b<<i);
                res++;
            }
        }
        return sign ? -res : res;
    }

    // 有效的井字游戏
    public boolean validTicTacToe(String[] board) {
        int xCount=0,oCount=0;
        for(String s: board) {
            for(char c:s.toCharArray()) {
                if(c == 'X') xCount++;
                if(c == 'O') oCount++;
            }
        }
        if (xCount != oCount && oCount != xCount -1) return false;
        if (win(board,'X') && oCount != xCount -1) return false;
        if (win(board,'O') && xCount != oCount) return false;
        return true;
    }

    private boolean win(String[] board, char d) {
        for(int i = 0;i<3;i++ ){
            if(board[0].charAt(i) == d && board[1].charAt(i) == d && board[2].charAt(i) == d) return true;
            if(board[i].charAt(0) == d && board[i].charAt(1) == d && board[i].charAt(2) == d) return true;
        }
        if(board[0].charAt(0) == d && board[1].charAt(1) == d && board[2].charAt(2) == d) return true;
        if(board[0].charAt(2) == d && board[1].charAt(1) == d && board[2].charAt(0) == d) return true;
        return false;
    }

    //允许重复选择元素的组合
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0,candidates,res,temp,target);
        return res;
    }
    private void dfs(int i, int[] candidates, List<List<Integer>> res2, List<Integer> temp2, int target) {
        if(target < 0 || i <=candidates.length) {
            return;
        }
        if(target == 0) {
            res2.add(new ArrayList<>(temp2));
            return;
        }
        temp2.add(candidates[i]);
        dfs(i, candidates, res2, temp2, target-candidates[i]);
        temp2.remove(temp2.size()-1);
        dfs(i+1,candidates,res2,temp2,target);
    }

    // 二进制加法
    public static String addBinarymy(String a, String b) {
        StringBuffer res = new StringBuffer();
        boolean flag = false;
        int al = a.length() -1,bl = b.length()-1;
        while(al>=0 && bl>=0){
            if(flag) {
                if(a.charAt(al) == '1' && b.charAt(bl) == '1') {
                    res.insert(0, "1");
                    flag = true;
                } else if(a.charAt(al) == '0' && b.charAt(bl) == '0') {
                    res.insert(0, "1");
                    flag = false;
                } else {
                    res.insert(0, "0");
                    flag = true;
                }
            } else {
                if(a.charAt(al) == '1' && b.charAt(bl) == '1') {
                    res.insert(0, "0");
                    flag = true;
                } else if(a.charAt(al) == '0' && b.charAt(bl) == '0') {
                    res.insert(0, "0");
                } else {
                    res.insert(0, "1");
                }
            }
            al--;
            bl--;
        }
        if(al != bl) {
            String temp = al>bl?a.substring(0,al-bl): b.substring(0,bl-al);
            int templ = temp.length()-1;
            if(flag && templ>=0) {
                while(templ>=0){
                    if(temp.charAt(templ) == '1' && flag) {
                        res.insert(0, "0");
                        flag = true;
                    } else {
                        res.insert(0, "1");
                        flag = false;
                        break;
                    }
                    templ--;
                }
            } 
            if(templ < 0) {
                if(flag) { if(flag) res.insert(0, "1");}
            } else {
                res.insert(0, al > bl ? a.substring(0,templ+1) : b.substring(0,templ+1));
            }
        } else {
            if(flag) res.insert(0, "1");
        }
        return res.toString();
    }
    

    // 二进制加法
    public static String addBinary1(String a, String b) {
        return Integer.toBinaryString(
            Integer.parseInt(a,2)+Integer.parseInt(b,2)
        );
    }

    // 二进制加法
    public static String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int length = Math.max(a.length(),b.length());
        int carray = 0;
        for(int i=0;i< length; i++) {
            carray += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : '0';
            carray += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : '0';
            res.append((char) (carray % 2 + '0'));
            carray /= 2;
        }
        if(carray>0) res.append('1');
        res.reverse();
        return res.toString();
    }

    // 
    public List<List<Integer>> combinationSum2my(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs2my(candidates, target,new ArrayList<Integer>(),result,0);
        HashSet<List<Integer>> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);
        return result;
    }
    private void dfs2my(int[] candidates, int target, ArrayList<Integer> arrayList, List<List<Integer>> result2, int i) {
        if(target == 0) {
            result2.add(new ArrayList<Integer>(arrayList));
            return;
        }
        if(target < 0 || i == candidates.length) {
            return;
        }
        arrayList.add(candidates[i]);
        dfs2my(candidates, target-candidates[i],arrayList,result2,i+1);
        arrayList.remove(arrayList.size()-1);
        dfs2my(candidates, target,arrayList,result2,i+1);
    }
    
    // 只出现一次的数字 
    public static int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;) {
            if(i>=nums.length) break;
            if(nums[i] == nums[i+1]) { i+=3; }
            else { return nums[i]; }
        }
        return nums[nums.length-1];
    }

    // 只出现一次的数字 
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }

    //没有重复元素集合的全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfsPermute(nums,new boolean[nums.length], result,new ArrayList<>());
        return result;
    }

    private void dfsPermute(int[] nums, boolean[] perm, List<List<Integer>> result, List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(perm[j]) continue;
            tempList.add(nums[j]);
            perm[j] = true;
            dfsPermute(nums,perm,result,tempList);
            tempList.remove(tempList.size() - 1);
            perm[j] = false;
        }
    }

    // 含有重复元素集合的全排列 
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfsPermuteUnique1(nums,new boolean[nums.length], result,new ArrayList<>());
        Set<List<Integer>> tempList = new HashSet<>(result);
        result.clear();
        result.addAll(tempList);
        return result;
    }
    private void dfsPermuteUnique1(int[] nums, boolean[] perm, List<List<Integer>> result, List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(perm[j]) continue;
            tempList.add(nums[j]);
            perm[j] = true;
            dfsPermuteUnique1(nums,perm,result,tempList);
            tempList.remove(tempList.size() - 1);
            perm[j] = false;
        }
    }

    // 含有重复元素集合的全排列 
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfsPermuteUnique(nums,new boolean[nums.length], result,new ArrayList<>());
        return result;
    }
    private void dfsPermuteUnique(int[] nums, boolean[] perm, List<List<Integer>> result, List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(perm[j] || (j > 0 && nums[j] == nums[j-1] && !perm[j-1])) continue;
            perm[j] = true;
            tempList.add(nums[j]);
            dfsPermuteUnique(nums,perm,result,tempList);
            tempList.remove(tempList.size() - 1);
            perm[j] = false;
        }
    }

    // 单词长度的最大乘积
    public int maxProduct1(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for (int j = i+1; j < words.length; j++) {
                String word2 = words[j];
                if(isSame(word1, word2)) {
                    result = Math.max(result,word2.length()*word2.length());
                }
            }
        }
        return result;
    }
    public int maxProduct(String[] words) {
        int result = 0;
        String word1 = "";
        String word2 = "";
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            if(word1.equals("")) word1 = words[i];
            if(word2.equals("")) word2 = words[i];
            flag = word1.length() > word2.length() ? true : false;
            if(i>1) {
                if (flag) word2 = words[i].length() >= word2.length() ? words[i] : word2;
                else word1 = words[i].length() >= word1.length() ? words[i] : word1;
            }
            if(i>0 && !isSame(word1, word2)) {
                result = Math.max(result, word1.length()*word2.length());
            }
            
        }
        
        return result;
    }
    private boolean isSame(String word1, String word2) {
        int[] count = new int[26];
        for (char w : word1.toCharArray()) {
            count[w - 'a'] = 1;
        }
        for (char w : word2.toCharArray()) {
            if (count[w - 'a'] == 1) return true;
        }
        return false;
    }

    private boolean isSame1(String word1, String word2) {
        for (char w : word1.toCharArray()) {
            if(word2.indexOf(w) != -1) return true;
        }
        return false;
    }

    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if(map.getOrDefault(target - numbers[i], -1) == -1) {
                map.put(numbers[i],i);
            } else {
                res[0] = map.get(target - numbers[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }

    //排序数组中两个数字之和
    public int[] twoSum2(int[] numbers, int target) {
        int i =0,j= numbers.length-1;
        while(i > j) {
            if(target - numbers[i] < numbers[j]) j--;
            if(target - numbers[i] > numbers[j]) i++;
            if(target - numbers[i] == numbers[j]) break;
        }
        return new int[] {i,j};
    }

    // 括号生成
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfsGenerateParenthesis(res,n,"",0,0);
        return res;
    }

    private void dfsGenerateParenthesis(List<String> res, int n, String path, int open, int close){
        if(open > n || close > open) return;
        if(path.length() == n*2) {
            res.add(path);
            return;
        }
        
        dfsGenerateParenthesis(res,n,path+"(",open+1,close);
        dfsGenerateParenthesis(res,n,path+")",open,close+1);
    }

    // 三数和为0
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums == null || nums.length < 3 ) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if(nums == null || nums.length < 3 ) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1, target = - nums[i];
            while(j < k) {
                if (nums[j] + nums[k] == target) { 
                    result.add(Arrays.asList(nums[i], nums[j], nums[k])); 
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < target) { 
                    j++;
                } else k--;
            }
        }
        return new ArrayList<>(result);
    }


    // 分割回文子字符串 
    public String[][] partition(String s) {
        List<String> temp = new ArrayList<>();
        Set<List<String>> ans = new HashSet<>();
        for (int i = 0; i < 2*s.length()-1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                addTemp(temp,s,left,right+1);
                left--;
                right++;
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        String[][] res = new String[ans.size()][];
        int i = 0;
        for(List<String> list: ans){
            res[i] = list.toArray(new String[list.size()]);
            i++; 
        }
        System.out.println(res);
        return res;
    }

    private void addTemp(List<String> temp2, String s, int left, int right) {
        String str = s.substring(left, right);
        String[] st = s.split("|");
        for (int i = 0; i < st.length; i++) {
            if(i==left) temp2.add(str);
            else {
                if(i>=left && i<right) continue; 
                temp2.add(st[i]);
            }
        }
    }


    //最长回文串
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int ans = 0;
        for(char c : s.toCharArray()){
            count[c]++;
        }
        for (int i = 0; i < count.length; i++) {
            ans += count[i] / 2 * 2;
            if(count[i] % 2 == 1 && ans%2 != 0) {
                ans++;
            }
        }
        return ans;
    }

    // 回文子串 0 0 1 0 1 | 0 0 1 2 0 1 2
    // 0 0  0 1  1 1  1 2  2 2  2 3
    public int countSubstrings(String s) {
        int ans = 0;
        for (int center = 0; center < 2*s.length()-1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    // 复原IP
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s== null || s.length()<4 || s.length()>12) return ans;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    if(checkIp(s,i,j,k)) {
                        String str = String.join(".", s.substring(0,i), s.substring(i, j), s.substring(j, k), s.substring(k, s.length()));
                        ans.add(str);
                    }
                }
            }
        }
        return ans;
    }

    private boolean checkIp(String s, int i, int j, int k) {
        String str1 = s.substring(0,i);
        if((str1.charAt(0) == '0' && str1.length() != 1) || Integer.parseInt(str1) > 255) return false;
        String str2 = s.substring(i, j);
        if((str2.charAt(0) == '0' && str2.length() != 1) || Integer.parseInt(str2) > 255) return false;
        String str3 = s.substring(j, k);
        if((str3.charAt(0) == '0' && str3.length() != 1) || Integer.parseInt(str3) > 255) return false;
        String str4 = s.substring(k, s.length());
        if((str4.charAt(0) == '0' && str4.length() != 1) || Integer.parseInt(str4) > 255) return false;
        return true;
    }

    // 和大于等于 target 的最短子数组
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start=0,end=0;
        int sum = 0;
        while(end < nums.length) {
            sum += nums[end];
            if(sum >= target) {
                while(start <= end) {
                    if(sum < target) break;
                    ans = Math.min(ans,end-start+1);
                    sum -= nums[start];
                    start++;
                }
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 爬楼梯的最少成本
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[dp.length - 1];
    }

    // 乘积最小数组 10 5 2 6  100
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int sum = 1;
        int left = 0,right = 0;

        for (int i = 0; i < nums.length; i++) {
            sum *= nums[right];
            while(left <= right && sum >= k) {
                sum /= nums[left++];
            }
            if(left <= right) ans += right - left + 1;
            right++;
        }
        return ans;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int ans = 0;
        int sum = 1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < k) {
                System.out.println(nums[i]);
                ans++;
            }
            sum *= nums[i];
            if(sum < k && i!=0) {
                System.out.println(sum);
                ans++;
            } else {
                while(sum >= k && sum != nums[i]) {
                    sum /= nums[start];
                    if(sum < k) {
                        System.out.println(sum);
                        ans++;
                    }
                    start++;
                }
            }
            if(i == nums.length-1) {
                while(start < nums.length-2) {
                    sum /= nums[start];
                    if(sum < k) {
                        System.out.println(sum);
                        ans++;
                    }
                    start++;
                }
            }
        }
        return ans;
    }

    // 房屋偷盗   [2,1,1,2]
    public int rob1(int[] nums) {
        if(nums.length < 2) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp.length == 2 ? Math.max(dp[0], dp[1]) : dp[nums.length - 1];
    }

    // 房屋偷盗   [2,1,1,2]
    public int rob(int[] nums) {
        int per = 0, cur = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            temp = cur;
            cur = Math.max(cur, per+nums[i]);
            per = temp;
        }
        return cur;
    }

    // 和为 k 的子数组 28,54,7,-70,22,65,-6
    public int subarraySum(int[] nums, int k) {
        int ans = 0,sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    // 0 和 1 个数相同的子数组
    public int findMaxLength(int[] nums) {
        int ans = 0, sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += i == 0 ? -1 : 1;
            if(map.containsKey(sum)) {
                ans = Math.max(ans,i-map.get(sum));
            } else {
                map.put(sum,i);
            }
        }
        return ans;
    }

    // 左右两边子数组的和相等
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if((leftSum - nums[i]) == (sum - leftSum)) 
                return i;
        }
        return -1;
    }

    //字符串中的变位词
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(),m = s2.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        if(n>m) return false;
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i)-'a']++;
            cnt2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(cnt1, cnt2)) return true;
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i)]++;
            cnt2[s2.charAt(i-n)]--;
            if(Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }

    //字符串中的所有变位词
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(),m = p.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        if(n<m) return res;
        for (int i = 0; i < m; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt2[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(cnt1, cnt2)) res.add(0);
        for (int i = m; i < n; i++) {
            cnt1[s.charAt(i) - 'a']++;
            cnt1[s.charAt(i-m) - 'a']--;
            if(Arrays.equals(cnt1, cnt2)) res.add(i-m+1);
        }
        return res;
    }

    //不含重复字符的最长子字符串 pwwkew
    public int lengthOfLongestSubstring1(String s) {
        int ans = 0,temp = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int l = map.getOrDefault(s.charAt(i),-1);
            map.put(s.charAt(i),i);
            temp = temp < i - l ? temp+1 : i-l;
            ans = Math.max(ans,temp);
        }
        return ans == 0 ? s.length() : ans;
    }

    //有效的回文
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() -1;
        if(s.length() == 0) return false;
        s = s.toLowerCase();
        while(l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)) ) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // 最多删除一个字符得到回文
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() -1;
        while(l <r) {
            if(s.charAt(l) != s.charAt(r)) {
                return dfsPalindeome(l+1, r, s) ||dfsPalindeome(l, r-1, s); 
            }
        }
        return true;
    }

    private boolean dfsPalindeome(int l,int r,String s) {
        if(l == r) return true;
        while(l < r) {
            if(s.charAt(l)!= s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public int countSubstrings1(String s) {
        int count = 0;
        int n = s.length() * 2 -1;
        for (int i = 0; i < n; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null) {
            while (curB != null ) {
                if(curA == curB) return curA;
                curB = curB.next;
            }
            curA = curA.next;
            curB = headB;
        }
        return null;                                                                                                                                                                                                                                                                                                                                                                                                       
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB) {
            curA = curA == null ? curB : curA.next;
            curB = curB == null ? curA : curB.next;
        }
        return curA;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode per = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = per;
            per = cur;
            cur = next;
        }
        return per;
    }

    // 回文链表
    public boolean isPalindromeListNode(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null) {
            stack.add(temp.val);
            temp = temp.next;
        }
        while(head!=null){
            if(head.val != stack.pop()) return false;
            head = head.next;
        }
        return true;
    }

    // 有效的变位词
    public boolean isAnagram(String s, String t) {
        if(s.equals(t) || s.length() != t.length()) return false;
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        return Arrays.equals(sch, tch);
    }

    // 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i);
            for(int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j);
                if(c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m+1][n+1];
    }


    char[] c1;
    // 字符串全排列
    public List<String> fullArray(String s){
        c1 = s.toCharArray();
        dfs(0);
        return res;
    }

    private void dfs(int x) { 
        if (x == c1.length -1) {
            res.add(String.valueOf(c1));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i = x; i < c1.length; i++) {
            if (set.contains(c1[i])) continue;
            set.add(c1[i]);
            swap1(i, x);
            dfs(x+1);
            swap1(i,x);
        }
    }

    private void swap1(int i, int x) {
        char temp = c1[i];
        c1[i] = c1[x];
        c1[x] = temp;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int index = 0; index < left - 1; index++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
    // 变位词组
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s:strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            ArrayList<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return  new ArrayList<List<String>>(map.values());
    }

    // 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            
        }
        return dp[nums.length-1];
    }


    //[9,9,9,9,9,9,9] [9,9,9,9]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode cur = l;
        int flag = 0;
        while(l1 != null || l2 != null){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum  = n1 + n2 + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
        }
        if(flag!=0) cur.next = new ListNode(flag);
        return l.next;
    }


    public int test1(int n) {
        int ans = 0;
        int res = n / 3;
        int temp = n % 3 + res;
        ans = res;
        if(temp<2) return ans;
        while(temp > 2) {
            res = temp / 3;
            ans += res;
            temp = res + temp % 3;
        }
         
        return temp == 2 ? ans+1 : ans ;
    }

    public List<Integer> test2(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size();) {
            int count = list.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j = i+1; j < i + count;j++) {
                if(j >= list.size()) break;
                if(temp.contains(list.get(j))) continue;
                temp.add(list.get(j));
            }
            Collections.sort(temp);
            ans.addAll(temp);
            i+=count;
        }
        return ans;
    }

    public List<Integer> test22(List<Integer> list) {
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0; i < list.size();) {
            int count = list.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j = i+1; j < i + count;j++) {
                if(j >= list.size()) break;
                if(temp.contains(list.get(j))) continue;
                temp.add(list.get(j));
            }
            Collections.sort(temp);
            ans.addAll(temp);
            i+=count;
        }
        return null;
    }

    public int test3(String n) {
        return Integer.parseInt(n, 16);
    }

    public int hexToDecimal(String hexnum){
        String hstring = "012345678ABCDEF";
        hexnum = hexnum.toUpperCase();
        int num = 0;
        for (int i = 0; i < hexnum.length(); i++) {
            char ch =hexnum.charAt(i);
            int n = hstring.indexOf(ch);
            num = 16*num + n;
        }
        return num;
    }

    private static int del(int num){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<num; i++) {
            queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty() && queue.size()>1) {
            if(count != 2) {
                queue.add(queue.poll());
                count++;
            } else {
                count = 0;
                queue.poll();
            }
        }
        return queue.poll();
    }
    
    private String wyx(String s){
        StringBuilder str = new StringBuilder();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if(str.indexOf(String.valueOf(c))==-1) {
                str.append(c);
            }
        }
        return str.toString();
    }

    private static String handleString(String s) {
        char[] cs = s.toCharArray();
        int head = 0,end =0;
        boolean flag = false;
        for(int i=0;i<cs.length;i++) {
            head = i;
            end = i;
            for(int j = i+1;j<cs.length;j++) {
                if(cs[i] > cs[j]) {
                    if(cs[end] > cs[j]) {
                        end =j;
                    }
                    flag = true;
                }
            }
            if(flag) break;
        }
        char temp = cs[end];
        cs[end] = cs[head];
        cs[head] = temp;
        return new String(cs);
    }

    private int handle(int count,List<Integer> list){
        count = 3;
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(15);
        list.add(23);
        list.add(12);
        int res = 0;
        int[] dp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if(i>=count) {
                res = res + list.get(i) - list.get(i-count);
                dp[i] = Math.max(dp[i-1], res);
            } else {
                res += list.get(i);
                dp[i] =res;
            }
        }
        return dp[dp.length-1];
    }

    // private int handle3(){
    //     String s = "abC124ACb";
    //     char[] ch = s.toCharArray();
    //     int res = 0;
    //     int[] dp = new int[ch.length];
    //     int count = 0;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int idx = 0;
    //     for (int i = 0; i < ch.length; i++) {
    //         if('a' <= ch[i] && ch[i] <= 'Z') {
    //             count++;
    //             map.put(i, map.getOrDefault(idx, idx));
    //             idx=i;
    //         }
    //         if(count<2) {
    //             res++;
    //             dp[i] = res;
    //         }
    //         // if(i>=count) {
    //         //     res = res + list.get(i) - list.get(i-count);
    //         //     dp[i] = Math.max(dp[i-1], res);
    //         // } else {
    //         //     res += list.get(i);
    //         //     dp[i] =res;
    //         // }
    //     }
    //     return dp[dp.length-1];
    // }


    private int handle3(){
        String s = "123455".toLowerCase();
        
        char[] ch = s.toCharArray();
        int ans = -1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ch.length; i++) {
            if('a' <= ch[i] && ch[i] <= 'z') {
                list.add(i);
            }
        }
        if(list.size()==1) return s.length();
        if(list.isEmpty() || list.size() == s.length()) return -1;
        ans = list.get(1);
        for (int i = 1; i < list.size()-1; i++) {
            ans = Math.max(ans, list.get(i+1) -  list.get(i));
        }
        ans = Math.max(ans, s.length() -  list.get(list.size()-2)-1);
        return ans;
    }

    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring2(String s) {
        s = "pwwkew";
        char[] ch = s.toCharArray();
        int res=0,temp=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            int idx = map.getOrDefault(ch[i], -1);
            map.put(ch[i], i);
            if(temp < i-idx) {
                temp = i-idx;
            } else {
            }
            temp = i-idx;
            res = Math.max(res, temp);
        }
        return res;
    }

    List<String> list = new ArrayList<>();
    char[] ch;
    public List<String> permutation1(String s) {
        s = "abc";
        ch = s.toCharArray();
        dfsPerTest(0);
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return list;
    }


    private void dfsPerTest(int i) {
        if(i==ch.length-1) {
            list.add(String.valueOf(ch));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int j = i; j < ch.length; j++) {
            if(set.contains(ch[j])) continue;
            set.add(ch[j]);
            swapPerText(i, j);
            dfsPerTest(i+1);
            swapPerText(i, j);
        }
    }

    private void swapPerText(int i, int x) {
        char temp = ch[i];
        ch[i] = ch[x];
        ch[x] = temp;
    }


    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 24*60) return 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String[] temp = timePoints.get(i).split(":");
            list.add(Integer.parseInt(temp[0]) *60 + Integer.parseInt(temp[1]));
        }
        Collections.sort(list);
        list.add(list.get(0)+24*60);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            ans = Math.min(list.get(i) - list.get(i-1), ans);
        }
        return ans;
    }

    public TreeNode pruneTree(TreeNode root) {
        TreeNode rNode = new TreeNode(0, new TreeNode(0), new TreeNode(1));
        root = dfsPruneTree(rNode);
        return root;
    }


    private TreeNode dfsPruneTree(TreeNode root) {
        if(root == null) return root;
        root.left = dfsPruneTree(root.left);
        root.right =  dfsPruneTree(root.right);
        if(root.right == null && root.left == null && root.val == 0) {
            return null;
        }
        return root;
    }

    // 整数拆分
    public int integerBreak(int n) {
        if(n<=3) return n -1;
        int a = n / 3, b = n % 3;
        if(b==1) return (int)Math.pow(3, a-1) * 4;
        if(b==2) return (int)Math.pow(3, a) * 2;
        return (int)Math.pow(3, a);
    }

    // N皇后
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList<>();
        List<Integer> coms = new ArrayList<>();
        List<Integer> r2l = new ArrayList<>();
        List<Integer> l2r = new ArrayList<>();
        backtrackSolveNQueens(0,n,resList,coms,r2l,l2r);
        return resList;
    }


    private void backtrackSolveNQueens(int row, int n, List<List<String>> resList, List<Integer> coms, List<Integer> r2l,
            List<Integer> l2r) {
        if(row == n) {
            resList.add(generateList(coms,n));
        }

        for(int i =0; i < n; i++){
            if(coms.contains(i)) continue;
            if(l2r.contains(i-row)) continue;
            if(r2l.contains(i+row)) continue;
            coms.add(i);
            l2r.add(i-row);
            r2l.add(i+row);
            backtrackSolveNQueens(row+1,n,resList,coms,r2l,l2r);
            coms.remove(coms.size() - 1);
            l2r.remove(l2r.size() - 1);
            r2l.remove(r2l.size() - 1);
        }

    }


    private List<String> generateList(List<Integer> coms, int n) {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[coms.get(i)] = 'Q';
            temp.add(new String(c));
        }
        return temp;
    }
    
    int n;
    int k1;
    List<List<Integer>> resCombine = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        k1 = k; this.n = n;
        dfs(1,new ArrayList<>());
        
        return resCombine;
    }

    private void dfs(int i, List<Integer> res2) {
        if(res2.size() == k1) {
            resCombine.add(new ArrayList<>(res2));
            return;
        }
        
        for (int j = i; j <= n; j++) {
            res2.add(j);
            dfs(j+1,res2);
            res2.remove(res2.size()-1);
        }
        
    }

    //栈的压入、弹出序列
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        pushed = new int[]{2,1,0};
        popped = new int[]{1,2,0};
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[j] == stack.peek()) {
                j++;
                stack.pop();
            }
        }
        
        for (; j < popped.length; j++) {
            if(popped[j] == stack.peek()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            res = temp.val;
            if(temp.right != null ) queue.add(temp.right);
            if(temp.left != null ) queue.add(temp.left);
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode temp = queue.poll();
                if(i == l - 1) {
                    list.add(temp.val);
                }
                if(temp.left != null ) queue.add(temp.left);
                if(temp.right != null ) queue.add(temp.right);
            }
        }
        return list;
    }

    // 最长回文子串
    public String longestPalindrome1(String s) {
        char[] c = s.toCharArray();
        int n = (2 * c.length) - 1;
        String ans = "";
        for (int i = 0; i < n; i++) {
            int left = i/2, right = left + i%2;
            while (left >= 0 && right < c.length && c[left] == c[right]) {
                left--;
                right++;
            }
            if(ans.length() < right - left - 1) {
                ans = s.substring(left+1,right);
                System.out.println(ans);
            }
        }
        return ans;
    }

    // 三数之和
    public List<List<Integer>> threeSum2(int[] nums) {
        // a + b + c =0
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i+1, k = nums.length -1, target = -nums[i];
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if(nums[j] + nums[k] < target){
                    j++;
                } else k--;
            }
        }
        return new ArrayList<>(ans);
    }

    // 全排列
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>());
        return ans;
    }


    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if(temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        }
        for (int j = 0; j < nums.length; j++) {
            if(temp.contains(j)) continue;
            temp.add(j);
            backtrack(nums,ans,temp);
            temp.remove(temp.size() - 1);
        }
    }

    // 滑动窗口最大值
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int temp = Integer.MIN_VALUE;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if(queue.peek() <= i - k) queue.poll();
            if(i >= k - 1) {
                res[i-k+1] = nums[queue.peek()];
            }
        }
        return res;
    }

    // 数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 括号生成
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        getParenthesis("",n,n,res);
        return res;
    }


    private void getParenthesis(String s, int l, int r, List<String> res) {
        if(l==0 && r==0) {
            res.add(s);
            return;
        }

        if(l>=r) {
            getParenthesis(s+"(",l-1,r,res);
        } else if(l<r){
            if(l>0) {
                getParenthesis(s+"(",l-1,r,res);
            }
            getParenthesis(s+")",l,r-1,res);
        }
    }

    //最小覆盖子串
    //s = "ADOBECODEBANC", t = "ABC" BANC"
    public String minWindow(String s, String t) {
        String res = "";
        int[] charmap = new int[58];
        // Arrays.fill(charmap,0);
        for(char c : t.toCharArray()) {
            charmap[c-'A']++;
        }
        int diff = t.length();
        int left = 0, right = 0, ans = Integer.MAX_VALUE;
        int dfssIdx = 26;
        while (right < s.length()) {
            charmap[s.charAt(right) - 'A']--;
            if(right - left + 1 >= diff && charmap[dfssIdx] <= 0) {
                dfssIdx = checkIndex(charmap);
                if(dfssIdx == 26) {
                    while(left < right && charmap[s.charAt(left) - 'A'] < 0) {
                        charmap[s.charAt(left++) - 'A']++;
                    }
                    if (right - left + 1 < ans) {
                        ans = right - left + 1;
                        res = s.substring(left, right+1);
                    } 
                }
            }
            right++;
        }
        return res;
    }

    private int checkIndex(int[] charmap) {
        for(int i = 0; i < charmap.length; i++) {
            if(charmap[i] > 0 ) return i;
        }
        return 26;
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stck = new Stack<>();
        while (root != null || !stck.isEmpty()) {
            while(root != null) {
                stck.push(root);
                root = root.left;
            }
            root = stck.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 层次遍历
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<n;i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(list);
        }

        return res;
    }

    // 删除链表的倒数第 n 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode frist = head;
        ListNode sencons = dummy;
        for(int i=0;i<n;i++) {
            frist = frist.next;
        }
        while(frist!=null) {
            frist = frist.next;
            sencons = sencons.next;
        }
        sencons.next = sencons.next.next;

        return dummy.next;
    }

    //链表中环的入口节点
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> s = new HashSet<ListNode>();
        while(head!=null) {
            if(s.contains(head)) {
                return head;
            }
            s.add(head);
            head = head.next;
        }
        return null;
    }

    // 链表中的两数相加
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(l1!=null || l2 !=null) {
            if(l1!=null) {
                s1.add(l1);
                l1 = l1.next;
            }
            if(l2!=null) {
                s2.add(l2);
                l2 = l2.next;
            }
        }
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int temp = carry;
            if(!s1.isEmpty()) {
                temp += s1.pop().val;
            }
            if(!s2.isEmpty()) {
                temp += s2.pop().val;
            }
            carry = temp/10;
            list.add(temp%10);
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        if(carry!=0) {
            head.next = new ListNode(carry);
            head = head.next;
        }
        for(int i = list.size()-1; i>=0; i--) {
            head.next = new ListNode(list.get(i));
            head = head.next;
        }
        
        return dummy.next;
    }

    // 二叉树每层的最大值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()) {
            int temp = Integer.MIN_VALUE;
            int n = q.size();
            for(int i = 0;i<n;i++) {
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                temp = Math.max(temp,node.val);
            }
            res.add(temp);
        }
        return res;
    }

    // 接雨水
    public int trap(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i- 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+ 1]);
        }
        for (int i = 1; i < maxRight.length-1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(min > height[i]) {
                sum += (min-height[i]);
            }
        }
        return sum;
    }

    
    //每组都出现的数字
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[1000];
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; i<nums[i].length; j++) {
                map[nums[i][j]]++;
            }
        }
        for(int i = 0; i < map.length; i++) {
            if(map[i]>=nums.length) res.add(map[i]);
        }
        return res;
    }

    // 电话号码字母组合
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrackCombinations(res,0,phoneMap,digits,new StringBuffer());
        return res;
        
    }

    private void backtrackCombinations(List<String> res, int i, Map<Character, String> phoneMap, String digits, StringBuffer s) {
        if (i == digits.length()) {
            res.add(new String(s));
            return;
        }
        String str = phoneMap.get(digits.charAt(i));
        int n = str.length();
        for (int j = 0; j < n; j++) {
            s.append(str.charAt(j));
            backtrackCombinations(res,i+1,phoneMap,digits,s);
            s.deleteCharAt(j);
        }
    }

    // 盛最多水的容器
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int l = 0, r = height.length - 1;
        while(l < r) {
            ans = height[l] < height[r] ? 
            Math.max(ans, (r-l) * height[l++]) : 
            Math.max(ans, (r-l) * height[r--]);
        }
        return ans;
    }

    // 最长有效括号
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) ans = Math.max(ans,right *2);
            else if (left < right) left = right = 0;
        }
        for (int i = s.length() -1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) ans = Math.max(ans, left *2);
            else if (left > right) left = right = 0;
        }
        return ans;
    }

    
    // public ListNode mergeKLists(ListNode[] lists) {

    // }


    // 重排链表
    public void reorderList(ListNode head) {
        ListNode pre = new ListNode();
        ListNode slow = pre;
        ListNode fast = pre;
        pre.next = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        ListNode rec_half = reverseListNode(half);
        ListNode cur = pre.next;
        while(rec_half!=null) {
            ListNode temp = cur.next;
            cur.next = rec_half;
            cur = cur.next;
            cur.next = temp;
            cur = cur.next;
            
        }
    }


    private ListNode reverseListNode(ListNode half) {
        ListNode pre = null;
        ListNode cur = half;
        while(cur!=null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
