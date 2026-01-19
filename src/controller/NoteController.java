package controller;

import core.exceptions.NoteNotFoundException;
import core.exceptions.ValidationException;
import dto.*;
import service.INoteService;
import validation.NoteValidator;

import java.util.List;


public class NoteController {

    private final INoteService service;

    public NoteController(INoteService service) {
        this.service = service;
    }

    public NoteReadOnlyDTO createNote(String title, String text) throws ValidationException {
        NoteCreationDTO dto = new NoteCreationDTO(title, text);
        var errors = NoteValidator.validateCreationDTO(dto);

        //validation
        if (!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }
        //proceed to service
        return service.create(dto);
    }

    public NoteReadOnlyDTO editNote(int id, String title, String text) throws ValidationException, NoteNotFoundException {
        NoteEditDTO dto = new NoteEditDTO(id, title, text);
        var errors = NoteValidator.validateEditDTO(dto);

        //validation
        if(!errors.isEmpty()) {
            throw new ValidationException(errors.toString());
        }

        //proceed to service
        return service.update(dto);
    }

    public NoteDeletionResultDTO deleteNote(int id) throws NoteNotFoundException {
        NoteDeletionDTO dto = new NoteDeletionDTO(id);
        NoteDeletionResultDTO returnDto = service.delete(dto);
        if(!returnDto.deleted()) {
            throw new NoteNotFoundException("The note with id: " + id + " does not exist. ");
        }
        return returnDto;
    }

    public List<NoteReadOnlyDTO> filterNotesByTitle(String title) {
        NoteFilterByTitleDTO dto = new NoteFilterByTitleDTO(title);
        return service.getNotesByTitle(dto);
    }

    public List<NoteReadOnlyDTO> getAllNotes() {
        return service.getAllNotes();
    }


}
