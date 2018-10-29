package m

import spock.lang.Specification;
import spock.lang.Unroll;

class FolderSizeTest extends Specification {
	File file1
	File file2
	
	Folder folder1

	def whenEmpty() {
		when:
			folder1 = new Folder()
		then:
			folder1.size == 0
	}	
	
	def whenOneFile() {
		given:
			file1 = new File(size: 1)
			folder1 = new Folder()
		when:
			folder1.add(file1)
		then:
			folder1.size == 1
	}
	
	def whenMoreThanOneFile() {
		given:
			file1 = new File(size: 1)
			file2 = new File(size: 2)
			folder1 = new Folder()
		when:
			folder1.add(file1)
			folder1.add(file2)
		then:
			folder1.size == 3
	}
	
	def moreThanOneLevel() {
		given:
			file1 = new File(size: 1)
			file2 = new File(size: 2)
			folder1 = new Folder()
			Folder folder2 = new Folder()
		when:
			folder1.add(file1)
			folder2.add(file2)
			folder1.add(folder2)
		then:
			folder2.size == 2
			folder1.size == 3
	}
	
	@Unroll
	def "two files of #fileSize1 and #fileSize2 size, then folder size is #folderSize" (int fileSize1, int fileSize2, int folderSize) {
		given:
			file1 = new File(size: fileSize1)
			file2 = new File(size: fileSize2)
			folder1 = new Folder()
		when:
			folder1.add(file1)
			folder1.add(file2)
		then:
			folder1.size == folderSize
		where:
			fileSize1 	| fileSize2 || folderSize
			1 			| 2			|| 3
			-1 			| 2			|| 1
			0 			| 2			|| 2
	}
}
