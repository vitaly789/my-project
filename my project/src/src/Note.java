package src;

import java.time.Instant;

public class Note {

    private final String name; // final - не изменим поле
    private String text;
    private final String author;
    private final Instant creationDate;
    private Instant updateDate;

    public Note(String name, String text) {
        this.name = name;
        this.text = text;

        author = null;
        creationDate = Instant.now();
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
        this.updateDate = Instant.now();
    }

    public String getAuthor() {
        return this.author;
    }

    public Instant getCreationDate() {
        return this.creationDate;
    }

    public Instant getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

}
