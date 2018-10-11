/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 758243
 */
public class DebugTag extends TagSupport {
    
    @Override
    public int doStartTag() {
        String serverName = pageContext.getRequest().getServerName();
        boolean debug = pageContext.getRequest().getParameter("debug") != null;
        int returnVal = SKIP_BODY;
        if(serverName.equals("localhost") || serverName.equals("test.cprg352.com"))
        {
            if(debug == true)
            {
                returnVal = EVAL_BODY_INCLUDE;
            }
        }
        return returnVal;
    }
    
}
