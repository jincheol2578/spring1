package com.koreait.spring.board;

import com.koreait.spring.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFavService {

    @Autowired
    private BoardFavMapper mapper;

    @Autowired
    private MyUtils myUtils;

    public int insBoardFav(BoardFavEntity param){
        param.setIuser(myUtils.getLoginUserPk());
        return mapper.insBoardFav(param);
    }
    public int selBoardFav(BoardFavEntity param){
        param.setIuser(myUtils.getLoginUserPk());
        return mapper.selBoardFav(param);
    }
    public int delBoardFav(BoardFavEntity param){
        param.setIuser(myUtils.getLoginUserPk());
        return mapper.delBoardFav(param);
    }

}
