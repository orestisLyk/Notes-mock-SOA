package DAO;

import model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NoteDAOImpl implements INoteDAO {
    private final List<Note> list = new ArrayList<>();

    @Override
    public Note saveOrUpdate(Note note) {
        int index = list.indexOf(note);
        if(index == -1) {
            list.add(note);
            return note;
        }

        list.set(index, note);
        return list.get(index);
    }

    @Override
    public boolean remove(int id) {
        int index;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doesNoteExist(int id) {
        return list.stream().anyMatch(note -> note.getId() == id);
    }

    @Override
    public Optional<Note> findById(int id) {
        return list.stream()
                .filter(note -> note.getId() == id)
                .findFirst();
    }

    @Override
    public List<Note> getAllNotes() {
        return List.copyOf(list);
    }

    @Override
    public List<Note> filterByTitle(String title) {
        List<Note> notes = new ArrayList<>();
        for(Note note : list) {
            if(note.getTitle().equals(title)) {
                notes.add(note);
            }
        }
        return notes;
    }
}
