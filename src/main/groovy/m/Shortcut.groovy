package m

class Shortcut extends File {
	File to
	
	Shortcut(File to) {
		this.to = to
	}

	// what should the size of shortcut be?
	
	void open() {
		to.open()
	}
	
}
