package model;

import java.util.Objects;

public class Note {
    private final int id;
    private String text;
    private String title;

    public Note(int id, String text, String title) {
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Note note)) return false;
        return id == note.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                ", text: '" + text +
                ", title: '" + title;
    }
}
