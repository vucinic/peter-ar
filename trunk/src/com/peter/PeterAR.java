package com.peter;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Vector;

public class PeterAR {
	ByteBuffer byteBuffer;

	public static void main(String[] args) {
		PeterAR peterAR = new PeterAR();
		Vector<AR> data = peterAR.init(new File("/Users/peter/install/i586-peter-elf-newlib/i586-peter-elf/lib/libc.a"));
		//Vector<AR> data = peterAR.init(new File("/root/fuck"));
		if (data == null) {
			System.err.println("read error");
		} else {
			for (AR ar : data) {
				System.out.println(ar);
			}
		}
	}

	public Vector<AR> init(File file) {
		Vector<AR> data = new Vector<AR>();
		try {
			RandomAccessFile f = new RandomAccessFile(file, "r");
			byte bytes[] = new byte[(int) file.length()];
			f = new RandomAccessFile(file, "r");
			f.seek(0);
			f.readFully(bytes);
			f.close();
			ByteBuffer buffer = ByteBuffer.wrap(bytes);

			byte globalHeader[] = new byte[8];
			buffer.get(globalHeader);
			if (!new String(globalHeader).trim().equals("!<arch>")) {
				return null;
			}
			while (buffer.position() < file.length()) {
				AR ar = new AR();

				byte temp[] = new byte[16];
				buffer.get(temp);
				ar.filename = new String(temp).trim();
				ar.filename = ar.filename.substring(0, ar.filename.length() - 1);

				temp = new byte[12];
				buffer.get(temp);
				ar.tempstamp = new String(temp).trim();

				temp = new byte[6];
				buffer.get(temp);
				ar.ownerID = new String(temp).trim();

				temp = new byte[6];
				buffer.get(temp);
				ar.groupID = new String(temp).trim();

				temp = new byte[8];
				buffer.get(temp);
				ar.fileMode = new String(temp).trim();

				temp = new byte[10];
				buffer.get(temp);
				ar.fileSize = Integer.parseInt(new String(temp).trim());

				temp = new byte[2];
				buffer.get(temp);

				temp = new byte[ar.fileSize];
				buffer.get(temp);
				ar.bytes = temp;

				if (buffer.position() % 2 == 1) {
					buffer.get();
				}

				data.add(ar);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return data;
	}
}