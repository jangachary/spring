package com.pz.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.pz.ftp.FTPProcess;

@SpringBootApplication
@ComponentScan("com.pz.*")
public class FtpAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FtpAppApplication.class, args);
	}

	@Autowired
	FTPProcess ftpProcess;

	@Override
	public void run(String... args) throws Exception {
		ftpProcess.login();
		ftpProcess.saveFile("F:\\sriram\\html\\pdf\\pdf3.html");
	}
}
