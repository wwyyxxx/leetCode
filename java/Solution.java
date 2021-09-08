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

import bean.*;
/*
 * @Author: Tungbo
 * @Date: 2021-07-06 14:44:26
 * @LastEditTime: 2021-08-03 15:53:42
 * @LastEditors: Tungbo
 * @Description: leecode: leetcode记录
 */
public class Solution {

    public static void main(String[] args) {}


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
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
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
            dp[i] = Math.min(Math.min(n2, n3), n5);a
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
}