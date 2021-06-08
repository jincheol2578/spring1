package com.koreait.spring.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCmtDomain extends BoardCmtEntity{
    private String WriterNm;
    private String profileImg;
}
