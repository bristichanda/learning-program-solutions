class Book {
    int bookId;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return bookId + " - \"" + title + "\" by " + author;
    }
}
