package com.yalin.files;


import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * jinyalin
 * on 2017/5/4.
 */
public class FileServer {

  private static final String INDEX_SOURCE_FILE = "./Index.html";

  public static void main(String[] args) {
    staticFiles.externalLocation("apks");
    port(80);
    get("/", (request, response) ->
        parseHtml()
    );
  }

  private static String htmlString;

  private static synchronized String parseHtml() {
    if (htmlString != null && htmlString.length() >= 0) {
      return htmlString;
    }

    File file = new File(INDEX_SOURCE_FILE);
    BufferedReader bufferedReader = null;
    try {
      FileInputStream is = new FileInputStream(file);
      InputStreamReader isr = new InputStreamReader(is, "UTF-8");
      bufferedReader = new BufferedReader(isr);
      StringBuilder result = new StringBuilder();
      for (String line = bufferedReader.readLine();
          line != null && line.length() > 0;
          line = bufferedReader.readLine()) {
        result.append(line)
            .append("\r\n");
      }
      htmlString = result.toString();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (Exception ignored) {
      }
    }
    return htmlString;
  }
}
