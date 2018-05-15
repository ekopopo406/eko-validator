package com.eko.upload;

public class Part {

	private byte[] content;
	private String name;
	public static final Part NULL = new Part();

	public Part() {
		this(null, null);
	}

	public Part(String name, byte[] content) {
		this.content = content;
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public String getName() {
		return name;
	}
}
