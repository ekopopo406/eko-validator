package com.eko.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import com.eko.upload.UploadFileService;

public class UploadTest {
	public static void main(String[] args){
//		UploadFileService service = new UploadFileService("C:\\Users\\IBM_ADMIN\\Documents\\SametimeFileTransfers\\Microsite-Portal.zip");
//		service.upload();
//		
		 
		try (FileOutputStream dest = new FileOutputStream("C:\\upload\\Jellyfish.jpg", true)) {

			FileChannel dc = dest.getChannel();// the final big file.
			for (long i = 0; i < 36; i++) {
				File partFile = new File("C:\\upload\\Jellyfish.jpg" + "." + i);// every small parts.
				if (!partFile.exists()) {
					break;
				}
				try (FileInputStream part = new FileInputStream(partFile)) {
					FileChannel pc = part.getChannel();
					pc.transferTo(0, pc.size(), dc);// combine.
				}
				partFile.delete();
			}
			 
		} catch (Exception e) {
		 e.printStackTrace();
		}
	}
}
