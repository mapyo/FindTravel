package com.mapyo.findtravel.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.mapyo.findtravel.contract.TopicListContract;
import com.mapyo.findtravel.model.JsonCreator;
import com.mapyo.findtravel.model.entity.TopicListResponse;

import java.io.IOException;


public class TopicListPresenter {
    private static final String JSON_FILE = "topic.json";
    private final TopicListContract.View view;

    // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
    private Context context;

    public TopicListPresenter(TopicListContract.View view, Context context) {
        this.view = view;
        // 本当はcontextは持たせなくないが、assetからjsonファイルを読み込む時に必要なので渡している
        this.context = context;
    }

    public void fetchTopic() {
        // ファイルからjson取得
        // 本来は通信してjsonを取得したい
        String jsonString;
        try {
            jsonString = JsonCreator.readFromAssets(context, JSON_FILE);
        } catch (IOException e) {
            e.printStackTrace();
            jsonString = null;
            view.showError();
        }

        TopicListResponse responses = new Gson().fromJson(jsonString, TopicListResponse.class);
        view.showPickupFeatures(responses.getPickupFeatures());
        view.showFeatures(responses.getFeatures());
    }
}
