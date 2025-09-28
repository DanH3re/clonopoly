package dev.clonopoly.board;

import dev.clonopoly.board.tile.NoOpTile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONLoader {
    private static JSONLoader instance = null;

    private JSONLoader() {}

    public static JSONLoader getInstance() {
        if (instance == null) {
            instance = new JSONLoader();
        }
        return instance;
    }

    public void loadBoard(String filePath) {
        try {
            String json = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            JSONObject root = new JSONObject(json);
            JSONArray tiles = root.getJSONArray("tiles");

            Board board = Board.getInstance();

            for (int i = 0; i < tiles.length(); i++) {
                JSONObject t = tiles.getJSONObject(i);

                int position = t.getInt("position");
                String name = t.optString("name", "N/A");

                board.addTile(new NoOpTile(name), position);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load board from " + filePath, e);
        }
    }
}
