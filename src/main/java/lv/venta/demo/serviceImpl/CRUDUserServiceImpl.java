package lv.venta.demo.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.demo.model.User;
import lv.venta.demo.repo.IUserRepo;
import lv.venta.demo.service.ICRUDUserService;

public class CRUDUserServiceImpl implements ICRUDUserService{

	@Autowired
	IUserRepo userRepo;
	
	@Override
	public boolean autheriseUser(String iden, String password) {
		ArrayList<User> user = userRepo.findByIdenAndPassword(iden, password);
		if (user!=null)
		{
			return true;
		}
		return false;
	}

}
