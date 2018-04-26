package book.service.car.pojo;

public class Car {

    private int book_id;                        // ID
    private int book_img_id;                    // 图片ID
    private int c_id;                            // 购物车ID
    private String book_name;                    // 书名
    private String book_price;                    // 单价
    private String file_path;                    // 上传路径
    private String num;                        // 数量
    private String total_sum;                    // 总价

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBook_img_id() {
        return book_img_id;
    }

    public void setBook_img_id(int book_img_id) {
        this.book_img_id = book_img_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(String total_sum) {
        this.total_sum = total_sum;
    }
}
