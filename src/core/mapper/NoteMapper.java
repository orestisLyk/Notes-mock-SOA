package core.mapper;

import dto.NoteCreationDTO;
import dto.NoteEditDTO;
import dto.NoteReadOnlyDTO;
import model.Note;

public class NoteMapper {

    private NoteMapper() {}

    public static NoteReadOnlyDTO mapToReadOnlyDTO(Note note) {
        return new NoteReadOnlyDTO(note.getId(), note.getTitle(), note.getText());
    }

    public static Note mapToModelEntity(NoteCreationDTO dto, int id) {
        return new Note(id, dto.text(), dto.title());
    }

    public static Note mapToModelEntity(NoteEditDTO dto) {
        return new Note(dto.id(), dto.text(), dto.title());
    }
}
