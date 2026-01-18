package service;

import core.exceptions.NoteNotFoundException;
import dto.*;
import model.Note;

import java.util.List;
import java.util.Optional;

public interface INoteService {
    NoteReadOnlyDTO create(NoteCreationDTO dto);
    NoteReadOnlyDTO update(NoteEditDTO dto) throws NoteNotFoundException;
    NoteDeletionResultDTO delete(NoteDeletionDTO dto);

    List<NoteReadOnlyDTO> getNotesByTitle(NoteFilterByTitleDTO dto);
    List<NoteReadOnlyDTO> getAllNotes();
}
