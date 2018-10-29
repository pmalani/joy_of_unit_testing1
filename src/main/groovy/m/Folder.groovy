package m

class Folder extends File {
	List<File> files = []
	
	Folder add(File f) {
		files << f
		return this
	}
	
	int getSize() {
		return files ? files.sum { File file -> file.size } : 0
	}
	
}
