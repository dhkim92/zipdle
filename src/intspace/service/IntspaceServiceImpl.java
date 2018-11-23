package intspace.service;

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

import intspace.dao.IntspaceDao;
import intspace.dao.IntspaceDaoImpl;
import intspace.dto.Intspace;
import util.Paging;

public class IntspaceServiceImpl implements IntspaceService {

	private Intspace intspace = new Intspace();
	private IntspaceDao intdao = new IntspaceDaoImpl();

	@Override
	public List<Intspace> getList() {

		return intdao.SelectAll();
	}

	@Override
	public int getTotal() {

		return intdao.selectCntAll();
	}

	@Override
	public List getPagingList(Paging paging) {

		return intdao.selectPagingList(paging);
	}

	@Override
	public int getidxcount(Intspace intspace) {
		// TODO Auto-generated method stub
		return intdao.selectindexCntAll(intspace);
	}

	@Override
	public List getPagingidxList(Paging paging) {

		return intdao.selectPagingindexList(paging);
	}

	@Override
	public Intspace view(Intspace intspace) {
		return intdao.selectTableByintspaceno(intspace);
	}

	@Override
	public boolean save(Intspace intspace) {

		return intdao.save(intspace);
	}

	@Override
	public List top3() {

		return intdao.top3();
	}

	@Override
	public boolean viewControll(int view, int intspaceno) {

		return intdao.viewCount(view, intspaceno);
	}

	@Override
	public int gradecheck(String userid) {
		return intdao.gradecheck(userid);
	}

	@Override
	public boolean delete(int intspaceno) {
		return intdao.delete(intspaceno);
	}

	@Override
	public boolean updatesave(Intspace intspace) {
		
		return intdao.updatesave(intspace);
	}

	@Override
	public Intspace getintspacedata(HttpServletRequest request, HttpServletResponse response ) {
		Intspace dto = new Intspace();
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(!isMultipart) {
			System.out.println("multipart type 아님");
			return null;
		}
		
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem); // 메모리처리 사이즈 설정
		
		factory.setRepository(new File(request.getServletContext().getRealPath("tmp"))); // 서버의 실제 경로
		
		long maxFile = 10 * 1024 * 1024; // 10MB
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFile); //업로드 용량 제한 설정
		upload.setHeaderEncoding("UTF-8");
		
		List<FileItem> items = null;
		try {
			// 요청객체 request에서 전달 데이터 추출하기
			items = upload.parseRequest(request);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		Iterator<FileItem> iter = items.iterator();
		
		while(iter.hasNext()) {
			FileItem item = iter.next();
			
			if(item.getSize() <= 0) continue;
			
			if(item.isFormField()) {
				
				try {
					if(item.getFieldName().equals("intspaceno")) {
						dto.setIntspaceno(Integer.parseInt(item.getString("utf-8")) );
					}
					if(item.getFieldName().equals("title")) {
						dto.setTitle(item.getString("utf-8"));
					}
					if(item.getFieldName().equals("content")) {
						dto.setContent(item.getString("utf-8"));
					}
					if(item.getFieldName().equals("tag")) {
						dto.setHashtag(item.getString("utf-8"));
					}
										
				} catch (NumberFormatException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	} else {
				
				
				UUID uid = UUID.randomUUID();

				String u = uid.toString().split("-")[0];

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

				String path = up.getParent().split("SEMI")[1]+"/"+up.getName();
				String name = up.getName();

				
				dto.setImgpath(path);

				try {
					 // realPath에 지정한 파일로 기록
					item.write(up);
					
					item.delete(); // 임시파일 삭제하기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return dto;
	}

	@Override
	public Intspace top1() {
		return intdao.top();
	}
	}


