package com.abc.ForexService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.UsersDto;
import com.abc.ForexService.entity.Users;
import com.abc.ForexService.exception.InvalidInputException;
import com.abc.ForexService.exception.UsersNotFoundException;
import com.abc.ForexService.repository.UsersRepository;
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> getAllUsers() {
		List<Users> users = usersRepository.findAll();
		return users;
	}
//	

	
	@Override
	public Users getUsersById(int usersId) throws UsersNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findById(usersId);
		if (optionalUsers.isEmpty()) {
			throw new UsersNotFoundException("Users Not Found with id: " + usersId);
		}
		Users users = optionalUsers.get();
		return users;
	}
//	
	@Override
	public UsersDto saveUsers(UsersDto usersDto) {

		Users users = new Users();
		

		users.setName(usersDto.getName());
		users.setLocation(usersDto.getLocation());
		users.setGender(usersDto.getGender());
		users.setEmail(usersDto.getEmail());
		users.setPassword(usersDto.getPassword());

		users.setMobileNo(usersDto.getMobileNo());
		
		
		Users newUsers = usersRepository.save(users);
		
		usersDto.setUsersId(newUsers.getUsersId());
		return usersDto;
	}

	@Override
	public void deleteUsers(int usersId) throws UsersNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findById(usersId);
		if (optionalUsers.isEmpty()) {
			throw new UsersNotFoundException("Users not existing with id:" + usersId);
		}
		usersRepository.deleteById(usersId);
	}




	
	@Override
	public String resetPassword(String email, String password, String newPassword) throws InvalidInputException {
		Optional<Users> loginObj= usersRepository.findByEmail(email);
		String s="";
		if(loginObj.isPresent()) {
			if( loginObj.get().getPassword().equals(password)) {
				Users users = loginObj.get();
				users.setPassword(newPassword);
				usersRepository.save(users);
				return "Password reset successfully";
			}
			else {
				s="enter valid password";
				}
			}
		else {
			s="Enter Registered Email Id";
			}
		throw new InvalidInputException(s);
        }


	@Override
	public String resetForgotPassword(String email, String newPassword, String confirmPassword) throws InvalidInputException {
		Optional<Users> loginObj= usersRepository.findByEmail(email);
		String s="";
		if(loginObj.isPresent()) {
			if(newPassword.equals(confirmPassword)) {
				Users users = loginObj.get();
				users.setPassword(newPassword);
				usersRepository.save(users);
				return "Password reset successfully";
			}
			else {
				s="password not match";
				}
			}
		else {
			s="enter valid email";
			}
		throw new InvalidInputException(s);
	}


	
	
	
	
}
