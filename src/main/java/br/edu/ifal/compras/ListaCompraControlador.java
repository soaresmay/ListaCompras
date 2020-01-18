package br.edu.ifal.compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaCompraControlador{
    @Autowired
    private ItemRepositorio repo;
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/listacompra")
public ModelAndView listaCompras(){
    ModelAndView mv = new ModelAndView("listaCompras");
    mv.addObject("itens",repo.findAll());
    return mv;
}
    @RequestMapping("/listacompras/cadastro")
    public ModelAndView cadastro(Item item){
        ModelAndView mv = new ModelAndView("redirect:/listacompra");
        repo.save(item);
        return mv;
    }
    @RequestMapping("/listacompras/excluir/{id}")
    public ModelAndView excluir(@PathVariable(name = "id") long id){
        ModelAndView mv = new ModelAndView("redirect:/listacompra");
        repo.deleteById(id);
        return mv;
    }
}