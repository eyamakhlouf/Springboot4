package com.eya.livres.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eya.livres.entities.Genre;
import com.eya.livres.entities.Livre;
import com.eya.livres.service.LivreService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LivreController {
	@Autowired
	LivreService livreService;

	@RequestMapping("/ListeLivres")
	public String listeLivres(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
	{
		/*List<Livre> livs = livreService.getAllLivres();
		modelMap.addAttribute("Livres", livs);
		return "listeLivres";*/
		Page<Livre> livs = livreService.getAllLivresParPage(page, size);
		modelMap.addAttribute("livres", livs);
		 modelMap.addAttribute("pages", new int[livs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeLivres";

	}




	/*
	 * @RequestMapping("/showCreate") public String showCreate() { return
	 * "createLivre"; }
	 */
	
	
	/*@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("livre", new Livre());
	return "createLivre";
	}*/
	
	

	
	
	
	
	/*
	 * @RequestMapping("/saveLivre") public String
	 * saveLivre(@ModelAttribute("livre") Livre livre, @RequestParam("date") String
	 * date, ModelMap modelMap) throws ParseException { //conversion de la date
	 * SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd"); Date
	 * datePublication = dateformat.parse(String.valueOf(date));
	 * livre.setDatePublication(datePublication);
	 * 
	 * Livre saveLivre = livreService.saveLivre(livre); String msg =
	 * "Livre enregistré avec Id " + saveLivre.getIdLivre();
	 * modelMap.addAttribute("msg", msg); return "createLivre"; }
	 */

	
	/*
	 * @RequestMapping("/saveLivre") public String
	 * saveLivre(@ModelAttribute("livre") Livre livre) {
	 * livreService.saveLivre(livre); return "createLivre"; }
	 */
	/*@RequestMapping("/saveLivre")
	public String saveLivre(@Valid Livre livre, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "createLivre";

		livreService.saveLivre(livre);
		return "createLivre";
	}*/
	
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Genre> gens = livreService.getAllGenres();
	modelMap.addAttribute("livre", new Livre());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("genres", gens);
    return "formLivre";
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	/*@RequestMapping("/saveLivre")
	public String saveLivre(@Valid Livre livre,
	BindingResult bindingResult,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size",defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
	if (bindingResult.hasErrors()) return "formLivre";
	if (livre.getIdLivre()==null) //ajout
		isNew=true;
	livreService.saveLivre(livre);
	//return "formLivre";
	if (isNew) //ajout
	{
	Page<Livre> livs = livreService.getAllLivresParPage(page, size);
	currentPage = livs.getTotalPages()-1;
	}
	else //modif
	currentPage=page;
	return ("redirect:/ListeLivres?page="+currentPage+"&size="+size);
	} true*/
	/*@RequestMapping("/saveLivre")
	public String saveLivre(@Valid Livre livre,
	                        BindingResult bindingResult,
	                        @RequestParam(name = "page", defaultValue = "0") int page,
	                        @RequestParam(name = "size", defaultValue = "2") int size,
	                        ModelMap modelMap) {
	    boolean isNew = false;
	    List<Genre> genres = livreService.getAllGenres(); // Récupération de la liste des genres
	    
	    if (bindingResult.hasErrors()) {
	        // Réafficher le formulaire avec les erreurs de validation et la liste des genres
	        modelMap.addAttribute("genres", genres);
	        return "formLivre";
	    }*/
	@RequestMapping("/saveLivre")
	public String saveLivre(@Valid Livre livre, BindingResult bindingResult, 
	                        @RequestParam(name = "page", defaultValue = "0") int page,
	                        @RequestParam(name = "size", defaultValue = "2") int size,
	                        ModelMap modelMap) {
	    // Récupérer la liste des genres
		 boolean isNew = false;
		    List<Genre> genres = livreService.getAllGenres(); // Récupération de la liste des genres
		    


	    if (bindingResult.hasErrors()) {
	        // Si des erreurs de validation existent, réafficher le formulaire avec les erreurs
	        modelMap.addAttribute("genres", genres);
	        return "formLivre";
	    }
	    
	    if (livre.getIdLivre() == null) {
	        isNew = true;
	    }
	    
	    livreService.saveLivre(livre);
	    
	    int currentPage;
	    if (isNew) {
	        Page<Livre> livres = livreService.getAllLivresParPage(page, size);
	        currentPage = livres.getTotalPages() - 1;
	    } else {
	        currentPage = page;
	    }
	    
	    return "redirect:/ListeLivres?page=" + currentPage + "&size=" + size;
	}

	    
	
	
	
	
	
	
	


	
	

	
	
	@RequestMapping("/supprimerLivre")
	public String supprimerLivre(@RequestParam("id") Long id,
			ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
 {
		livreService.deleteLivreById(id);
		Page<Livre> livs = livreService.getAllLivresParPage(page,size);
				modelMap.addAttribute("livres", livs);
				modelMap.addAttribute("pages", new int[livs.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

		return "listeLivres";
	}

	@RequestMapping("/modifierLivre")
	public String editerLivre(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size) {
		Livre l = livreService.getLivre(id);
		List<Genre> gens = livreService.getAllGenres();
		
		
		modelMap.addAttribute("livre", l);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("genres", gens);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formLivre";
	}
	
	
	
	
	


	
	
	

	
	

	@RequestMapping("/updateLivre")
	public String updateLivre(@ModelAttribute("livre") Livre livre, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date datePublication = dateformat.parse(String.valueOf(date));
		livre.setDatePublication(datePublication);

		livreService.updateLivre(livre);
		List<Livre> livs = livreService.getAllLivres();
		modelMap.addAttribute("Livres", livs);
		return "listeLivres";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}

}
