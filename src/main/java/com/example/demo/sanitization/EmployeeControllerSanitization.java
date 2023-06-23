package com.example.demo.sanitization;

import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.util.SanitizeUtils;

import io.micrometer.common.util.StringUtils;
import jakarta.el.PropertyNotFoundException;
@Configuration
public class EmployeeControllerSanitization {

	public static final String ID_REGEX = "/^[0-9a-fA-F]{24}$/";

	public void addEmployeeDetails(EmployeeDto employeeDto) {
		if (StringUtils.isEmpty(employeeDto.getId())) {
			throw new PropertyNotFoundException("Id Should not be Empty");
		}
		employeeDto.setId(SanitizeUtils.sanitize(employeeDto.getId()));

		if (patternMatcher(employeeDto.getId(), ID_REGEX)) {
			throw new PropertyNotFoundException("Pattern Not match");
		}

	}
	
	public void updateEmployee(EmployeeDto employeeDto) {
		if (StringUtils.isEmpty(employeeDto.getId())) {
			throw new PropertyNotFoundException("Id Should not be Empty");
		}
		employeeDto.setId(SanitizeUtils.sanitize(employeeDto.getId()));

		if (patternMatcher(employeeDto.getId(), ID_REGEX)) {
			throw new PropertyNotFoundException("Pattern Not match");
		}

	}

	public static boolean patternMatcher(String string, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(string).matches();
	}
}
