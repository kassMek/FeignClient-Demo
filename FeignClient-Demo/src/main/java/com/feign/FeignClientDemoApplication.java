package com.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feign.client.UserFeignCilentInterface;
import com.feign.dto.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class FeignClientDemoApplication {
	
	@Autowired
	private UserFeignCilentInterface cleint;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientDemoApplication.class, args);
		System.out.println("testing feign cliet demo 1");
	}

	 @GetMapping("/findAllUsers")
	 public List<UserResponse> fetchUsers(){
		 return cleint.getUsers();
	 }
}
