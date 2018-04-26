package book.service.upload.pojo;

public class Book_file {

    private long book_id;
    private long book_img_id;
    private String book_img_name;
    private String upload_user;
    private String upload_time;
    private String file_path;
    private String file_type;
    private long file_size;

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getBook_img_id() {
        return book_img_id;
    }

    public void setBook_img_id(long book_img_id) {
        this.book_img_id = book_img_id;
    }

    public String getBook_img_name() {
        return book_img_name;
    }

    public void setBook_image_name(String book_img_name) {
        this.book_img_name = book_img_name;
    }

    public String getUpload_user() {
        return upload_user;
    }

    public void setUpload_user(String upload_user) {
        this.upload_user = upload_user;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
