package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {  // Parameter용
    private int iboard;
    private int startIdx;
    private int recordCnt;
    private int searchType;
    private String searchText;
    private int page = 1;
    private int iuser;

}
