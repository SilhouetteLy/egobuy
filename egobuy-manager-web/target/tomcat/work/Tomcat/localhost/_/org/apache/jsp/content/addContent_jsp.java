/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-15 07:29:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.content;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addContent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/kindeditor-4.1.10/themes/default/default.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/kindeditor-4.1.10/kindeditor-all-min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/kindeditor-4.1.10/lang/zh_CN.js\"></script>\n");
      out.write("<div style=\"padding:10px 10px 10px 10px\">\n");
      out.write("    <form id=\"contentAddForm\" class=\"itemForm\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"categoryId\"/>\n");
      out.write("        <table cellpadding=\"5\">\n");
      out.write("            <tr>\n");
      out.write("                <td>内容标题:</td>\n");
      out.write("                <td><input class=\"easyui-textbox\" type=\"text\" name=\"title\" data-options=\"required:true\" style=\"width: 280px;\"></input></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>内容子标题:</td>\n");
      out.write("                <td><input class=\"easyui-textbox\" type=\"text\" name=\"subTitle\" style=\"width: 280px;\"></input></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>内容描述:</td>\n");
      out.write("                <td><input class=\"easyui-textbox\" name=\"titleDesc\" data-options=\"multiline:true,validType:'length[0,150]'\" style=\"height:60px;width: 280px;\"></input>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>URL:</td>\n");
      out.write("                <td><input class=\"easyui-textbox\" type=\"text\" name=\"url\" style=\"width: 280px;\"></input></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>图片:</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"hidden\" name=\"pic\" />\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton onePicUpload\">图片上传</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>图片2:</td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"hidden\" name=\"pic2\" />\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton onePicUpload\">图片上传</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>内容:</td>\n");
      out.write("                <td>\n");
      out.write("                    <textarea style=\"width:800px;height:300px;visibility:hidden;\" name=\"content\"></textarea>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </form>\n");
      out.write("    <div style=\"padding:5px\">\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"contentAddPage.submitForm()\">提交</a>\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"contentAddPage.clearForm()\">重置</a>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    var contentAddEditor ;\n");
      out.write("    $(function(){\n");
      out.write("        contentAddEditor = E3.createEditor(\"#contentAddForm [name=content]\");\n");
      out.write("        E3.initOnePicUpload();\n");
      out.write("        $(\"#contentAddForm [name=categoryId]\").val($(\"#contentCategoryTree\").tree(\"getSelected\").id);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    var contentAddPage  = {\n");
      out.write("        submitForm : function (){\n");
      out.write("            if(!$('#contentAddForm').form('validate')){\n");
      out.write("                $.messager.alert('提示','表单还未填写完成!');\n");
      out.write("                return ;\n");
      out.write("            }\n");
      out.write("            contentAddEditor.sync();\n");
      out.write("\n");
      out.write("            $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/content/save\",$(\"#contentAddForm\").serialize(), function(data){\n");
      out.write("                if(data.status == 200){\n");
      out.write("                    $.messager.alert('提示','新增内容成功!');\n");
      out.write("                    $(\"#contentList\").datagrid(\"reload\");\n");
      out.write("                    E3.closeCurrentWindow();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        },\n");
      out.write("        clearForm : function(){\n");
      out.write("            $('#contentAddForm').form('reset');\n");
      out.write("            contentAddEditor.html('');\n");
      out.write("        }\n");
      out.write("    };\n");
      out.write("</script>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
