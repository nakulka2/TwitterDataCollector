package com.twitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class TwitterStreamConsumer extends Thread {

	private static final String STREAM_URI = "https://stream.twitter.com/1.1/statuses/filter.json";

	public void run() {
		try {
			System.out
					.println("Starting Twitter public stream consumer thread.");

			// Enter your consumer key and secret below
			OAuthService service = new ServiceBuilder()
					.provider(TwitterApi.class).apiKey(Context.API_KEY)
					.apiSecret(Context.API_SECRET).build();

			// Set your access token
			Token accessToken = new Token(Context.ACCESS_TOKEN,
					Context.ACCESS_TOKEN_SECRET);
			// Let's generate the request
			System.out.println("Connecting to Twitter Public Stream");
			OAuthRequest request = new OAuthRequest(Verb.POST, STREAM_URI);
			request.addHeader("version", "HTTP/1.1");
			request.addHeader("host", "stream.twitter.com");
			request.setConnectionKeepAlive(true);
			request.addHeader("user-agent", "Twitter Stream Reader");
			request.addBodyParameter("track", "java,heroku,twitter");
			service.signRequest(accessToken, request);
			Response response = request.send();

			// Create a reader to read Twitter's stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getStream()));
			File file = new File(Context.FILE_PATH);
			BufferedWriter out = new BufferedWriter(new FileWriter(file));

			String line;
			while ((line = reader.readLine()) != null) {
				for (String element : Context.FILTER) {
					if (line.contains(element))
						System.out.println(line);
					out.write(line);
					out.newLine();
				}
				out.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}