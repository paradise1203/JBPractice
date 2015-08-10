package data;

import java.util.LinkedList;
import java.util.List;

public class Database {

    static List<Note> notes;

    static {
        notes = new LinkedList<Note>();
        notes.add(new Note("8:00 - brushing teeth"));
        notes.add(new Note("8:10 - training"));
        notes.add(new Note("8:30 - breakfast"));
    }

    public static List<Note> getNotes() {
        return notes;
    }

    public static void addNote(String txt) {
        notes.add(new Note(txt));
    }
}
