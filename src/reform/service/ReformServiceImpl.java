package reform.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import reform.dao.CommentDao;
import reform.dao.CommentDaoImpl;
import reform.dao.RecommendDao;
import reform.dao.RecommendDaoImpl;
import reform.dao.ReformDao;
import reform.dao.ReformDaoImpl;
import reform.dto.CommentDto;
import reform.dto.ReformDto;
import reform.util.Paging;

public class ReformServiceImpl implements ReformService {

	private ReformDao reformdao = new ReformDaoImpl();  
	private CommentDao commentdao = new CommentDaoImpl();
	private RecommendDao recommenddao = new RecommendDaoImpl(); 

	// 게시판 불러오기
	@Override 
	public List<ReformDto> getList() { 
		return reformdao.selectAll();
	}

	// 전체 게시글 수 조회
	@Override
	public int getTotal() {
		return reformdao.countAll();
	}

	// 글 작성
	@Override
	public void write(ReformDto reformdto) {
		reformdao.insert(reformdto); 

	}

	// 글 수정
	@Override
	public void update(ReformDto reformdto) {
		reformdao.update(reformdto);

	}

	// 글 삭제
	@Override
	public void delete(ReformDto reformdto) {
		reformdao.delete(reformdto);

	}

	// 게시글 보기 
	@Override
	public ReformDto view(ReformDto reformdto) { 
		return reformdao.selectByIdx(reformdto); 
	}

	// 페이징 리스트 조회
	@Override
	public List<ReformDto> getPaging(Paging paging) {
		return reformdao.Paging(paging);    
	}

	// 댓글 불러오기
	@Override
	public List<CommentDto> viewComment(ReformDto reformdto) {
		return commentdao.selectComment(reformdto);

	}

	// 댓글 작성
	@Override
	public void writeComment(CommentDto commentdto) {
		commentdao.insertComment(commentdto); 

	}

	// 댓글 삭제
	@Override
	public void deleteComment(CommentDto commentdto) {
		commentdao.deleteComment(commentdto); 
	} 

	// 추천여부 t,f 반환
	@Override
	public boolean recommendCheck(ReformDto reformdto) {
		System.out.println(reformdto);
		if(recommenddao.CountRecommend(reformdto)>0) { // 추천했다면 1(true)
			return true;
		} else { // 추천하지 않았다면  0(false) 
			return false;
		}
	}

	// 추천 토글 
	@Override
	public boolean recommend(ReformDto reformdto) {
		if(recommendCheck(reformdto)) { // 이전에 추천했다면 
			recommenddao.deleteRecommend(reformdto); // 추천취소
			return false; // 추천취소 상태로 바꾸기
		} else { // 이전에 추천하지 않았다면
			recommenddao.insertRecommend(reformdto); // 추천하기
			return true; // 추천하기 상태로 바꾸기 
		}
	}

	// 해당 게시물의 전체 추천개수 
	@Override
	public int getRecommend(ReformDto reformdto) {
		return recommenddao.TotalRecommend(reformdto);
	}

	// 좋아요 누른 게시글 정보
	@Override
	public List<ReformDto> getLike(ReformDto reformdto) {
		return recommenddao.selectbyId(reformdto);  
	}

	// 사진 업로드
	@Override
	public ReformDto getInfo(HttpServletRequest request, HttpServletResponse response) {

		ReformDto reformdto = new ReformDto();
		// 파일 업로드 작업 시작 !!!!!

		// 1. 파입 업로드한 거 맞는지 확인하는 부분 
		// enctype 이 multipart 인지 확인하는 메소드
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); 


		//1-1. multipart/form-data가 아닐 경우
		if(!isMultipart) {
			System.out.println("multipart type 아님"); 
			return null; 
		}

		//1-2. multipart/form-data일 경우
		// 파일이 전송되었을 경우 

		//2. 업로드 파일을 처리하는 아이템 팩토리 생성
		// 디스크 기반의 파일아이템 처리 API - DiskFileItemFactory
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();

		//3. 업로드 아이템이 적당히 작으면 메모리에서 처리
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem); // 메모리처리 사이즈 설정

		//4. 적당히 큰 아이템이면 임시파일을 만들어서 처리(디스크)
		factory.setRepository(new File(request.getServletContext().getRealPath("tmp"))); // 서버의 실제 경로

		//5. 업로드 허용 기준에 맞는 용량의 파일이면 업로드 수행
		long maxFile = 10 * 1024 * 1024; // 10MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFile); //업로드 용량 제한 설정
		upload.setHeaderEncoding("UTF-8");

		//6. 업로드한 데이터를 파싱(추출) - 임시파일 다운로드
		List<FileItem> items = null;
		try {
			// 요청객체 request에서 전달 데이터 추출하기
			items = upload.parseRequest(request);

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//7. 폼필드 처리하기
		Iterator<FileItem> iter = items.iterator();

		while(iter.hasNext()) {
			FileItem item = iter.next();

			//빈파일(비정상파일)이 업로드 되었을 때 처리 안함
			if(item.getSize() <= 0) continue;

			if(item.isFormField()) {
				// form-data 일 경우
				// 키=값 쌍으로 전달된 데이터 일 경우

				try {

					if(item.getFieldName().equals("idx")) {
						reformdto.setIdx(Integer.parseInt(item.getString("utf-8")));
					} 
					if(item.getFieldName().equals("content")) {
						reformdto.setContent(item.getString("utf-8")); 
					}
					if(item.getFieldName().equals("title")) {
						reformdto.setTitle(item.getString("utf-8"));   
					}
					if(item.getFieldName().equals("id")) { 
						reformdto.setId(item.getString("utf-8"));  
					} 

				} catch (NumberFormatException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				/*if(item.getFieldName().equals("title")) {
					  title이면 어떻게 처리할건지, 이렇게 처리하면 된다	
					}*/
			} else {

				// java.util.UUID 고유한 값을 뽑아내는 unique한 값을 뽑아내는 클래스
				UUID uid = UUID.randomUUID();
				//					System.out.println(uid);

				String u = uid.toString().split("-")[0];

				//					System.out.println(u);

				// 필요한 추가 처리
				// 데이터베이스에 업로드한 파일의 정보를 기록해둔다
				//
				// 업로드 파일 pk
				// 원본 파일명
				// 저장 파일명(UUID가 적용된 파일명)
				// 업로드한 사람(userId)
				// 업로드한 시간(생략 가능)
				// 게시글 번호(첨부파일일 경우)

				// 파일 데이터일 경우
				File up = new File(request.getServletContext().getRealPath("upload"), item.getName()+"_"+u);
				//					System.out.println(up);
				String path = up.getParent().split("SEMI")[1]+"/"+up.getName();
				String name = up.getName();

				//					System.out.println("========================================");


				//					System.out.println(up.getParent().split("SEMI")[1]+"/"+up.getName());
				//					System.out.println("========================================");

				reformdto.setFilePath(path);

				try {
					// realPath에 지정한 파일로 기록
					item.write(up);

					item.delete(); // 임시파일 삭제하기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return reformdto;
	}

	// 추천수 높은 게시물 가져오기 
	@Override
	public ReformDto top() {
		return reformdao.top1();
	} 

}



