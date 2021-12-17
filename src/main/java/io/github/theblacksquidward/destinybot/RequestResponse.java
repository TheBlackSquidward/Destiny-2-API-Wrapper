package io.github.theblacksquidward.destinybot;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.theblacksquidward.destinybot.utils.JsonUtils;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestResponse {

    //TODO document

    private final HttpRequest httpRequest;
    private final HttpClient httpClient;

    public RequestResponse(HttpRequest httpRequest) {
        httpClient = HttpClient.newHttpClient();
        this.httpRequest = httpRequest;
    }

    /**
     * A method which returns the given request into its string.
     * @return A string of the {@link HttpRequest}
     */
    public String getResponseAsString() {
        try {
            return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApplyAsync(HttpResponse::body).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }
    public String getResponseAsPrettyString() {
        return JsonUtils.getJsonElementAsPrettyString(getResponseAsJsonElement());
    }
    public JsonObject getResponseAsJsonObject() {
        return JsonParser.parseString(getResponseAsString()).getAsJsonObject();
    }
    public JsonElement getResponseAsJsonElement() {
        return DestinyBot.GSON.fromJson(getResponseAsString(), JsonElement.class);
    }
    public DestinyAPIResponse getDestinyAPIResponse() {
        return new DestinyAPIResponse(getResponseAsJsonObject());
    }

    @Override
    public String toString() {
        //TODO change this to output some different data
        return "RequestResponse{" +
                "httpRequest=" + httpRequest +
                ", httpClient=" + httpClient +
                '}';
    }

}
