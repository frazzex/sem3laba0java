import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PrimesGeneratorTest {
    public static void print(ArrayList<Integer> array, int n) {
        if (n == 0 || n > array.size()) return;

        List<Integer> slice = array.subList(0, n);
        Iterator<Integer> it = slice.iterator();

        System.out.println("Первые N элементов: ");
        while(it.hasNext()) System.out.println(it.next());

        Collections.reverse(slice);

        Iterator<Integer> it2 = slice.iterator();
        System.out.println("Первые N элементов в обратном порядке: " );
        while(it2.hasNext()) System.out.println(it2.next());


    }
}
