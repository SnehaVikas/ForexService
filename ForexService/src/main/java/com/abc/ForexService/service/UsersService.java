package com.abc.ForexService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.ForexService.dto.UsersDto;
import com.abc.ForexService.entity.Users;
import com.abc.ForexService.exception.InvalidInputException;

@Service

public interface UsersService {

	public void deleteUsers(int usersId);

	public List<Users> getAllUsers();

	public Users getUsersById(int usersId);

	UsersDto saveUsers(UsersDto usersDto);

	String resetPassword(String email, String password, String newPassword) throws InvalidInputException;

	String resetForgotPassword(String email, String newPassword, String confirmPassword) throws InvalidInputException;

}
