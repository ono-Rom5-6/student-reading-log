//ホーム画面の表示、検索処理、検索結果画面の表示
package spring.readinglog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.readinglog.domain.readingrecord.model.ReadingRecord;
import spring.readinglog.domain.readingrecord.service.ReadingRecordService;
import spring.readinglog.domain.user.model.LoginUserDetails;



@Controller
public class HomeController {
	@Autowired
	ReadingRecordService readingRecordService;
	
	@GetMapping("/home")
	public String get(Model model, @AuthenticationPrincipal LoginUserDetails user, @RequestParam(required = false) String searchWord) {
		String userId = user.getLoginUser().getId();
		
		List<ReadingRecord> readingRecordList = readingRecordService.getReadingRecordList(userId, searchWord);
		model.addAttribute("readingRecordList", readingRecordList);
		
		//ログインユーザーとクラスの読書データを取得する
		model.addAttribute("yourNumberOfBooksReadThisMonth", readingRecordService.getYourNumberOfBooksReadThisMonth(userId));
		model.addAttribute("averageNumberOfBooksReadThisMonth", readingRecordService.getAverageNumberOfBooksReadThisMonth());
		model.addAttribute("topNumberOfBooksReadThisMonth", readingRecordService.getTopNumberOfBooksReadThisMonth());
		
		model.addAttribute("yourNumberOfBooksReadLastMonth", readingRecordService.getYourNumberOfBooksReadLastMonth(userId));
		model.addAttribute("averageNumberOfBooksReadLastMonth", readingRecordService.getAverageNumberOfBooksReadLastMonth());
		model.addAttribute("topNumberOfBooksReadLastMonth", readingRecordService.getTopNumberOfBooksReadLastMonth());
		
		model.addAttribute("title", "home");
		return "home";
	}
	
	

}
