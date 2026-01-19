package validation;

import dto.NoteCreationDTO;
import dto.NoteEditDTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class NoteValidator {

    private NoteValidator() {}

    public static Map<String, String> validateCreationDTO(NoteCreationDTO dto) {
        Map<String, String> errors = new HashMap<>();

        if(dto.text().isEmpty()) {
            errors.put("text", "Text field is empty.Please enter a note with non-empty text. " + LocalDateTime.now());
        }
        return errors;
    }

    public static Map<String, String> validateEditDTO(NoteEditDTO dto) {
        Map<String, String> errors = new HashMap<>();

        if(dto.text().isEmpty()) {
            errors.put("text", "Text field is empty.Please enter a note with non-empty text. " + LocalDateTime.now());
        }
        return errors;
    }
}
