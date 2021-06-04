package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDomain extends BoardEntity{ // select용
    private String writerNm;
    private String profileImg;
}
