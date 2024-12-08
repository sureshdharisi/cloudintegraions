package com.example.spring.query.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.query.model.ServerEntity;

@RestController
@RequestMapping("/v1")
public class ServerController {

	@GetMapping("/ip")
	public ResponseEntity<ServerEntity> getIp(){
		ServerEntity entity=new ServerEntity();
		try {
			entity.setIp(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			entity.setIp(e.getMessage());
		}
		
		return ResponseEntity.ok(entity);
	}
}
