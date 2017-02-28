package com.forest;

/**
 * Created by Yuriy Vlasiuk on 28.02.2017.
 */
public class Application {
    /**
     * The entry point to the application
     * @param args URL that needs to be passed as an argument when you run
     */
    public static void main(String args[]) {
        String url = "";
        try {
            url = args[0];
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("You must pass a URL when you start");
            System.exit(0);
        }

        if (!URLValidator.validate(url)) {
            System.out.println("Pass the string '" + url + "' is not URL");
            System.exit(0);
        }

        HTTPClient httpClient = new HTTPClient(url);
        String html = httpClient.downloadHtml();

        if(!HTMLValidator.validate(html)) {
            System.out.println("This url '" + url + "' does not contain HTML content");
            System.exit(0);
        }

        TextWorker textWorker = new TextWorker(html);
        System.out.println("The total number the word:" + textWorker.getNumberOfWords());
        System.out.println("Wordlist: \n" + textWorker.getListOfWords());

    }
}
