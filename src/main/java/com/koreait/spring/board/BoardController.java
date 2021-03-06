package com.koreait.spring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @RequestMapping("/list")
    public String list(Model model, BoardDTO param) {
        model.addAttribute("list", service.selBoardList(param));
        model.addAttribute("maxPageVal", service.selMaxPageVal());
        return "board/list";
    }

    @RequestMapping("/detail")
    public String detail(BoardDTO param, Model model) {
        System.out.println("iboard : " + param.getIboard());
        BoardDomain data = service.selBoard(param);
        model.addAttribute(data);
        return "board/detail";
    }

    @GetMapping("/writeMod")
    public void writeMod(BoardDTO param, Model model) {
        if(param.getIboard() > 0) {
            model.addAttribute("data",service.selBoard(param));
        }
    }

    @GetMapping("/delBoard")
    public String delBoard(BoardEntity param){
        service.delBoard(param);
        return "redirect:list";
    }

    @PostMapping("/writeMod")
    public String writeModProc(BoardEntity param) {
        int iboard = service.insBoard(param);
        return "redirect:detail?iboard=" + iboard;
    }


    @ResponseBody
    @RequestMapping(value="/cmtIns", method = RequestMethod.POST)
    public Map<String, Integer> cmtIns(@RequestBody BoardCmtEntity param) {
        System.out.println(param);
        int result = service.insBoardCmt(param);

        Map<String, Integer> data = new HashMap();
        data.put("result", result);
        return data;
    }

    @ResponseBody
    @RequestMapping("/cmt/{iboard}") // 변수명과 같으면 @PathVariable("여기 안써도된다.")
    public List<BoardCmtDomain> cmtSel(BoardCmtEntity param, @PathVariable int iboard){
        param.setIboard(iboard);
        return service.selBoardCmtList(param);
    }

    @ResponseBody
    @RequestMapping(value = "/cmt/{icmt}", method = RequestMethod.DELETE)
    public Map<String, Integer> cmtDel(BoardCmtEntity param, @PathVariable int icmt) {
        param.setIcmt(icmt);
        int result = service.delBoardCmt(param);
        System.out.println("result" + result);
        Map<String,Integer> data = new HashMap<>();
        data.put("result", result);
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/cmt", method = RequestMethod.PUT)
    public Map<String, Integer> cmtUpd(@RequestBody BoardCmtEntity param) {
        int result = service.updBoardCmt(param);
        Map<String, Integer> data = new HashMap();
        data.put("result", result);
        return data;
    }

}
