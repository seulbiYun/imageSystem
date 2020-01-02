package com.khrd.domain;

public class PageMaker {
	private int totalCount;//게시물 전체 갯수
	private int startPage; //현재 보이는 페이지 시작번호
	private int endPage; //현재 보이는 페이지 끝 번호
	private boolean prev; //이전 10개 존재 여부
	private boolean next; //이후 10개 존재 여부
	private int displayPageNum=10; //보이는 페이지 숫자의 갯수
	
	private Criteria cri;

	private void calcData() {
		//ex )게시글 : 150 
		//ex )현재 선택페이지 : 15
		// 15 / 10 = 1.5 = 2(올림) * 10 = 20
		// 현재 페이지의 끝 번호를 수란다. start번호를 구하기 위해 필요!!
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		
		// 20 - 10 + 1 = 11 ==>첫페이지의 시작번호가 1이 나와야하기에 1을 더함
		//현재 페이지의 시작번호를 구한다.
		startPage = (endPage - displayPageNum) +1;
		
		//cri.getPerPageNum() : 한페이지에 보여질 게시글의 갯수
		//전체 게시글이 153이고 현재 선택 페이지가 15일때, 마지막 번호는 (endPage)는 16으로 나타난다.
		//Math.ceil(153/10) = 16
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));
		//만약, 이전에 구한 끝 페이지 번호가 실제 끝 페이지 번호보다 크다면 변경해 준다.
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//시작 페이지 숫자가 1이라면 이전 숫자가 없게 막음
		if(startPage == 1) {
			prev = false; 
		}else {
			prev = true;
		}
		
		//끝 페이지 숫자가 마지만 숫자라면 다음 숫자가 없게 막음
		if(endPage * cri.getPerPageNum() >= totalCount) {
			next = false;
		}else {
			next = true;
		}
		
		
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();//pageMaker 값 구함
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	
}
