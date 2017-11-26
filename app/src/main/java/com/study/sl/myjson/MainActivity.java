package com.study.sl.myjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonData = "[{'id':'5','version':'5.5','name':'Clash of Clans'}," +
                "{'id':'6','version':7.0','name':'Boom Beach'}," +
                "{'id':'7','version':3.5','name':'Clash Royale'}]";

        parseJSONWithJSONObject(jsonData);
        parseJSONWithGSON(jsonData);
    }

    private void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String version = jsonObject.getString("version");
                String name = jsonObject.getString("name");

                Log.d("JSONObject", "id is " + id);
                Log.d("JSONObject", "version is " + version);
                Log.d("JSONObject", "name is " + name);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());
        for (App app : appList) {
            Log.d("GSON", "id is " + app.getId());
            Log.d("GSON", "version is " + app.getVersion());
            Log.d("GSON", "name is " + app.getName());
        }
    }

    class App {
        String id;
        String version;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
