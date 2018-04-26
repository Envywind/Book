package book.service.car.dao;

import java.util.List;

import book.service.car.pojo.Car;

public interface CarDao {

    List<Car> queryCar(int user_id);

    int addCar(int user_id, String id, String book_price);

    List<Car> queryPrice(String id);

    int dele(String c_id);

}
