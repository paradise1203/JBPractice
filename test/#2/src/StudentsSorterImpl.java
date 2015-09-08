import java.io.*;
import java.util.*;

public class StudentsSorterImpl implements StudentsSorter {

    private Map<String, List<String>> groups;

    public StudentsSorterImpl(Map<String, List<String>> groups) {
        this.groups = groups;
    }

    private void traverseAndAdd(String s) {
        String name = "",
                group = "";
        boolean isName = true;
        int index = 0;
        while (index < s.length()) {
            Character c = s.charAt(index++);
            if (c == ':') {
                isName = false;
                continue;
            }
            if (isName)
                name += c.toString();
            else
                group += c.toString();
        }
        List<String> names = groups.get(group);
        if (names != null)
            names.add(name);
        else {
            names = new ArrayList<>();
            names.add(name);
            groups.put(group, names);
        }
    }

    private void sortNames() {
        Iterator<List<String>> it = groups.values().iterator();
        while (it.hasNext()) {
            List<String> names = it.next();
            String[] mas = new String[names.size()];
            MergeSort.runMergeSort(names.toArray(mas));
            for (int i = 0; i < mas.length; i++) {
                names.remove(i);
                names.add(i, mas[i]);
            }
        }
    }

    private List<String> sortGroups() {
        Collection<String> col = groups.keySet();
        List<String> list = new ArrayList<>();
        Iterator<String> it = col.iterator();
        while (it.hasNext())
            list.add(it.next());
        Collections.sort(list, (String o1, String o2) -> {
            if (groups.get(o1).size() < groups.get(o2).size())
                return 1;
            else if (groups.get(o1).size() > groups.get(o2).size())
                return -1;
            else
                return 0;
        });
        return list;
    }

    private void printRes(List<String> groupList, BufferedWriter out) {
        Iterator<String> it = groupList.listIterator();
        while (it.hasNext()) {
            String group = it.next();
            String res = group + ":";
            Iterator<String> it2 = groups.get(group).iterator();
            while (it2.hasNext()) {
                String name = it2.next();
                res += name;
                if (it2.hasNext())
                    res += ", ";
            }
            try {
                out.write(res + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(InputStream input, OutputStream output) {
        Scanner in = new Scanner(input);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(output));
        while (in.hasNextLine()) {
            String s = in.nextLine();
            traverseAndAdd(s);
        }
        sortNames();
        List<String> groupList = sortGroups();
        printRes(groupList, out);
    }

}
