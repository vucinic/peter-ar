package com.peterar;

public class AR {
	public String filename;
	public String tempstamp;
	public String ownerID;
	public String groupID;
	public String fileMode;
	public int fileSize;
	public byte bytes[];

	public String toString() {
		return "filename: " + filename + ",\ttempstamp: " + tempstamp
				+ ",\townerID: " + ownerID + ", groupID: " + groupID
				+ ", fileMode: " + fileMode + ", fileSize: " + fileSize;
	}
}
