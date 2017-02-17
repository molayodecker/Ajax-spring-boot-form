package gh.gov.moh.admissionsportal.web.controller;

/**
 * Created by molayodecker on 27/01/2017.
 */

import gh.gov.moh.admissionsportal.model.User;
import gh.gov.moh.admissionsportal.web.Program;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginForm(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        model.addAttribute("programs", Program.values());
        try {
            Object flash = request.getSession().getAttribute("flash");
            model.addAttribute("flash", flash);

            request.getSession().removeAttribute("flash");
        } catch (Exception ex) {
            // "flash" session attribute must not exist...do nothing and proceed normally
        }
       return "login";
    }

   /* @RequestMapping(value="/cert_prog", method = RequestMethod.POST)
    public String loginRedirect(@RequestParam("cert") String name ){
        ModelAndView model = new ModelAndView("cert_prog");
       // model.addObject("msg","The link is " );
        if(name == "Certificate-program"){
            return "redirect:/cert_prog";
        }else{
            return "redirect:/yo";
        }
    }*/

    @RequestMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}

