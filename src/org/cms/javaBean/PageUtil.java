package org.cms.javaBean;

import java.util.List;

/**
 * ��ҳ�����ࣨ��װÿҳ��Ҫ��ʾ�����ݣ�
 * 
 * @author ���Գ���
 * 
 */
public class PageUtil {
    // ��ǰҳҳ��(1,2,3....)
    private int pageNo;

    // ÿҳ��ʾ����
    private int pageSize;

    // �ܼ�¼(����)
    private int totalCount;

    // ��ǰҳ���ݼ���
    private List data;

    // ��ҳ��
    private int totalPage;

    /**
     * ���췽��������ÿҳ�������ܼ�¼��
     * 
     * @param ÿҳ��ʾ����
     * @param �ܼ�¼��
     */
    public PageUtil(int pageSize, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        if (this.totalCount % this.pageSize == 0) {
            // ������ҳ��
            this.totalPage = this.totalCount / this.pageSize;
        } else {
            this.totalPage = this.totalCount / this.pageSize + 1;
        }
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

}
