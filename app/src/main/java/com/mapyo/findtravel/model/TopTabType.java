package com.mapyo.findtravel.model;

public enum TopTabType {

    NEW_ARRIVAL(0, "新着", "new_arrival.json"),
    LOVELY_VIEW(1, "絶景", "lovely_view.json"),
    GOURMET(2, "グルメ", "gourmet.json"),
    OKINAWA(3, "沖縄", "okinawa.json"),
    TOKYO(4, "東京", "tokyo.json"),
    KYOTO(5, "京都", "kyoto.json");


    private int id;
    private String name;
    private String jsonFile;

    TopTabType(int id, String name, String jsonFile) {
        this.id = id;
        this.name = name;
        this.jsonFile = jsonFile;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJsonFile() {
        return jsonFile;
    }

    public static TopTabType getTopTabType(int id) {
        for (TopTabType type : TopTabType.values()) {
            if(type.getId() == id) {
                return type;
            }
        }
        return null;
    }
}
