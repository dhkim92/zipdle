package store.service;

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

import basket.dto.Basket;
import intspace.dto.Intspace;
import store.dao.StoreDao;
import store.dao.StoreDaoImpl;
import store.dto.Store;
import util.Paging;

public class StoreServiceImpl implements StoreService {

	private StoreDao storeDao = new StoreDaoImpl();
	private Store store = new Store();
	private Basket basket = new Basket();

	@Override
	public List<Store> getList() {
		return storeDao.selectAll();
	}

	@Override
	public int getTotal() {
		return storeDao.selectCntAll();
	}

	@Override
	public Store view(Store store) {
		return storeDao.selectItemByStoreno(store);
	}

	@Override
	public List getPagingList(Paging paging) {
		return storeDao.selectPagingList(paging);
	}

	@Override
	public int getidxcount(Store store) {
		return storeDao.selectindexCntAll(store);
	}

	@Override
	public List getPagingidxList(Paging paging) {
		return storeDao.selectPagingindexList(paging);
	}

	@Override
	public boolean insertbasket(Store store, String userid, int itemamount) {
		Store storeList = new Store();

		storeList = storeDao.selectItemByStoreno(store);

		basket.setBasketname(storeList.getItemname());
		basket.setUserid(userid);
		basket.setBasketamount(itemamount);
		basket.setBasketprice(storeList.getItemprice());
		basket.setImgpath(storeList.getImgpath());

		return storeDao.insertbasket(basket);
	}

	@Override
	public boolean Delete(String checked) {

		return storeDao.Delete(checked);
	}

	@Override
	public Store getitemdata(HttpServletRequest request, HttpServletResponse response) {
		Store dto = new Store();

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
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
		upload.setSizeMax(maxFile); // 업로드 용량 제한 설정
		upload.setHeaderEncoding("UTF-8");

		List<FileItem> items = null;
		try {
			// 요청객체 request에서 전달 데이터 추출하기
			items = upload.parseRequest(request);

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) {
			FileItem item = iter.next();

			if (item.getSize() <= 0)
				continue;

			if (item.isFormField()) {

				try {
					if (item.getFieldName().equals("itemname")) {
						dto.setItemname(item.getString("utf-8"));
					}
					if (item.getFieldName().equals("itemprice")) {
						dto.setItemprice(Integer.parseInt(item.getString("utf-8")));
					}
					if (item.getFieldName().equals("iteminfo")) {
						dto.setIteminfo(item.getString("utf-8"));
					}
					if (item.getFieldName().equals("tag")) {
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
				File up = new File(request.getServletContext().getRealPath("upload"), item.getName() + "_" + u);

				String path = up.getParent().split("SEMI")[1] + "/" + up.getName();
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
	public boolean save(Store store) {
		
		return storeDao.save(store);
	}

}
