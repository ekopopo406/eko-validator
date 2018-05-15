package com.eko.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtil {
	//String ftpHost, String ftpUserName, String ftpPassword, int ftpPort
	public static FTPClient getFTPClient() {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient = new FTPClient();
			ftpClient.connect("sjc-vod-upload01.ustream.tv", 21);
			ftpClient.login("1_23520496_113799855", "CgMecT9z4A");
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {

				ftpClient.disconnect();
			} else {

			}
		} catch (SocketException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
		return ftpClient;
	}
//String ftpHost, String ftpUserName, String ftpPassword, int ftpPort,
	public static boolean uploadFile(
			String ftpPath, String fileName, InputStream input) {
		boolean success = false;
		FTPClient ftpClient = null;
		try {
			int reply;
			ftpClient = getFTPClient();
			reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				return success;
			}
			ftpClient.setControlEncoding("UTF-8");  
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory(ftpPath);

			boolean yesOrNo = ftpClient.storeFile(fileName, input);
			System.out.println("yesOrNo"+yesOrNo);
			input.close();
			ftpClient.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	public static void main(String[] args){
		try {
			InputStream ins = new FileInputStream("C:\\mp4 video\\151397-1-1.mp4");
			uploadFile("/1_23520496_1521867193540","151397-1-1.mp4",ins);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
