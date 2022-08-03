/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 *
 * @author LapTop
 */
public class time_tag implements Tag{
    private PageContext pageContext;
    private Tag parent;
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    
    @Override
    public void setPageContext(PageContext pc) {
        this.pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        this.parent = t;
    }

    @Override
    public Tag getParent() {
        return this.parent;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("Creater Empty tag");          
        } catch (IOException ex) {
            Logger.getLogger(time_tag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
       return EVAL_PAGE;
    }

    @Override
    public void release() {
        System.out.println("Nam Dep Trai");
    }
    
    
}
