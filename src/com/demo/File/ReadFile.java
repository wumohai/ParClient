package com.demo.File;

import java.io.*;

import com.demo.analysis.FileType;

public class ReadFile {

	public void WriteFileByBytes(String path, byte[] content) {

		try {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(file);

			fos.write(content);
			fos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/*
	 * 将字节数组写入文件中
	 */
	@SuppressWarnings("static-access")
	public void WriteFileByBytes(FileType fileType, byte[] content) {

		try {
			File file = new File(fileType.getFileType());
			if (!file.exists()) {
				file.mkdirs();
			}

			FileOutputStream fos = new FileOutputStream(file.getPath()
					+ file.separator + fileType.getFileName());

			fos.write(content);
			fos.close();
			System.out.println("save file in " + file.getPath()
					+ file.separator + fileType.getFileName() + "succ");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	
	public static void main(String[] args) {
	


	}

}
