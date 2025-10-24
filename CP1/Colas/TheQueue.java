// Allan Soto S.
// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<Type>();
    }

    public void enqueue(Type item) {
        _queue.add(item);
    }

    public Type dequeue() {
        return _queue.pollFirst();
    }

    public Type getFront() {
        return _queue.peekFirst();
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    public int getSize() {
        return _queue.size();
    }

    public String[] getCodons() {
        int size = _queue.size();
        String[] codons = new String[size / 3];
        for (int i = 0; i < codons.length; i++) {
            StringBuilder codon = new StringBuilder();
            codon.append(_queue.poll());
            codon.append(_queue.poll());
            codon.append(_queue.poll());
            codons[i] = codon.toString();
        }
        return codons;
    }

    public String print() {
        return _queue.toString();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
        System.out.println("Uso: java TheQueue <cantidad_nucleotidos>");
        System.out.println("La cantidad debe ser un múltiplo de 3");
        return;
    }
    
    var amount = Integer.parseInt(args[0]); 
    if (amount % 3 != 0) {
        System.out.println("Error: La cantidad debe ser múltiplo de 3");
        return;
    }
    
    String[] nucleotides = {"A", "C", "G", "T"};
    TheQueueInterface<String> queue = new TheQueue<String>();
    var random = new Random();
    
    for (; amount > 0; amount--) {
        var index = random.nextInt(4);
        var amino = nucleotides[index];
        queue.enqueue(amino);
    }
    
    System.out.println("Filled {full}");
    System.out.println(" ↳ print() → " + queue.print());
    System.out.println("   ↳ getFront() → " + queue.getFront());
    System.out.println("   ↳ getSize() → " + queue.getSize());
    System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));
    System.out.println("\nEnd {empty}");
    System.out.println(" ↳ print() → " + queue.print());
    System.out.println("   ↳ getFront() → " + queue.getFront());
    System.out.println("   ↳ getSize() → " + queue.getSize());
    System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
}
}