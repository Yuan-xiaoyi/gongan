//package com.example.gongan.util.token;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.gongan.entity.rule;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
////拦截token
//@Component
//class TokenInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
//        if(request.getMethod().equals("OPTIONS")){
//            response.setStatus(HttpServletResponse.SC_OK);
//            return true;
//        }
//        response.setCharacterEncoding("utf-8");
//        String token = request.getHeader("token"); //前端vue将token添加在请求头中
//        if(token != null){
//            Integer result = TokenUtil.verify(token);
//            if(result > 0){
//                System.out.println("通过拦截器");
//                if(result.equals(2)){ // 即将过期
//                    // 后台自动更新token，不必调用refreshToken接口
//                    String userName = TokenUtil.analysisToken(token);
//                    rule rule = new rule();
//                    rule.setName(userName);
//                    String refreshToken = TokenUtil.sign(rule); // 刷新token签名
//                    response.setHeader("refreshToken", refreshToken);
//                    response.setHeader("Access-Control-Expose-Headers", "refreshToken");
//                }
//                return true;
//            }
//        }
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        try{
//            JSONObject json = new JSONObject();
//            json.put("msg","token过期，请重新登录");
//            json.put("code","500");
//            response.getWriter().append(json.toJSONString());
//            System.out.println("认证失败，未通过拦截器");
//
//        }catch (Exception e){
//            e.printStackTrace();
//            response.sendError(500);
//            return false;
//        }
//        return false;
//    }
//
//}
