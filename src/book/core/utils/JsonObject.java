package book.core.utils;

public class JsonObject {

    private Header header;
    private Object body;

    public JsonObject() {
    }

    public JsonObject(Header header, Object body) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return this.header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return this.body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
