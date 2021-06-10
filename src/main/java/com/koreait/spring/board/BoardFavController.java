package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController // jsp가 아닌 Json을 리턴한다.
@RequestMapping("/board")
public class BoardFavController {

    @Autowired
    private BoardFavService service;

    @PostMapping("/fav")
    public Map<String,Integer> insFav(@RequestBody BoardFavEntity param){
        Map<String , Integer> result = new HashMap<>();
        result.put("result", service.insBoardFav(param));
        return result;
    }
    @GetMapping("/fav")
    public Map<String,Integer> selFav(BoardFavEntity param){
        Map<String , Integer> result = new HashMap<>();
        result.put("result", service.selBoardFav(param));
        return result;
    }
    @DeleteMapping("/fav")
    public Map<String,Integer> delFav(BoardFavEntity param){
        Map<String , Integer> result = new HashMap<>();
        result.put("result", service.delBoardFav(param));
        return result;
    }
}
