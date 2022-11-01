/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@ son anotaciones de spring
@Controller //indicamos que esta clase es un controlador
@RequestMapping("/ver.htm")//para llamarlo de afuera

//Los metodos del controlador siempre retornaban un String
public class verController {
    //@RequestMapping(method = RequestMethod.POST)

}
