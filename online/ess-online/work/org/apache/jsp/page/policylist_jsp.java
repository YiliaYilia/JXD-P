/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.52
 * Generated at: 2015-06-30 11:05:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class policylist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/tlds/fn.tld", Long.valueOf(1428680703375L));
    _jspx_dependants.put("/WEB-INF/tlds/dict.tld", Long.valueOf(1428680702781L));
    _jspx_dependants.put("/common/page/common.jsp", Long.valueOf(1433495584628L));
    _jspx_dependants.put("/WEB-INF/tlds/fmt.tld", Long.valueOf(1428680703343L));
    _jspx_dependants.put("/WEB-INF/tlds/c.tld", Long.valueOf(1428680702750L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/css/niceValidate/jquery.validator.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/validate/jquery.validate.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/validate/additional-methods.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/common/js/validate/messages_zh.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>保单列表</title>\r\n");
      out.write("\t\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../global/css/common.css\" type=\"text/css\"></link>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../global/css/all.css\" type=\"text/css\"></link>\r\n");
      out.write("    <!-- 引入 -->\r\n");
      out.write("\t<link href=\"../global/css/common/main.min.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${random}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" rel=\"stylesheet\"/>\r\n");
      out.write("\t<link href=\"../global/css/page/page.min.css?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${random}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" rel=\"stylesheet\"/>\r\n");
      out.write("\t<link href=\"../global/css/animate/animate.css\" rel=\"stylesheet\"/>\r\n");
      out.write("\t<link href=\"../global/css/animate/loader-ani.css\" rel=\"stylesheet\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"../global/lib/jquery/jquery-2.1.3.min.js\"></script>\r\n");
      out.write("\t<script src=\"../global/lib/common/main.js?");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${random}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"../global/lib/component/modal.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"../global/lib/jquery/jquery.event.move.js\"></script>\r\n");
      out.write("\t<script src=\"../global/lib/jquery/jquery.mobile.touch.js\"></script>\r\n");
      out.write("\t<script src=\"../global/lib/jquery/jquery.event.swipe.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 引入 end-->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../global/js/jquery/1.9.0/jquery.min.js\"></script>\r\n");
      out.write("  \t<script type=\"text/javascript\" src=\"../global/js/common.js\"></script>\r\n");
      out.write("  \t<!-- init page scale-->\r\n");
      out.write("  \t<script>\r\n");
      out.write("\t\tvar phoneWidth =  parseInt(window.screen.width);\r\n");
      out.write("\t\tvar phoneScale = phoneWidth/640;\r\n");
      out.write("\t\tvar ua = navigator.userAgent;\r\n");
      out.write("\t\tif (/Android (\\d+\\.\\d+)/.test(ua)){\r\n");
      out.write("\t\t\tvar version = parseFloat(RegExp.$1);\r\n");
      out.write("\t\t\tif(version>2.3){\r\n");
      out.write("\t\t\t\tdocument.write('<meta name=\"viewport\" content=\"width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi\">');\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tdocument.write('<meta name=\"viewport\" content=\"width=640, target-densitydpi=device-dpi\">');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tdocument.write('<meta name=\"viewport\" content=\"width=640, user-scalable=no, target-densitydpi=device-dpi\">');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("  \t<meta name=\"format-detection\" content=\"telephone=no\"/>\r\n");
      out.write("  </head>\r\n");
      out.write("  <style>\r\n");
      out.write("\t\t.txt1{font-size: 1.3em;}\r\n");
      out.write("\t.txt2{font-size: 1.0em;}\r\n");
      out.write("\t.txt3{font-size: 0.9em;}\r\n");
      out.write("\t.txt4{font-size: 0.8em;}\r\n");
      out.write("\t.txt5{font-size: 0.7em;}\r\n");
      out.write("\t\t@media only screen and (max-width: 960px) {\r\n");
      out.write("\t\t.txt1{font-size: 1.2em;}\r\n");
      out.write("\t\t.txt2{font-size: 0.9em;}\r\n");
      out.write("\t\t.txt3{font-size: 0.7em;}\r\n");
      out.write("\t\t.txt4{font-size: 0.7em;}\r\n");
      out.write("\t\t.txt5{font-size: 0.6em;}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@media only screen and (max-width: 640px) {\r\n");
      out.write("\t\t.txt1{font-size:1.1em;}\r\n");
      out.write("\t\t.txt2{font-size: 0.8em;}\r\n");
      out.write("\t\t.txt3{font-size: 0.6em;}\r\n");
      out.write("\t\t.txt4{font-size: 0.6em;}\r\n");
      out.write("\t\t.txt5{font-size: 0.5em;}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@media only screen and (max-width: 480px) {\r\n");
      out.write("\t\t.title1{font-size: 1.0em;}\r\n");
      out.write("\t\t.txt2{font-size: 0.7em;}\r\n");
      out.write("\t\t.txt3{font-size: 0.5em;}\r\n");
      out.write("\t\t.txt4{font-size: 0.5em;}\r\n");
      out.write("\t\t.txt5{font-size: 0.4em;}\r\n");
      out.write("\t}\r\n");
      out.write("  </style>\r\n");
      out.write("  <body>\r\n");
      out.write("  \t<div class=\"header\">\r\n");
      out.write("    \t<div>\r\n");
      out.write("\t    \t<div class=\"headertitle\">保单列表</div>\r\n");
      out.write("\t    \t<div class=\"clear\"></div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"clear\"></div>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("   \t\t<div class=\"content\" id=\"personpolicylist\">\r\n");
      out.write("   \t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /page/policylist.jsp(92,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("policy");
      // /page/policylist.jsp(92,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${policyList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      // /page/policylist.jsp(92,5) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("this_status");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("   \t\t\t<div class=\"signdiv\">\r\n");
            out.write("    \t\t\t<div class=\"signimg\" onclick=\"javascript:window.location.href='");
            out.print(path );
            out.write("/action/getPolicyBasic?policyNo=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${policy.policyNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("'\">\r\n");
            out.write("    \t\t\t\t<img src=\"../global/images/redbook.png\"/>\r\n");
            out.write("    \t\t\t</div>\r\n");
            out.write("    \t\t</div>\r\n");
            out.write("    \t\t<div class=\"signdiv1\">\r\n");
            out.write("    \t\t<div class=\"signarrow\"></div>\r\n");
            out.write("    \t\t</div>\r\n");
            out.write("   \t\t\t<div class=\"hidetable\">\r\n");
            out.write("   \t\t\t\t<div class=\"width80p firstdiv\">\r\n");
            out.write("   \t\t\t\t\t<div class=\"black\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${policy.productName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</div>\r\n");
            out.write("   \t\t\t\t\t<div>保单号：");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${policy.policyNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</div>\r\n");
            out.write("   \t\t\t\t\t<div>生效日期：");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${policy.inceptionDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("</div>\r\n");
            out.write("   \t\t\t\t</div>\r\n");
            out.write("   \t\t\t\t<div class=\"width20p seconddivshow cursor\">\r\n");
            out.write("   \t\t\t\t\t<div class=\"showbtn\"></div>\r\n");
            out.write("   \t\t\t\t</div>\r\n");
            out.write("   \t\t\t\t<div class=\"width20p seconddivhide cursor\" onclick=\"javascript:window.location.href='");
            out.print(path );
            out.write("/action/getPolicyBasic?policyNo=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${policy.policyNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
            out.write("'\">\t\r\n");
            out.write("   \t\t\t\t\t<div class=\"hidebtn\">\r\n");
            out.write("   \t\t\t\t\t\t<span class=\"hidespan1\"></span>\r\n");
            out.write("   \t\t\t\t\t\t<span class=\"hidespan2\"></span>\r\n");
            out.write("   \t\t\t\t\t</div>\r\n");
            out.write("   \t\t\t\t</div>\r\n");
            out.write("   \t\t\t\t<div class=\"width20p forthdiv cursor\">\r\n");
            out.write("   \t\t\t\t\t<img src=\"../global/images/detailinfo.png\" class=\"width36\"/>\r\n");
            out.write("   \t\t\t\t\t<div>详细信息</div>\r\n");
            out.write("   \t\t\t\t</div>\r\n");
            out.write("   \t\t\t</div>\r\n");
            out.write("   \t\t\t");
            if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return;
            out.write("\r\n");
            out.write("   \t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      }
      out.write("\r\n");
      out.write("   \t\t\t<div class=\"lastlinkline\"></div>\r\n");
      out.write("    \t\t <div class=\"clear\"></div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"clear\"></div>\r\n");
      out.write("<!-- 框体 -->\r\n");
      out.write("\t<div class=\"modal fade\" data-rule=\"alert\" id=\"modal_alert\">\r\n");
      out.write("\t\t<div class=\"modal-dialog alert\">\r\n");
      out.write("\t\t\t<div class=\"modal-header clearfix\"><span data-title=\"modal\">提示信息</span><a type=\"button\" class=\"close\" data-dismiss=\"modal\"></a></div>\r\n");
      out.write("\t\t\t<div class=\"modal-content\" data-content=\"modal\"></div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<a class=\"modal-btn btn\" data-dismiss=\"modal\" data-btn=\"modal\">确定</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<!-- \t\t加载等待框 -->\r\n");
      out.write("\t<div class=\"modal fade\" data-rule=\"loading\" id=\"modal_loading\">\r\n");
      out.write("\t\t<div class=\"modal-dialog loading\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\" data-content=\"modal\">\r\n");
      out.write("\t\t\t\t<p class=\"loader8\">加载中......</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </body>\r\n");
      out.write(" \r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  var conwidth =  parseInt($(\".container\").width());\r\n");
      out.write("  //\t$(\".header\").width(conwidth);\r\n");
      out.write("\t//alert($(\".container\").width());alert($(\".header\").width());\r\n");
      out.write("\t\r\n");
      out.write("  ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write(" \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /common/page/common.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /common/page/common.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /page/policylist.jsp(121,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${this_status.last==false}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    \t\t\t<div class=\"hidelinkline\"></div> \r\n");
        out.write("    \t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /page/policylist.jsp(158,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contenct!=null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t$(document).ready(function(){\r\n");
        out.write("\t\t\tmodal_alert({content:'");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contenct}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("',btn:'确定'});\r\n");
        out.write("\t});\t\r\n");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}