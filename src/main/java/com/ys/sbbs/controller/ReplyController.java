package com.ys.sbbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ys.sbbs.entity.Reply;
import com.ys.sbbs.service.BoardService;
import com.ys.sbbs.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired ReplyService replyService;
	@Autowired BoardService boardService;
	
	@PostMapping("/write")
	public String writeProc(int bid, String uid, String comment, HttpSession session) {
		String sessionUid = (String) session.getAttribute("sessUid");
		int isMine = sessionUid.equals(uid) ? 1 : 0;
		Reply reply = new Reply(comment, isMine, sessionUid, bid);
		replyService.insertReply(reply);
		boardService.increaseReplyCount(bid);
		
		return "redirect:/board/detail/" + bid + "/" + uid + "?option=DNI";
	}
	
	@GetMapping("/delete/{rid}/{bid}")
	public String delete(@PathVariable String rid, @PathVariable int bid) {
		
		return "board/deleteReply";
	}
	@GetMapping("/deleteConfirm/{rid}/{bid}")
	public String deleteConfirm(@PathVariable String rid, @PathVariable int bid, HttpSession session) {
		replyService.deleteReply(rid);
		boardService.decreaseReplyCount(bid);
		String sessionUid = (String) session.getAttribute("sessUid");
		return "redirect:/board/detail/" + bid + "/" + sessionUid + "?option=DNI";
	}
	
}
