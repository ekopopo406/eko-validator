package com.eko.upload;

public interface Uploader {

	/**
	 * Upload a part.
	 * @param part
	 */
	void upload(Part part);

	/**
	 * Notify server all uploading is done.
	 * @param fileName
	 * @param partCount
	 */
	void done(String fileName, long partCount);
}
