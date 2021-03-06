package com.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Cours;
import com.inti.entities.Etudiant;
import com.inti.entities.Role;
import com.inti.service.interfaces.IEtudiantService;

@RestController
@CrossOrigin
public class EtudiantController {

	@Autowired
	IEtudiantService etudiantService;

	@Autowired
	PasswordEncoder passwordEncoder;

//	@GetMapping("/etudiants")
//	public String afficherEtudiant(@RequestParam(required = false) Long id, @RequestParam(required = false) String t) {
//		if (id != null) {
//			etudiantService.findOne(id);
//			return etudiantService.findOne(id).toString();
//		} else {
//			List<Etudiant> es;
//			String msg = "";
//			if (t != null) {
//				es = etudiantService.findAllTri();
//			} else {
//				es = etudiantService.findAll();
//			}
//			for (Etudiant e : es) {
//				msg = msg + "\n" + e.toString();
//			}
//			return msg;
//		}
//	}
	
//	@GetMapping("/etudiants/classe/{idC}")
//	public String afficherEtudiantClasse(@PathVariable String idC, @RequestParam(required = false) String idE,
//			@RequestParam(required = false) String t) {
//		try {
//			if (idE != null) {
//				Etudiant e = etudiantService.afficherEtudiantClasse(idC, idE);
//				return e.toString();
//			} else {
//				String msg = "";
//				List<Etudiant> es;
//				if (t != null) {
//					es = etudiantService.afficherEtudiantsClasseTri(idC);
//
//				} else {
//					es = etudiantService.afficherEtudiantsClasse(idC);
//
//				}
//				for (Etudiant e : es) {
//					msg = msg + "\n" + e.toString();
//				}
//				return msg;
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return "Error";
//		}
//	}
	
//	@GetMapping("/etudiants/cours/{idC}")
//	public String afficherEtudiantCours(@PathVariable String idC, @RequestParam(required = false) String idE,
//			@RequestParam(required = false) String t) {
//		try {
//			if (idE != null) {
//				Etudiant e = etudiantService.afficherEtudiantCours(idC, idE);
//				return e.toString();
//			} else {
//				String msg = "";
//				List<Etudiant> es;
//				if (t != null) {
//					es = etudiantService.afficherEtudiantsCoursTri(idC);
//				} else {
//					es = etudiantService.afficherEtudiantsCours(idC);
//				}
//				for (Etudiant e : es) {
//					msg = msg + "\n" + e.toString();
//				}
//				return msg;
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return "Error";
//		}
//	}
	
//	@GetMapping("/etudiants/enseignant/{idEnseignant}")
//	public String afficherEtudiantEnseignant(@PathVariable String idEnseignant,
//			@RequestParam(required = false) String idE, @RequestParam String t) {
//		try {
//			if (idE != null) {
//				Etudiant e = etudiantService.afficherEtudiantEnseignant(idEnseignant, idE);
//				return e.toString();
//			} else {
//				String msg = "";
//				List<Etudiant> es;
//				if (t != null) {
//					es = etudiantService.afficherEtudiantsEnseignantTri(idEnseignant);
//				} else {
//					es = etudiantService.afficherEtudiantsEnseignant(idEnseignant);
//				}
//				for (Etudiant e : es) {
//					msg = msg + "\n" + e.toString();
//				}
//				return msg;
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return "Error";
//		}
//	}
	
	@GetMapping("/etudiants")
	public List<Etudiant> afficherEtudiants(@RequestParam(required = false) String t) {
		if(t != null) {
			return etudiantService.findAllTri();
		}
		else {
			return etudiantService.findAll();
		}
	}
	
	@GetMapping("/etudiants/{idE}")
	public Etudiant afficherEtudiant(@PathVariable Long idE) {
		return etudiantService.findOne(idE);
	}

	@GetMapping("/etudiants/classe/{idC}")
	public List<Etudiant> afficherEtudiantsClasse(@PathVariable String idC, @RequestParam(required = false) String t) {
		if (t != null) {
			return etudiantService.afficherEtudiantsClasseTri(idC);
		}
		else {
			return etudiantService.afficherEtudiantsClasse(idC);
		}
	}
	
	@GetMapping("/etudiants/classe/{idC}/{idE}")
	public Etudiant afficherEtudiantClasse(@PathVariable String idC, @PathVariable String idE) {
		return etudiantService.afficherEtudiantClasse(idC, idE);
	}
	
	@GetMapping("/etudiants/cours/{idC}")
	public List<Etudiant> afficherEtudiantsCours(@PathVariable String idC, @RequestParam(required = false) String t) {
		if (t != null) {
			return etudiantService.afficherEtudiantsCoursTri(idC);
		}
		else {
			return etudiantService.afficherEtudiantsCours(idC);
		}
	}
	
	@GetMapping("/etudiants/cours/{idC}/{idE}")
	public Etudiant afficherEtudiantCours(@PathVariable String idC, @PathVariable String idE) {
		return etudiantService.afficherEtudiantCours(idC, idE);
	}

	@GetMapping("/etudiants/enseignant/{idEnseignant}")
	public List<Etudiant> afficherEtudiantsEnseignant(@PathVariable String idEnseignant, @RequestParam(required = false) String t) {
		if (t!=null) {
			return etudiantService.afficherEtudiantsEnseignantTri(idEnseignant);
		}
		else {
			return etudiantService.afficherEtudiantsEnseignant(idEnseignant);
		}
	}
	
	@GetMapping("/etudiants/enseignant/{idEnseignant}/{idEtudiant}")
	public Etudiant afficherEtudiantEnseignant(@PathVariable String idEnseignant, @PathVariable String idEtudiant) {
		return etudiantService.afficherEtudiantEnseignant(idEnseignant, idEtudiant);
	}

	@DeleteMapping("/etudiants/{id}")
	public void deleteEtudiant(@PathVariable Long id) {
		etudiantService.delete(id);
	}

	@PostMapping("/etudiants")
	public Etudiant saveEtudiant(@RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) String dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double moyenne, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		System.out.println(password + nom + prenom + username + dateNaissance);
		try {
			Etudiant currentEtudiant = new Etudiant();
			currentEtudiant.setNomPersonne(nom);
			currentEtudiant.setPrenomPersonne(prenom);
			currentEtudiant.setUsername(username);
			currentEtudiant.setPassword(passwordEncoder.encode(password));
			currentEtudiant.setEmail(email);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance);
			currentEtudiant.setDateNaissancePersonne(date);
			if (photo != null) {
				currentEtudiant.setPhotoProfil(photo.getBytes());
			}
			currentEtudiant.setMoyenne(moyenne);
			currentEtudiant.setRoles(roles);
			currentEtudiant.setCourss(courss);
			return etudiantService.save(currentEtudiant);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@PutMapping("/etudiants/{id}")
	public String updateEtudiant(@PathVariable Long id, @RequestParam(required = false) String nom,
			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,
			@RequestParam(required = false) String password, @RequestParam(required = false) String email,
			@RequestParam(required = false) String dateNaissance, @RequestParam(required = false) MultipartFile photo,
			@RequestParam(required = false) Double moyenne, @RequestParam(required = false) Set<Role> roles,
			@RequestParam(required = false) Set<Cours> courss) {
		Etudiant currentEtudiant = etudiantService.findOne(id);
		try {
			currentEtudiant.setNomPersonne(nom);
			currentEtudiant.setPrenomPersonne(prenom);
			currentEtudiant.setUsername(username);
			currentEtudiant.setPassword(passwordEncoder.encode(password));
			currentEtudiant.setEmail(email);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissance);
			currentEtudiant.setDateNaissancePersonne(date);
			if (photo != null) {
				currentEtudiant.setPhotoProfil(photo.getBytes());
			}
			currentEtudiant.setMoyenne(moyenne);
			currentEtudiant.setRoles(roles);
			currentEtudiant.setCourss(courss);
			etudiantService.save(currentEtudiant);
			return "updated";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "failed";
		}
	}

}
/*
 * 
 * @GetMapping("/etudiants/cours") public List<Cours>
 * afficherCours(@RequestParam(required = false) String id) { if (id == null) {
 * return coursService.findAll(); } else { return coursService.findByCours(id);
 * } }
 * 
 * 
 * 
 * @PutMapping("/etudiants/cours/{id_cours}/evaluations/{id_evaluation}") public
 * String updateCommentaire(@RequestParam String commentaire,@PathVariable
 * String id_cours,@RequestParam String note_cours,@PathVariable String
 * id_evaluation) { try { Integer id =
 * evaluationService.updateCommentaire(commentaire, id_cours, note_cours,
 * id_evaluation); return id.toString(); }catch (Exception ex) {
 * ex.printStackTrace(); return "pas Ok"; } }
 * 
 * 
 * @PostMapping("/etudiants/cours/evaluations") // =>
 * /etudiants/cours/evaluations?commentaire=truc&?... public String
 * evaluerCours(@RequestParam(required=false) String
 * commentaire,@RequestParam(required=false) String
 * note_cours,@RequestParam(required=false) String id_cours) {
 * System.out.println(commentaire + note_cours + id_cours); try { Integer id =
 * evaluationService.evaluerCours(commentaire, note_cours, id_cours); return
 * id.toString(); } catch (Exception ex) { ex.printStackTrace(); return
 * "PAS OK"; } }
 * 
 */
