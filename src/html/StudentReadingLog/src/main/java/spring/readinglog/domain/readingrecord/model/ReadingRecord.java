package spring.readinglog.domain.readingrecord.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReadingRecord {
	private String id;
	private String userId;
	private String title;
	private String author;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startingDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date finishedDate;
	private String memos;

}
