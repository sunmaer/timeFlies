/*
* @Author: �Գ���
* @Date:   2016-10-26 14:35:23
* @Last Modified by:   SMH
* @Last Modified time: 2016-10-27 17:05:24
*/
package org.cms.filter;     
    
import java.io.IOException;     
    
import javax.servlet.Filter;     
import javax.servlet.FilterChain;     
import javax.servlet.FilterConfig;     
import javax.servlet.ServletException;     
import javax.servlet.ServletRequest;     
import javax.servlet.ServletResponse;     
import javax.servlet.http.HttpServletRequest;     
import javax.servlet.http.HttpServletResponse;     
import javax.servlet.http.HttpSession;     
/**   
 * �û�����Ȩ�޵Ĺ�����   
 * @author loginFilter   
 */    
public class loginFilter implements Filter {     
    
    public void destroy() {     
        // TODO Auto-generated method stub     
             
    }     
    
    public void doFilter(ServletRequest request, ServletResponse response,     
            FilterChain chain) throws IOException, ServletException {
        // ����������ַ�����     
        request.setCharacterEncoding("UTF-8");     
        // ���÷���������ַ�����     
        response.setCharacterEncoding("UTF-8");     
        // ת��ServletRequestΪ HttpServletRequest     
        HttpServletRequest req = (HttpServletRequest) request;     
        // ת��ServletResponseΪHttpServletRequest     
        HttpServletResponse res = (HttpServletResponse) response;     
        // ��ȡSession     
        HttpSession session = req.getSession();     
        // ��ȡSession�д洢�Ķ���     
        Object o = session.getAttribute("userName"); 
//        System.out.println(req.getRequestURI());
        // ��ȡ��ǰ�����URI     
        String url = req.getRequestURI();     
        // �ж�Session�еĶ����Ƿ�Ϊ�գ��ж������URI�Ƿ�Ϊ��������˵�URI 
        if (o == null 
        	&& url.contains(".jsp")
            && !url.endsWith("/Admin/login.jsp"))// ��URL��ַΪ�˽�β���ļ�������      
        {
            System.out.println("��ʼ����"+url);
            res.sendRedirect(req.getContextPath() + "/Admin/login.jsp");     
        } else {     
            chain.doFilter(request, response);     
            res.setHeader("Cache-Control","no-store");           
            res.setDateHeader("Expires",0);        
            res.setHeader("Pragma","no-cache");      
            res.flushBuffer();     
        }     
             
    }     
    
    public void init(FilterConfig filterConfig) throws ServletException {     
        // TODO Auto-generated method stub     
             
    }     
    
}    