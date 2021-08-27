package com.example.validation.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.net.URL;
import java.util.Objects;

public class ValidateAddress {

    private static final String email = "email";
    private static final double threshold = 0.99;
    private static final String flags = "m";

    public static String validate(String ip) throws Exception {

        String website = "http://check.getipintel.net/check.php?ip=" + ip + "&contact=" + email + "&flags=" + flags;

        OkHttpClient client = new OkHttpClient();

        URL url = new URL(website);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        String content = "";

        try (Response response = client.newCall(request).execute()) {
            content = Objects.requireNonNull(response.body()).string();
        }

        double output = Double.parseDouble(content);

        String result = "";

        if (content.equals("-2"))
            result = "Invalid IP address";
        else if (content.equals("-3"))
            result = "IP address is unroutable or private.";
        else if (content.equals("-4"))
            result = "Unable to reach database at this moment, most likely database is being updated.";
        else
            if (output >= threshold)
                result = "IP address is using VPN or proxy.";
            else if (output < threshold)
                result = "IP address is not using any VPN or proxy.";

        return result;

    }

}
