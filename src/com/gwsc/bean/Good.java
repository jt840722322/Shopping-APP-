package com.gwsc.bean;

import com.gwsc.bean.PageUtil;

public class Good extends PageUtil{
	private int id;				//
	private String name;		//	��Ʒ����
	private double oldprice;	//�ɼ۸�
	private double newprice;	//�¼۸�
	private String remark;		//��ע
	private int cid;			//����Id	
	private int num;			//��������
	private String photo;		//��ƷͼƬ
	private int hot;			//�Ƿ�����
	private String createdate;	//����ʱ��
	private String sort;		//����
	private String standard;	//���
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getOldprice() {
		return oldprice;
	}
	public void setOldprice(double oldprice) {
		this.oldprice = oldprice;
	}
	public double getNewprice() {
		return newprice;
	}
	public void setNewprice(double newprice) {
		this.newprice = newprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
}
