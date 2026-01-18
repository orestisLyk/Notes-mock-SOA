package service;

import DAO.INoteDAO;
import core.exceptions.NoteNotFoundException;
import core.mapper.NoteMapper;
import dto.*;
import model.Note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NoteServiceImpl implements INoteService {
    private final INoteDAO dao;
    private static int nextId = 0;

    public NoteServiceImpl(INoteDAO dao) {
        this.dao = dao;
    }

    @Override
    public NoteReadOnlyDTO create(NoteCreationDTO dto) {
        Note note = NoteMapper.mapToModelEntity(dto, nextId++);
        return NoteMapper.mapToReadOnlyDTO(dao.saveOrUpdate(note));
    }

    @Override
    public NoteReadOnlyDTO update(NoteEditDTO dto) throws NoteNotFoundException {
        if(!dao.doesNoteExist(dto.id())) {
            throw new NoteNotFoundException("The Note you are trying to change does not exist. " + LocalDateTime.now());
        }
        Note note = NoteMapper.mapToModelEntity(dto);
        return NoteMapper.mapToReadOnlyDTO(dao.saveOrUpdate(note));
    }

    @Override
    public NoteDeletionResultDTO delete(NoteDeletionDTO dto) {
        return new NoteDeletionResultDTO(dao.remove(dto.id()));
    }

    @Override
    public List<NoteReadOnlyDTO> getNotesByTitle(NoteFilterByTitleDTO dto) {
        List<Note> notes = dao.filterByTitle(dto.Title());
        List<NoteReadOnlyDTO> output = new ArrayList<>();

        for (Note note : notes) {
            output.add(NoteMapper.mapToReadOnlyDTO(note));
        }
        return output;
    }

    @Override
    public List<NoteReadOnlyDTO> getAllNotes() {
        List<Note> notes = dao.getAllNotes();
        List<NoteReadOnlyDTO> output = new ArrayList<>();

        for (Note note : notes) {
            output.add(NoteMapper.mapToReadOnlyDTO(note));
        }
        return output;
    }
}
