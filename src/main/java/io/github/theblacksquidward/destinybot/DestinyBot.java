package io.github.theblacksquidward.destinybot;

import com.google.gson.Gson;

public class DestinyBot {

    public static final Gson GSON = new Gson();

    public static void main(final String[] args) {
        var test = RequestHandler.makeAPIRequest(RequestHandler.MANIFEST_URL);
        System.out.println(test);
    }

}
