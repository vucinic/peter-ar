package com.peter;

public class AR {
	String filename;
	String tempstamp;
	String ownerID;
	String groupID;
	String fileMode;
	int fileSize;
	byte bytes[];

	public String toString() {
		return "filename: " + filename + ",\ttempstamp: " + tempstamp + ",\townerID: " + ownerID + ", groupID: " + groupID + ", fileMode: " + fileMode + ", fileSize: " + fileSize;
	}
}
