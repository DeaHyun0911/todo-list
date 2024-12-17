package sparta.todo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;
import sparta.todo.SessionConst;

import java.io.IOException;


@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] WHITE_LIST = {"/" ,"/api/auth/*"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        log.info("로그인 필터 로직 실행");

        if(!isWhiteList(requestURI)) {
            log.info("인증 체크 로직 실행 {}", requestURI);
            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
                log.info("미인증 사용자 요청{}", requestURI);
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
