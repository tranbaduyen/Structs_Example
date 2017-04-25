package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Khoa;
import model.bean.SinhVien;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;

/**
 * SinhVienForm.java
 *
 * Version 1.0
 *
 * Date: Jan 21, 2015
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Jan 21, 2015        	DaiLV2          Create
 */

public class SinhVienForm extends ActionForm{
	private String msv;
	private String hoTen;
	private String gioiTinh;
	private String maKhoa;
	private String tenKhoa;
	private String action;
	private ArrayList<Khoa> listKhoa;
	private String submit;
	private SinhVien sinhVien;
	private String hinhDaiDien;
	
	private FormFile file;
	
	public SinhVien getSinhVien() {
		return sinhVien;
	}
	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public ArrayList<Khoa> getListKhoa() {
		return listKhoa;
	}
	public void setListKhoa(ArrayList<Khoa> listKhoa) {
		this.listKhoa = listKhoa;
	}
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	
	public String getHinhDaiDien() {
		return hinhDaiDien;
	}
	public void setHinhDaiDien(String hinhDaiDien) {
		this.hinhDaiDien = hinhDaiDien;
	}
	
	public FormFile getFile() {
		return file;
	}
	public void setFile(FormFile file) {
		this.file = file;
	}
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
//	@Override
//	public ActionErrors validate(ActionMapping mapping,
//			HttpServletRequest request) {
//		 ActionErrors errors = new ActionErrors();
//	        if(file.getFileSize() == 0){
//	        	errors.add("uploadedFile", new ActionMessage("errors.file.notselected"));
//	        	System.out.println("loi upfile abc");
//	        }
//	               
//	        if(errors.isEmpty()){
//	            if(!file.getContentType().equalsIgnoreCase("image/jpeg") && !file.getContentType().equalsIgnoreCase("image/jpg")
//	            && !file.getContentType().equalsIgnoreCase("image/pjpeg")){
//	            	 errors.add("uploadedFile", new ActionMessage("errors.file.type", file.getFileName(),file.getContentType()));
//		            	System.out.println("loi images abc"+file.getFileName()+" "+file.getContentType());
//	            }
//	               
//	            if(file.getFileSize() > 500000){
//	            	  errors.add("uploadedFile", new ActionMessage("errors.file.size",file.getFileName(),file.getFileSize()));
//	            	  System.out.println("loi images size "+file.getFileName()+" "+file.getFileSize());
//	            }
//	              
//	        }
//	        return errors;
//	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

