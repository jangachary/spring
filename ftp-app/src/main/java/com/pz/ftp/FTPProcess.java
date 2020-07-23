package com.pz.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class FTPProcess {
	@Value("${ftp.host}")
	String server;
	int port = 21;
	@Value("${ftp.username}")
	String user;
	@Value("${ftp.password}")
	String pass;
	FTPClient ftpClient;

	public FTPProcess() {
		ftpClient = new FTPClient();
	}

	boolean isLoggedIn = false;

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public boolean login() {
		isLoggedIn = false;
		try {
			ftpClient.connect(server, port);
			isLoggedIn = ftpClient.login(user, pass);
			log.info("successfully logged in");
		} catch (IOException e) {
			log.error("error in log in");
		}
		return isLoggedIn;
	}

	public String saveFile(String fileName) {
		String msg = "";
		try {
			if (isLoggedIn) {

				ftpClient.enterLocalPassiveMode();
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				File localFile = new File(fileName);
				String remoteFile = localFile.getName();
				InputStream inputStream = new FileInputStream(localFile);
				boolean upload = ftpClient.storeFile(remoteFile, inputStream);
				inputStream.close();
				if (upload) {
					msg = "The file [" + fileName + "] is uploaded successfully.";
					log.info(msg);
				} else {
					msg = "The file [" + fileName + "] is  not uploaded.";
					log.info(msg);
				}
			} else {
				msg = "client not logged in";
				log.info(msg);
			}
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
		}
		return msg;
	}

	public void logout() {
		try {
			if (ftpClient.isConnected()) {
				ftpClient.logout();
			}
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	public void disconnect() {
		try {
			if (ftpClient.isConnected()) {
				ftpClient.disconnect();
			}
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	public FTPFile[] listDirectories() {
		FTPFile[] ftpFiles = null;
		try {
			ftpFiles = ftpClient.listDirectories();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return ftpFiles;

	}

	public FTPFile[] listFiles(String path) {
		FTPFile[] ftpFiles = null;
		try {
			ftpFiles = ftpClient.listFiles(path);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return ftpFiles;

	}
}