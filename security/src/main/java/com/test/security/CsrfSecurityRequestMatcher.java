package com.test.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;

/**
 * csrf防攻击策略 需要在页面添加
 * <meta name="_csrf" th:content="${_csrf.token}"/> 
 * <meta name="_csrf_header" th:content="${_csrf.headerName}"/>
 * 和public.js中设置ajax请求header
 * $(function () {
	//只允许有效的操作
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
  });
 * @author mhs123
 *
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher {
	protected Log log = LogFactory.getLog(getClass());
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	@Override
	public boolean matches(HttpServletRequest request) {

		if (execludeUrls != null && execludeUrls.size() > 0) {
			String servletPath = request.getServletPath();
			for (String url : execludeUrls) {
				if (servletPath.contains(url)) {
					log.info("++++" + servletPath);
					return false;
				}
			}
		}
		return !allowedMethods.matcher(request.getMethod()).matches();
	}

	/**
	 * 需要排除的url列表
	 */
	private List<String> execludeUrls;

	public List<String> getExecludeUrls() {
		return execludeUrls;
	}

	public void setExecludeUrls(List<String> execludeUrls) {
		this.execludeUrls = execludeUrls;
	}
}