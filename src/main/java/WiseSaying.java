public class WiseSaying {
    int id;
    String quote;
    String author;

    WiseSaying(int id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "id = " + id +
                ", quote = '" + quote + '\'' +
                ", author = '" + author + '\'' +
                '}';
    }
}
