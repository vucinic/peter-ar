package com.peter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class PeterAR {
	ByteBuffer byteBuffer;

	public static void main(String[] args) {
		PeterAR peterAR = new PeterAR();
	}

	public int init(File file) {
		try {
			RandomAccessFile f = new RandomAccessFile(file, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

}
