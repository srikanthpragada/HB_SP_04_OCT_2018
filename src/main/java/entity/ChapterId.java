package entity;

import java.io.Serializable;

public class ChapterId  implements Serializable{
	private int bookId,chapterNo;

	
	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChapterId other = (ChapterId) obj;
		if (bookId != other.bookId)
			return false;
		if (chapterNo != other.chapterNo)
			return false;
		return true;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(int chapterNo) {
		this.chapterNo = chapterNo;
	}
	
	

}
