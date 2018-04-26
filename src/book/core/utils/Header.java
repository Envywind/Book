package book.core.utils;

public class Header {

    private int code;
    private String message;
    private boolean isAlert;

    public Header() {
        this.isAlert = true;
    }

    public Header(int code, String message) {
        this(code, message, true);
    }

    public Header(int code, String message, boolean isAlert) {
        this.code = code;
        this.message = message;
        this.isAlert = isAlert;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAlert() {
        return this.isAlert;
    }

    public void setAlert(boolean alert) {
        this.isAlert = alert;
    }

}
