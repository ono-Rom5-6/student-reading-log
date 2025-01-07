//読書メモの登録処理、一覧取得、検索結果取得、詳細取得、読了処理、更新処理、
//また読書データの取得を行う
package spring.readinglog.domain.readingrecord.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.readinglog.domain.readingrecord.model.ReadingRecord;
import spring.readinglog.domain.readingrecord.service.ReadingRecordService;
import spring.readinglog.repository.ReadingRecordMapper;

@Service
@Transactional
public class ReadingRecordServiceImpl implements ReadingRecordService{
	@Autowired
	private ReadingRecordMapper readingRecordMapper;
	
	@Override
	public void addReadingRecord(ReadingRecord readingRecord) {
		readingRecordMapper.insertReadingRecord(readingRecord);
	}
	
	@Override
	public List<ReadingRecord> getReadingRecordList(String userId, String searchWord) {
		return readingRecordMapper.selectManyReadingRecord(userId, searchWord);
	}
	
	@Override
	public ReadingRecord getReadingRecord(String id) {
		return readingRecordMapper.selectOne(id);
	}
	
	@Override
	public void finishReading(String id, Date today) {
		readingRecordMapper.updateFinishedDate(id, today);
	}
	
	@Override
	public void editReadingRecord(ReadingRecord readingRecord) {
		readingRecordMapper.updateReadingRecord(readingRecord);
	}
	
	//以下、読書データを取得する
	@Override
	public String getYourNumberOfBooksReadThisMonth(String userId) {
		return readingRecordMapper.selectYourNumberOfBooksReadThisMonth(userId);
	}
	
	@Override
	public String getAverageNumberOfBooksReadThisMonth() {
		return readingRecordMapper.selectAverageNumberOfBooksReadThisMonth();
	}
	
	@Override
	public String getTopNumberOfBooksReadThisMonth() {
		return readingRecordMapper.selectTopNumberOfBooksReadThisMonth();
	}
	
	
	@Override
	public String getYourNumberOfBooksReadLastMonth(String userId) {
		return readingRecordMapper.selectYourNumberOfBooksReadLastMonth(userId);
	}
	
	@Override
	public String getAverageNumberOfBooksReadLastMonth() {
		return readingRecordMapper.selectAverageNumberOfBooksReadLastMonth();
	}
	
	@Override
	public String getTopNumberOfBooksReadLastMonth() {
		return readingRecordMapper.selectTopNumberOfBooksReadLastMonth();
	}
	//以上、読書データを取得する
}
