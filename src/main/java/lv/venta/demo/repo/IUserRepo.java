package lv.venta.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.model.User;

public interface IUserRepo extends CrudRepository<User, Integer> {

	ArrayList<User> findByIdenAndPassword(String iden, String password);

}
