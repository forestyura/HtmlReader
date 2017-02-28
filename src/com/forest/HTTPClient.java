package com.forest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yuriy Vlasiuk on 28.02.2017.
 */
public class HTTPClient {
    private String inputUrl;
    private String html;
    private URL url;

    /**
     * The class constructor
     * @param url address where must download html
     */
    public HTTPClient(String url) {
        this.inputUrl = url;
        html = "";
    }

    /**
     * Loading html at the specified address in the constructor
     * @return downloaded html
     */
    public String downloadHtml() {
        try {
            url = new URL(inputUrl);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                html += line;
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return html;
    }

}
