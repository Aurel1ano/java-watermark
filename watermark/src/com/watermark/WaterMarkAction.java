package com.watermark;
import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class WaterMarkAction extends ActionSupport {
	private File image;
	private String imageFileName;
	private String uploadPath;
	private PicInfo picInfo = new PicInfo();
	
	
	
	
	public PicInfo getPicInfo() {
		return picInfo;
	}
	public void setPicInfo(PicInfo picInfo) {
		this.picInfo = picInfo;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	
	 public String watermark() throws Exception{
		 String realUploadPath = ServletActionContext.getServletContext().getRealPath(uploadPath);
		 UploadService uploadService = new UploadService();
		picInfo.setImageURL( uploadService.uploadImage(image, imageFileName, uploadPath, realUploadPath));
		 return SUCCESS;
	 }

}
