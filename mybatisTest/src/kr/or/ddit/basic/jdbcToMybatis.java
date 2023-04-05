package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MybatisSqlSessionFactory;

/*
	LPROD테이블에 새로운 데이터 추가하기
	
	LPROD_gu와 LPROD_nm 은 직접 입력 받아서 처리하고, 
	LPROD_id는 현재의 Lprod_id중에서 제일 큰 값보다 1 크게 한다.
	
	입력 받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
	
	--> JDBC예제 중 jdbcTest05.java를 myBatis용으로 변경하시오
	--> mapper파일명은 'jdbc-mapper.xml'로 한다. 
	
*/



public class jdbcToMybatis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		//1. myBatis의 환경설정 파일을 읽어와서 실행한다. (mybatis-config.xml)
		
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			//1-1. 환경 설정 파일을 읽어 올 스트림 객체를 생성한다.
			//	   (이 때 읽어올 환경설정 파일을 지정해준다)
			rd = Resources.getResourceAsReader("kr/or/ddit/mybatis/config/mybatis-config.xml");
			
			//1-2. 환경 설정 파일을 읽어와 환경 설정을 완성한 후 SQL문을 호출해서 실행할 수 있는 
			//     객체를 생성하는 SqlSessionFactory객체를 생성한다.
			
			sqlSessionFactory= new SqlSessionFactoryBuilder().build(rd);
			
			
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패!");
			e.printStackTrace();
	} finally {
		if(rd!=null) try {rd.close();} catch(IOException e) {}
	}
		*/
		
		//--------------------------------------------------------
		
		SqlSession session = null;
		
		
		//insert작업
		
		try {
			session = MybatisSqlSessionFactory.getSqlSession();
			//session = sqlSessionFactory.openSession();
	
			//제일 큰 값보다 1 큰 값 구하기
			int nextId = session.selectOne("jdbc.getNextId");
			
			//LPROD_GU값을 입력 받고 중복되면 다시 입력 받기
			String gu;
			int count = 0;
			
			do {
				System.out.println("상품 분류 코드(LPROD_GU) 입력 >> ");
				gu = scan.next();
				
				count = session.selectOne("jdbc.getLprodCount", gu);
				
				if(count > 0) {
					System.out.println("입력한 상품 분류 코드" + gu + "은(는) 이미 등록된 코드입니다." );
					System.out.println("다른 상품 분류 코드를 다시 입력하세요");
					System.out.println();
				}
				
			}while(count>0);
			
			System.out.println("상품 분류명(LPROD_NM) 입력 >> ");
			String nm = scan.next();
			
			//입력값들을 VO에 저장하기
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod", lvo);
			
			if(cnt > 0) {
				System.out.println("등록 성공!");
			} else {
				System.out.println("등록 실패 ~ ~ ");
			}
					
			
		} finally {
			// 커밋과 닫기
			session.commit();
			session.close();
		}
		
		
		
		
		/*
		 * System.out.println("Lprod_nm 입력 >> "); String lprodNm = scan.next();
		 * 
		 * //입력한 데이터를 VO에 저장한다. JdbcVO jdbcvo = new JdbcVO();
		 * jdbcvo.setLprod_gu(lprodGu); jdbcvo.setLprod_nm(lprodNm);
		 * 
		 * try {
		 * 
		 * session = sqlSessionFactory.openSession();
		 * 
		 * int insertCnt2 = session.insert("jdbc.insertJdbc", jdbcvo); if(insertCnt2>0)
		 * { System.out.println("insert 작업 성공 !!! "); } else {
		 * System.out.println("insert 작업 실패 ~~~!"); }
		 * 
		 * } finally { //SqlSession을 생성할 때 AutoCommit이 비활성화된 상태일 때는 commit을 직접 실행해야 한다.
		 * session.commit();
		 * 
		 * // 작업이 완료되면 SqlSession객체를 닫아준다. session.close(); }
		 */
		
	}
}
