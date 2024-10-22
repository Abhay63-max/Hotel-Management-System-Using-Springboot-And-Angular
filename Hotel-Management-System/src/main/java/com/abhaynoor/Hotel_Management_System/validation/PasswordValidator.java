package com.abhaynoor.Hotel_Management_System.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.abhaynoor.Hotel_Management_System.dto.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,UserDto> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String PASSWORD_PATTERN="[A-Za-z0-9@#$]{6,}";
	
	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
		return validatePassword(userDto.getPassword())&&passwordMatches(userDto) ;

		}
	
	private boolean validatePassword(String password) {
		pattern=Pattern.compile(PASSWORD_PATTERN);
		matcher= pattern.matcher(password);
		return matcher.matches();
	}
	
	private boolean passwordMatches(UserDto userDto) {
		
		return userDto.getPassword().equals(userDto.getConfirmationPassword());
		}

}
