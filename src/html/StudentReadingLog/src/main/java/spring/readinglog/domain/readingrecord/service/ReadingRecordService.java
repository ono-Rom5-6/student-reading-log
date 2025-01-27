//読書メモの登録処理、一覧取得、検索結果取得、詳細取得、読了処理、更新処理、
//また読書データの取得を行う
package spring.readinglog.domain.readingrecord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring.readinglog.domain.readingrecord.model.ReadingRecord;

@Service
public interface ReadingRecordService {
	public void addReadingRecord(ReadingRecord readingRecord);
	
	public List<ReadingRecord> getReadingRecordList(String userId, String searchWord);
	
	public ReadingRecord getReadingRecord(String id);
	
	public void editReadingRecord(ReadingRecord readingRecord);
	
	//以下、読書データを取得する
	public String getYourNumberOfBooksReadThisMonth(String userId);
	public String getAverageNumberOfBooksReadThisMonth();
	public String getTopNumberOfBooksReadThisMonth();
	
	public String getYourNumberOfBooksReadLastMonth(String userId);
	public String getAverageNumberOfBooksReadLastMonth();
	public String getTopNumberOfBooksReadLastMonth();
	//以上、読書データを取得する


}
