/*
 * @Author: Tungbo
 * @Date: 2021-07-06 14:44:26
 * @LastEditTime: 2021-07-14 10:29:51
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
        if(nums.length() == 0) return nums;
        int left = 0, right = nums.length();
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
    public int[] spiralOrder(int[][] matrix) {
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
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}