// Allan Soto S.
//https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Stack.html
import java.util.Random;
import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    private Stack<Type> _stack;

    private Integer _capacity;

    public TheStack(Integer capacity) {
        _stack = new Stack<Type>();
        _capacity = capacity;
    }

    public Boolean push(Type item) {
        if (_stack.size() >= _capacity) {
            return false;
        }
        _stack.push(item);
        return true;
    }

    public Type pop() {
        if (_stack.empty()) {
            return null;
        }
        return _stack.pop();
    }

    public Type peek() {
        if (_stack.empty()) {
            return null;
        }
        return _stack.peek();
    }

    public Boolean empty() {
        return _stack.isEmpty();
    }

    public Integer size() {
        return _stack.size();
    }

    public String print() {
        return _stack.toString();
    }

    public static void main(String[] args) {
        var capacity = Integer.parseInt(args[0]);
        TheStackInterface<Double> stack = new TheStack<Double>(capacity);
        System.out.println("Pushing {capacity + 1}");
        var random = new Random();
        for (var n = 0; n <= capacity; n++) {
            var number = random.nextDouble();
            var pushed = stack.push(number);
            System.out.println(" ↳ push(" + number + ") → " + pushed);
        }
        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
        System.out.println();
        System.out.println("Popping {capacity + 1}");
        for (var n = 0; n <= capacity; n++) {
            var popped = stack.pop();
            System.out.println(" ↳ pop() → " + popped);
        }
        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}
