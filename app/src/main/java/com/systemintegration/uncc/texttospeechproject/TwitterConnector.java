package com.systemintegration.uncc.texttospeechproject;

import android.os.AsyncTask;
import android.provider.SyncStateContract;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.SearchResource;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Stephen on 3/22/2018.
 */

public class TwitterConnector extends AsyncTask<String, Void, String>{

     Twitter twitter;

    @Override
    protected String doInBackground(String... params) {
/*        HttpURLConnection connection = null;
        String result = "";
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;*/

        try {
//            URL url = new URL(params[0] );
//            connection = (HttpURLConnection) url.openConnection();

            if(twitter==null) {
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(false)
                        .setOAuthConsumerKey("gISje5cctQNKQi4WMHZMaEt7R")
                        .setOAuthConsumerSecret("kKkpE68ZHnTu0URE0VKtSRDEIsGQXlJLfAUb83T393Dw6HY72H")
                        .setApplicationOnlyAuthEnabled(true)
                        .setHttpConnectionTimeout(5000)
                        .setHttpReadTimeout(5000)
                        .setHttpStreamingReadTimeout(5000);
                twitter = new TwitterFactory(cb.build()).getInstance();
                twitter.getOAuth2Token();
            }

            Query query = new Query();
            query.setQuery("Nasa");
            query.setLang("en");
            query.setCount(10);

            QueryResult result = twitter.search(query);

            return result.toString();

            /*
            --header 'authorization: OAuth oauth_consumer_key="consumer-key-for-app",
             oauth_nonce="generated-nonce", oauth_signature="generated-signature",
             oauth_signature_method="HMAC-SHA1", oauth_timestamp="generated-timestamp",
             oauth_token="access-token-for-authed-user", oauth_version="1.0"'
             */

            /*connection.connect();

            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }*/

            //result = sb.toString();


        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return "EMPTY RESULT!";
    }
}
