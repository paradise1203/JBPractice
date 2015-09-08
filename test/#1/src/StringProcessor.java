import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringProcessor {

    private static class CharInf {
        int count;
        int index;

        public CharInf(int count, int index) {
            this.count = count;
            this.index = index;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void incrementCount() {
            count++;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    //Порядок элементов из LinkedHashMap должен сохраниться, поэтому подходит первый встречающийся.
    private static int findIndex(Map<Character, CharInf> symbols) {
        Iterator<CharInf> it = symbols.values().iterator();
        boolean found = false;
        while (it.hasNext()) {
            CharInf charInf = it.next();
            if (charInf.getCount() == 1)
                return charInf.getIndex();
        }
        return -1;
    }

    private static int process(String s) {
        Map<Character, CharInf> symbols = new LinkedHashMap<>();
        int index = 0;
        while (index < s.length()) {
            Character c = s.charAt(index++);
            CharInf charInf = symbols.get(c);
            if (charInf != null)
                charInf.incrementCount();
            else
                symbols.put(c, new CharInf(1, index - 1));
        }
        return findIndex(symbols);
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(process(s));
    }

}
