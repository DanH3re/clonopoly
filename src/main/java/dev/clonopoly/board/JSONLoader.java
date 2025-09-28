package dev.clonopoly.board;

import dev.clonopoly.board.tile.*;
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
                String type = t.optString("type", "noop").toLowerCase();

                Tile tile;
                switch (type) {
                    case "go":
                        tile = new GoTile(name);
                        break;
                    case "street":
                        tile = new StreetTile(name);
                        break;
                    case "railroad":
                        tile = new RailroadTile(name);
                        break;
                    case "utility":
                        tile = new UtilityTile(name);
                        break;
                    case "tax":
                        tile = new TaxTile(name);
                        break;
                    case "jail":
                        tile = new JailTile(name);
                        break;
                    case "gotojail":
                        tile = new GoToJailTile(name);
                        break;
                    case "chance":
                    case "chest":
                        tile = new ChanceChestTile(type.equals("chance") ? CardType.CHANCE : CardType.COMMUNITY_CHEST);
                        break;
                    case "freeparking":
                        tile = new NoOpTile(name); // or a dedicated FreeParkingTile if you have it
                        break;
                    default:
                        tile = new NoOpTile(name);
                        break;
                }

                board.addTile(tile, position);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load board from " + filePath, e);
        }
    }
}
