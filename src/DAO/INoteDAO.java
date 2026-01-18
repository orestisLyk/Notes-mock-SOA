package DAO;

import model.Note;

import java.util.List;
import java.util.Optional;

public interface INoteDAO {

    Note saveOrUpdate(Note note);
    boolean remove(int id);
    Optional<Note> findById(int id);
    boolean doesNoteExist(int id);
    List<Note> getAllNotes();
    List<Note> filterByTitle(String title);
}
