/*
* @Author: �Գ���
* @Date:   2016-10-26 14:39:06
* @Last Modified by:   SMH
* @Last Modified time: 2016-10-27 17:05:27
*/
package org.cms.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//���������������servlet����������
public class characterMyFilter implements Filter{
    //��дһ��request����ԭ����request,��д�����getParemeter�������������ñ���
    class MyRequest extends HttpServletRequestWrapper{
        
        @Override
        public String getParameter(String param) {
            String value = null;
            try {
                //post
                super.setCharacterEncoding(encoding);//�ѱ���ת��Ϊencoding
                value = super.getParameter(param);
                if(super.getMethod().equalsIgnoreCase("GET")){
                    if(value!=null){
                        value = new String(value.getBytes("iso8859-1"),encoding);
                    }
                }
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return value;
        }

        public MyRequest(HttpServletRequest request) {
            super(request);
        }
        
    }
    protected String encoding=null; 
    public void destroy() { //����
        // TODO Auto-generated method stub
        this.encoding=null;
    }
   //�Ա����������ת��
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset="+encoding);
        //����δ��¼�û�
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path=req.getServletPath();
        String param=req.getQueryString();
        if(path!=null){
            path=path+"?"+param;//ȫ����·��
        }
        if(path.endsWith("myAddress")||path.endsWith("myJingDong")||path.indexOf("myShouCang")!=-1||path.endsWith("updateUser")||path.indexOf("showOrder")!=-1||path.indexOf("showValidOrder")!=-1||path.indexOf("showCancelOrder")!=-1||path.indexOf("fillOrder")!=-1){
            HttpSession session = req.getSession();
            String userName = (String) session.getAttribute("username");
            if(userName == null){
                session.setAttribute("url", path.replaceFirst("/", ""));
                System.out.println(session.getAttribute("url"));
                resp.sendRedirect("user.do?op=loginAction");
                return;
            }
        }
        //�ѹ���������һ������������Դ������
        chain.doFilter(new MyRequest((HttpServletRequest) request), response); 
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.encoding=filterConfig.getInitParameter("encoding");//encoding��web.xml��ָ��
    }

}

