import java.util.*;

public class NestedIteratorTest {

    public static void main(String[] args){


        LinkedList<Object> o = new LinkedList<>();
        o.add(new ArrayList<String>(Arrays.asList("qwe11", "qwe12", "qwe13")));
        o.add(new LinkedList<Double>(Arrays.asList(1234.0, 5678.0)));
        o.add(new LinkedList<String>(Arrays.asList("qwe21", "qwe22")));
        o.add("qwe31");
        o.add(new String[]{"qwe41", "qwe42","qwe43"});
        o.add(new Integer[]{11111, 222222,333333});
        String[][] sss= new String[][]{{"asd1","asd2"},{"asd3"}};

        NestedIterator it = new NestedIterator(String.class, o, "======", "qweasd", sss);

        for (Object s: it) {
            System.out.println(s);
            System.out.flush();
        }
    }

}

