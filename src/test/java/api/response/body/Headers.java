package api.response.body;

import java.util.HashMap;
import java.util.PrimitiveIterator;

public class Headers {

    private HashMap<String, String> args;
    private HashMap<String, String> headers;
    private String url;

    public Headers(HashMap<String, String> args, HashMap<String, String> headers, String url) {
        this.args = args;
        this.headers = headers;
        this.url = url;
    }

    public HashMap<String, String> getArgs() {
        return args;
    }

    public void setArgs(HashMap<String, String> args) {
        this.args = args;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
//    public String host;
//    public String x-request-start;
//    public String connection;
//    public String x-forwarded-proto;
//    public String x-forwarded-port;
//    public String x-amzn-trace-id;
//    public String user-agent;
//    public String accept;
//    public String cache-control;
//    public String postman-token;
//    public String accept-encoding;
}
