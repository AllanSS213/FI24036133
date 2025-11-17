import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {
        if (_tree[0] == null) {
            _tree[0] = value;
            return;
        }
        
        int current = 0;
        while (current < _tree.length) {
            if (value < _tree[current]) {
                int left = 2 * current + 1;
                if (left >= _tree.length) break;
                if (_tree[left] == null) {
                    _tree[left] = value;
                    break;
                } else {
                    current = left;
                }
            } else {
                int right = 2 * current + 2;
                if (right >= _tree.length) break;
                if (_tree[right] == null) {
                    _tree[right] = value;
                    break;
                } else {
                    current = right;
                }
            }
        }
        
        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { 
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }

    public void preOrderTraversal() { 
        System.out.print(" ↳ preOrderTraversal → ");
        
        if (_tree[0] == null) {
            System.out.println();
            return;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(_tree[current] + " ");
            
            int right = 2 * current + 2;
            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }
            
            int left = 2 * current + 1;
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
        }
        
        System.out.println();
    }

    public void postOrderTraversal() { 
        System.out.print(" ↳ postOrderTraversal → ");
        
        if (_tree[0] == null) {
            System.out.println();
            return;
        }
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        stack.push(0); 
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            result.push(current);
            
            int left = 2 * current + 1;
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
            
            int right = 2 * current + 2;
            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }
        }
        
        while (!result.isEmpty()) {
            System.out.print(_tree[result.pop()] + " ");
        }
        
        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}
