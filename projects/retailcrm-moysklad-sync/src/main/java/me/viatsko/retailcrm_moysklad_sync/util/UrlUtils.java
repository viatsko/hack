/*-
 * -\-\-
 * retailcrm-moysklad-sync
 * --
 * Copyright (C) 2017 Valerii Iatsko
 * --
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * -/-/-
 */

package me.viatsko.retailcrm_moysklad_sync.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.logging.Logger;

public class UrlUtils {
    private static final String USER_AGENT = "Mozilla/5.0";

    private static final Logger log = Logger.getLogger(UrlUtils.class.getName());

    public static String getUrl(String urlString) throws Exception {
        return getUrl(urlString, "", "");
    }

    public static String postUrl(String urlString, String postJsonData) throws Exception {
        return postUrl(urlString, "", "", postJsonData);
    }

    /*
     * From https://stackoverflow.com/questions/7467568/parsing-json-from-url
     */
    public static String getUrl(String urlString, String username, String password) throws Exception {
        BufferedReader reader = null;

        int retries = 0;

        boolean completed = false;

        while (!completed) {
			try {
				retries++;

				completed = true;

				URL url = new URL(urlString);

				HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

				httpsURLConnection.setConnectTimeout(20000);

				if (username.length() > 0) {
					String encoded = Base64.getEncoder()
							.encodeToString((username + ":" + password)
									.getBytes(StandardCharsets.UTF_8));

					httpsURLConnection.setRequestProperty("Authorization", "Basic " + encoded);
				}

				httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);

				reader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));

				StringBuilder buffer = new StringBuilder();

				int read;

				char[] chars = new char[1024];

				while ((read = reader.read(chars)) != -1) {
					buffer.append(chars, 0, read);
				}

				return buffer.toString();
			} catch (Exception e) {
				completed = false;
				System.out.println(e.getMessage());

				if (retries > 5) {
					System.out.println("Too many retries. API is down.");
					System.exit(1);
				}
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		}

		return "";
    }

	/*
     * From https://www.java2blog.com/how-to-send-http-request-getpost-in-java
     */
    private static String genericRestUpdate(String method, String urlString, String username, String password, String postJsonData) throws Exception {
    	boolean completed = false;

    	int retries = 0;

    	while (!completed) {
    		try {
    			retries++;
    			completed = true;
				URL obj = new URL(urlString);
				HttpsURLConnection httpsURLConnection = (HttpsURLConnection) obj.openConnection();

				httpsURLConnection.setConnectTimeout(20000);

				// Setting basic post request
				httpsURLConnection.setRequestMethod(method);
				httpsURLConnection.setRequestProperty("User-Agent", USER_AGENT);
				httpsURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
				httpsURLConnection.setRequestProperty("Content-Type", "application/json");

				if (username.length() > 0) {
					String encoded = Base64.getEncoder()
							.encodeToString((username + ":" + password)
									.getBytes(StandardCharsets.UTF_8));

					httpsURLConnection.setRequestProperty("Authorization", "Basic " + encoded);
				}

				httpsURLConnection.setDoOutput(true);

				DataOutputStream wr = new DataOutputStream(httpsURLConnection.getOutputStream());

				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));

				bufferedWriter.write(postJsonData);

				bufferedWriter.close();

				wr.close();

				try {
					int responseCode = httpsURLConnection.getResponseCode();
					log.info("Sending '" + method + "' request to URL : " + urlString);
					log.info("Post Data : " + postJsonData);
					log.info("Response Code : " + responseCode);

					BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));

					String output;

					StringBuilder response = new StringBuilder();

					while ((output = in.readLine()) != null) {
						response.append(output);
					}

					in.close();

					return response.toString();
				} catch (Exception e) {
					BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));

					String output;

					StringBuilder response = new StringBuilder();

					while ((output = in.readLine()) != null) {
						response.append(output);
					}

					System.out.println(response);

					in.close();

					return "";
				}
			} catch (Exception e) {
    			completed = false;

				System.out.println(e.getMessage());

				if (retries > 5) {
					System.out.println("Too many retries. API is down.");
					System.exit(1);
				}
			}
		}

		return "";
	}

    public static String postUrl(String urlString, String username, String password, String postJsonData) throws Exception {
        return genericRestUpdate("POST", urlString, username, password, postJsonData);
    }

	public static String putUrl(String urlString, String username, String password, String postJsonData) throws Exception {
		return genericRestUpdate("PUT", urlString, username, password, postJsonData);
	}
}
