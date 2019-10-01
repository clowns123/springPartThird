package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {

		mapper.getList().forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testIsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글");
		board.setContent("새로 작성한 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
		
	}
	
	@Test
	public void testIsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 번호포함");
		board.setContent("새로 작성한 내용 번호포함");
		board.setWriter("newbie");
		
		
		mapper.insertSelectKey(board);
		
		log.info(log);
		
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(5L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(3L);
		board.setContent("영속 수정된 업데이트 컨테이너");
		board.setTitle("영속 수정됨 업데이트 타이틀");
		board.setWriter("양속 수정됨 업데이트 writer");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT :" + count);
	}
	

}
