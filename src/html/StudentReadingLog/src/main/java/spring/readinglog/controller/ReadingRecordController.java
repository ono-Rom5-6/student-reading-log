//読書メモ登録、読了機能、詳細表示、編集
package spring.readinglog.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import spring.readinglog.domain.readingrecord.model.ReadingRecord;
import spring.readinglog.domain.readingrecord.service.ReadingRecordService;
import spring.readinglog.domain.user.model.LoginUserDetails;
import spring.readinglog.form.readingrecord.EditForm;
import spring.readinglog.form.readingrecord.EntryForm;

@Controller
@RequestMapping("/reading-record")
public class ReadingRecordController {
	@Autowired
	private ReadingRecordService readingRecordService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/entry/index")
	public String getEntry(Model model, EntryForm form) {
		model.addAttribute("title", "entry");
		return "reading-record/entry/index";
	}

	@PostMapping("/entry/index")
	public String postEntry(Model model, @ModelAttribute @Validated EntryForm form, BindingResult bindingResult,
			HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return getEntry(model, form);
		}
		return getEntryConfirm(model, form);
	}

	@GetMapping("/entry/confirm")
	public String getEntryConfirm(Model model, EntryForm form) {
		model.addAttribute("entryForm", form);
		return "reading-record/entry/confirm";
	}

	@PostMapping("/entry/confirm")
	public String postEntryConfirm(Model model, EntryForm form,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		ReadingRecord readingRecord = modelMapper.map(form, ReadingRecord.class);
		String userId = loginUserDetails.getLoginUser().getId();
		readingRecord.setUserId(userId);
		readingRecordService.addReadingRecord(readingRecord);
		return "redirect:finish";
	}

	@PostMapping(value = "/entry/confirm", params = "cancel")
	public String postEntryConfirmCancel(Model model, @ModelAttribute EntryForm form) {
		return getEntry(model, form);
	}

	@GetMapping("/entry/finish")
	public String getEntryFinish() {
		return "reading-record/entry/finish";
	}

	@GetMapping("/detail/{id}")
	public String getDetail(Model model, @PathVariable String id,
			@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		ReadingRecord readingRecord = readingRecordService.getReadingRecord(id);
		if(readingRecord ==null) {
			set404error(model);
			return "error";
		}

		if(mismatchUserId(readingRecord, loginUserDetails)) {
			set403error(model);
			return "error";
		}
		
		model.addAttribute("readingRecord", readingRecord);
		return "reading-record/detail";
	}

	@GetMapping("/edit/{id}")
	public String getEdit(Model model, @PathVariable String id, EditForm editForm, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		ReadingRecord readingRecord = readingRecordService.getReadingRecord(id);
		if(readingRecord ==null) {
			set404error(model);
			return "error";
		}
		
		if(mismatchUserId(readingRecord, loginUserDetails)) {
			set403error(model);
			return "error";
		}
		
		editForm.setTitle(readingRecord.getTitle());
		editForm.setAuthor(readingRecord.getAuthor());
		editForm.setStartingDate(readingRecord.getStartingDate());
		editForm.setFinishedDate(readingRecord.getFinishedDate());
		editForm.setMemos(readingRecord.getMemos());

		editForm.setId(id);

		model.addAttribute("editForm", editForm);
		return "reading-record/edit/index";
	}

	@PostMapping("/edit/index")
	public String postEdit(Model model, @ModelAttribute @Validated EditForm editForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "reading-record/edit/index";
		}
		return getEditConfirm(model, editForm);
	}

	@GetMapping("/edit/confirm")
	public String getEditConfirm(Model model, EditForm editForm) {
		model.addAttribute("editForm", editForm);
		return "reading-record/edit/confirm";
	}

	@PostMapping("/edit/confirm")
	public String postEditConfirm(Model model, EditForm editForm, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
		editForm.setUserId(loginUserDetails.getLoginUser().getId());
		ReadingRecord readingRecord = modelMapper.map(editForm, ReadingRecord.class);
		if(mismatchUserId(readingRecord, loginUserDetails)) {
			set403error(model);
			return "error";
		}
		
		readingRecordService.editReadingRecord(readingRecord);
		return "redirect:finish";
	}

	@PostMapping(value = "/edit/confirm", params = "cancel")
	public String postEditConfirmCancel(Model model, EditForm editForm) {
		return "reading-record/edit/index";
	}

	@GetMapping("/edit/finish")
	public String getEditFinish() {
		return "reading-record/edit/finish";
	}
	
//メソッド類
	public boolean mismatchUserId(ReadingRecord readingRecord, LoginUserDetails loginUserDetails) {
		if(readingRecord.getUserId().equals(loginUserDetails.getLoginUser().getId())) {
			return false;
		}
		return true;
	}
	
	public void set403error(Model model) {
		model.addAttribute("error", " ");
		model.addAttribute("message", "Exceptionが発生しました");
		model.addAttribute("status", HttpStatus.FORBIDDEN);
	}
	
	public void set404error(Model model) {
		model.addAttribute("error", " ");
		model.addAttribute("message", "Exceptionが発生しました");
		model.addAttribute("status", HttpStatus.NOT_FOUND);
	}
	

}
