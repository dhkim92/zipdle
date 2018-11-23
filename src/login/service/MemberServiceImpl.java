package login.service;

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

import login.dao.MemberDao;
import login.dao.MemberDaoImpl;
import login.dto.UserDto;
import util.Paging;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = new MemberDaoImpl();
	
	
	// 회원가입
	@Override
	public boolean join(UserDto user) {
		
		return memberDao.insert(user);
	}

	
	// 로그인
	@Override
	public boolean login(UserDto user) {
		
		int cnt = memberDao.doLogin(user);
		
		if(cnt>0) {
			return true;
		} else {
			return false;			
		}
	}

	// ID찾기
	@Override
	public String idGet(UserDto user) {
		
		return memberDao.idSearch(user);
	}

	
	// PW수정
	@Override
	public void pwSet(UserDto user) {
		
		memberDao.pwSearch(user);
	}

	// ID 찾기 판별
	@Override
	public boolean checkId(UserDto user) {
		
		return memberDao.idCheck(user);
	}

	// PW 찾기 판별
	@Override
	public boolean checkPw(UserDto user) {
		
		return memberDao.pwCheck(user);
	}

	// 회원가입 판별 - ID중복 검사
	@Override
	public boolean checkJoin(UserDto user) {
		
		return memberDao.overlap(user);
	}

	/**
	 * user데이터 전부 가져오기
	 * @return List
	 */
	@Override
	public List userList() {
		return memberDao.selectAll();
	}

	// 페이징 별로 잘라서 유저 리스트 가져오기
	@Override
	public List userPagingList(Paging paging) {
		return memberDao.selectPagingUser(paging);
		}
	
	// 유저 리스트 카운트
	@Override
	public int userListCnt() {
		
		return memberDao.selectAllCnt();
	}

	
	/**
	 * 아이디로 user데이터 가져오기
	 * @param user
	 * @return UserDto
	 */
	@Override
	public UserDto userList(UserDto user) {
		
		return memberDao.selectUser(user);
	}

	// 회원가입 - PW 일치 판별
	@Override
	public boolean joinPw(String pw, String repw) {
		
		if (pw.equals(repw)==true) {
			
			return true;
		}else {
		
			return false;
		}
	}

	// 유저 프로필 이미지 멀티파트 경로 가져오기
	@Override
	public UserDto getProfilePath(HttpServletRequest request, HttpServletResponse response) {
		
		UserDto ie = new UserDto();
		// 파일 업로드 작업 시작 !!!!!
		
				// 1. 파입 업로드한 거 맞는지 확인하는 부분
				// enctype 이 multipart 인지 확인하는 메소드
				boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
				
				
				//1-1. multipart/form-data가 아닐 경우
				if(!isMultipart) {
					System.out.println("multipart type 아님");
					return null; // 메소드 종료
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
								
								
								if(item.getFieldName().equals("imgPath")) {
									ie.setProfileImg(item.getString("utf-8"));
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
//						System.out.println(uid);
						
						String u = uid.toString().split("-")[0];
						
//						System.out.println(u);
						
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
//						System.out.println(up);
						String path = up.getParent().split("SEMI")[1]+"/"+up.getName();
						String name = up.getName();
						
//						System.out.println("========================================");
						
						
//						System.out.println(up.getParent().split("SEMI")[1]+"/"+up.getName());
//						System.out.println("========================================");
						
						ie.setProfileImg(path);
						

						try {
							 // realPath에 지정한 파일로 기록
							item.write(up);
							
							item.delete(); // 임시파일 삭제하기
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
				return ie;
	}

	// 프로필 이미지 등록 (마이 페이지)
	@Override
	public void setImgPath(UserDto user) {
		memberDao.setImg(user);
		
	}

	// 프로필 이미지 경로 가져오기
	@Override
	public String getImgPath(UserDto user) {
		
		return memberDao.getImg(user);

	}


	//회원 등급 업 수정
	@Override
	public boolean upGrade(String ids) {
		
		 int grade=2;
		
		 System.out.println("등급 업 서비스");
		 
		return memberDao.setGrade(ids,grade);
	}


	@Override
	public boolean downGrade(String ids) {
		int grade=1;
		
		System.out.println("등급 다운 서비스");
		
		return memberDao.setGrade(ids,grade);
	}

	


	

}
