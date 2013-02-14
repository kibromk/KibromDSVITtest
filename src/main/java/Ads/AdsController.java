package Ads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdsController {

    @Autowired
    private AdsDAO adsDAO;
    @RequestMapping(value="/adspage")
    public ModelAndView ProjectAds(HttpServletRequest request) {
        // Handle a new content (if any):
        String content = request.getParameter("name");
        if (content != null)
        {
            adsDAO.persist(new AdsEntity(content));
        }
        return new ModelAndView("adspage.jsp", "adsDAO", adsDAO);
    }
}