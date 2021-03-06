public class WiseSayingTable {
    private String baseDir;

    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }

    public void save(WiseSaying wiseSaying) {
        Util.file.mkdir("%s/wise_saying".formatted(baseDir));
        String body = "내용";
        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(baseDir, wiseSaying.id), body);
    }

    public void save(String quote, String author) {
        int id = getLastId() + 1;
        
        WiseSaying wiseSaying = new WiseSaying(id, quote, author);
        save(wiseSaying);

        saveLastId(id);
    }

    private void saveLastId(int id) {
        Util.file.saveToFile("%s/wise_saying/last_id.txt".formatted(baseDir), id + "");
    }

    private int getLastId() {
        String lastId = Util.file.readFromFile("%s/wise_saying/last_id.txt".formatted(baseDir), "");

        if (lastId.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(lastId);
    }
}
