package lambda.clients;

import java.io.IOException;

import lambda.clients.GetRepositoriesParams;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class GithubClient {

    // Constants
    protected enum Url {
        SEARCH_REPOS("/search/repositories");

        private String url;

        Url(String uri) { this.url = "https://api.github.com" + uri; }

        @Override public String toString() { return this.url; }
    }

    private final OkHttpClient client;

    private GithubClient(OkHttpClient client) {
        this.client = client;
    }

    public static GithubClient create(OkHttpClient client) {
        return new GithubClient(client);
    }

    public String getRepositories(GetRepositoriesParams params) {
        Request request = new Request.Builder()
            .url(Url.SEARCH_REPOS + params.toString())
            .get()
            .build();
        Response response;
        try {
            response = this.client.newCall(request).execute();
            return response.body().string();
        } catch(IOException ioe) { 
            return String.format( "{\"error\":\"%s\"}", ioe.toString());
        }
    }

}
