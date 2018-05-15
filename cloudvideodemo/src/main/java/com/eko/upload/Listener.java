package com.eko.upload;

public interface Listener {

	void onStart(Object info);

	void onRead(Object info);

	void onUpload(Object info);

	void onPartDone(Object info);

	void onNotify();

	void onFail(Object info);

	void onSuccess();

	public static class Default implements Listener {
		
		public void onStart(Object info) {
			onMessage("Start uploading " + info + " part(s).");
		}
		
		public void onRead(Object info) {
			onMessage("Reading part " + info + ".");
		}
		
		public void onUpload(Object info) {
			onMessage("Uploading part " + info + ".");
		}
		
		public void onPartDone(Object info) {
			onMessage("Part " + info + " is done.");
		}

		public void onNotify() {
			onMessage("Notifying.");
		}
		
		public void onFail(Object info) {
			onMessage(info + " failed.");
		}

		public void onSuccess() {
			onMessage("Success.");
		}

		protected void onMessage(String msg) {
			//System.out.println(msg);
		}
	}
}
