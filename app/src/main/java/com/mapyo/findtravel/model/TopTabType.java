package com.mapyo.findtravel.model;

public enum TopTabType {

    // todo 特集用のjsonを作る
    FEATURE(0, "特集", "new_arrival.json"),
    NEW_ARRIVAL(1, "新着", "new_arrival.json"),
    LOVELY_VIEW(2, "絶景", "lovely_view.json"),
    GOURMET(3, "グルメ", "gourmet.json"),
    OKINAWA(4, "沖縄", "okinawa.json"),
    TOKYO(5, "東京", "tokyo.json"),
    KYOTO(6, "京都", "kyoto.json");


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
