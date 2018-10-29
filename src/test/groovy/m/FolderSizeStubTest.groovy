package m

import spock.lang.Specification;
import spock.lang.Unroll;

class FolderSizeStubTest extends Specification {
	File file1
	File file2
	
	Folder folder1
	
	def setup() {
		file1 = Stub()
		file2 = Stub()
		folder1 = new Folder()
	}

	def whenMoreThanOneFile() {
		given:
			file1.size >> 1
			file2.size >> 2
		when:
			folder1.add(file1)
			folder1.add(file2)
		then:
			folder1.size == 3
	}
	
}
