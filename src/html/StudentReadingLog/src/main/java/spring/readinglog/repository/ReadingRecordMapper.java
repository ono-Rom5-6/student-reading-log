package spring.readinglog.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import spring.readinglog.domain.readingrecord.model.ReadingRecord;

@Mapper
public interface ReadingRecordMapper {
	public void insertReadingRecord(ReadingRecord readingRecord);
	
	public List<ReadingRecord> selectManyReadingRecord(@Param("userId") String userId, @Param("searchWord") String searchWord);
	
	public ReadingRecord selectOne(String id);
	
	public void updateFinishedDate(@Param("id") String id, @Param("today") Date today);
	
	public void updateReadingRecord(ReadingRecord readingRecord);
	
	public String selectYourNumberOfBooksReadThisMonth(String userId);
	public String selectAverageNumberOfBooksReadThisMonth();
	public String selectTopNumberOfBooksReadThisMonth();
	
	public String selectYourNumberOfBooksReadLastMonth(String userId);
	public String selectAverageNumberOfBooksReadLastMonth();
	public String selectTopNumberOfBooksReadLastMonth();
	
}
