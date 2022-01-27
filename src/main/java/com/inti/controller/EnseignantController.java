package com.inti.controller;



import java.util.Date;

import java.util.List;

import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;



import com.inti.entities.Correction;

import com.inti.entities.Cours;

import com.inti.entities.Enseignant;

import com.inti.entities.Etudiant;

import com.inti.entities.Evaluation;

import com.inti.entities.Examen;

import com.inti.entities.Role;

import com.inti.service.interfaces.ICorrectionService;

import com.inti.service.interfaces.ICoursService;

import com.inti.service.interfaces.IEnseignantService;

import com.inti.service.interfaces.IEtudiantService;

import com.inti.service.interfaces.IEvaluationService;

import com.inti.service.interfaces.IExamenService;



@RestController

@CrossOrigin

public class EnseignantController {



	@Autowired

	IEnseignantService enseignantService;



	@Autowired

	PasswordEncoder passwordEncoder;

	

	

//	@GetMapping("/enseignants")

//	public String afficherEnseignant(@RequestParam(required = false) Long id, @RequestParam(required = false) String t,

//			@RequestParam(required = false) String idR) {

//		if (id != null) {

//			enseignantService.findOne(id);

//			return enseignantService.findOne(id).toString();

//		} else {

//			List<Enseignant> es;

//			String msg = "";

//			if (t != null) {

//				es = enseignantService.findAllTri();

//			} else if (idR != null) {

//				es = enseignantService.afficherEnseignantsAdmin(idR);

//			} else {

//				es = enseignantService.findAll();

//			}

//			for (Enseignant e : es) {

//				msg = msg + "\n" + e.toString();

//			}

//			return msg;

//		}

//	}

//	@GetMapping("/enseignants/cours/{idC}")

//	public String afficherEnseignantCours(@PathVariable String idC, @RequestParam(required = false) String idE,

//			@RequestParam(required = false) String idR) {

//		try {

//			if (idE != null) {

//				Enseignant e = enseignantService.afficherEnseignantCours(idC, idE);

//				return e.toString();

//			} else {

//				String msg = "";

//				List<Enseignant> es;

//				if (idR != null) {

//					es = enseignantService.afficherEnseignantsAdminCours(idC, idR);

//

//				} else {

//					es = enseignantService.afficherEnseignantsCours(idC);

//

//				}

//				for (Enseignant e : es) {

//					msg = msg + "\n" + e.toString();

//				}

//				return msg;

//			}

//		} catch (Exception ex) {

//			ex.printStackTrace();

//			return "Error";

//		}

//	}

//	

//	@GetMapping("/enseignants/etudiant/{idEtudiant}")

//	public String afficherEnseignantEtudiant(@PathVariable String idEtudiant, @RequestParam(required = false) String idEnseignant,

//			@RequestParam(required = false) String idR) {

//		try {

//			if (idEnseignant != null) {

//				System.out.println(idEnseignant);

//				Enseignant e = enseignantService.afficherEnseignantEtudiant(idEtudiant, idEnseignant);

//				return e.toString();

//			} else {

//				String msg = "";

//				List<Enseignant> es;

//				if (idR != null) {

//					es = enseignantService.afficherEnseignantsAdminEtudiant(idEtudiant, idR);

//

//				} else {

//					es = enseignantService.afficherEnseignantsEtudiant(idEtudiant);

//

//				}

//				for (Enseignant e : es) {

//					msg = msg + "\n" + e.toString();

//				}

//				return msg;

//			}

//		} catch (Exception ex) {

//			ex.printStackTrace();

//			return "Error";

//		}

//	}

	

	@GetMapping("/enseignants")

	public List<Enseignant> afficherEnseignants(@RequestParam(required = false) String a) {

		if (a != null) {

			// default admin role is 1

			return enseignantService.afficherEnseignantsAdmin("1");

		}

		else {

			return enseignantService.findAll();

		}

	}

	

	@GetMapping("/enseignants/{idE}")

	public Enseignant afficherEnseignant(@PathVariable Long idE,@RequestParam(required = false) String a) {

		if (a != null) {

			return enseignantService.afficherEnseignantAdmin("1", idE.toString());

		}

		return enseignantService.findOne(idE);

	}



	@GetMapping("/enseignants/classe/{idC}")

	public List<Enseignant> afficherEnseignantsClasse(@PathVariable String idC, @RequestParam(required = false) String a) {

		if (a != null ) {

			return enseignantService.afficherEnseignantsAdminClasse(idC, "1");

		}

		else {

			return enseignantService.afficherEnseignantsClasse(idC);

		}

	}

	

	@GetMapping("/enseignants/classe/{idC}/{idE}")

	public Enseignant afficherEnseignantClasse(@PathVariable String idC, @PathVariable String idE, @RequestParam(required = false) String a) {

		if (a != null ) {

			return enseignantService.afficherEnseignantAdminClasse(idC, "1", idE);

		}

		else {

			return enseignantService.afficherEnseignantClasse(idC, idE);

		}

	}

	

	@GetMapping("/enseignants/cours/{idC}")

	public List<Enseignant> afficherEnseignantsCours(@PathVariable String idC, @RequestParam(required = false) String a) {

		if ( a != null) {

			return enseignantService.afficherEnseignantsAdminCours(idC, "1");

		}

		else {

			return enseignantService.afficherEnseignantsCours(idC);

		}

	}

	

	@GetMapping("/enseignants/cours/{idC}/{idE}")

	public Enseignant afficherEnseignantCours(@PathVariable String idC, @PathVariable String idE, @RequestParam(required = false) String a) {

		if (a != null) {

			return enseignantService.afficherEnseignantAdminCours(idC, "1", idE);

		}

		else {

			return enseignantService.afficherEnseignantCours(idC, idE);

		}

	}



	@GetMapping("/enseignants/etudiant/{idEtudiant}")

	public List<Enseignant> afficherEnseignantsEtudiant(@PathVariable String idEtudiant, @RequestParam(required = false) String a) {

		if (a != null) {

			return enseignantService.afficherEnseignantsAdminEtudiant(idEtudiant, "1");

		}

		else {

			return enseignantService.afficherEnseignantsEtudiant(idEtudiant);

		}

	}

	

	@GetMapping("/enseignants/etudiant/{idEtudiant}/{idEnseignant}")

	public Enseignant afficherEnseignantEtudiant(@PathVariable String idEtudiant, @PathVariable String idEnseignant, @RequestParam(required = false) String a) {

		if ( a != null) {

			return enseignantService.afficherEnseignantAdminEtudiant(idEtudiant, "1", idEnseignant);

		}

		else {

			return enseignantService.afficherEnseignantEtudiant(idEtudiant, idEnseignant);

		}

	}

	

	@PostMapping("/enseignants")

	public Enseignant saveEnseignant(@RequestParam(required = false) String nom,

			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,

			@RequestParam(required = false) String password, @RequestParam(required = false) String email,

			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,

			@RequestParam(required = false) Double salaire, @RequestParam(required = false) Set<Role> roles,

			@RequestParam(required = false) Set<Cours> courss) {

		try {

			Enseignant currentEnseignant = new Enseignant();

			currentEnseignant.setNomPersonne(nom);

			currentEnseignant.setPrenomPersonne(prenom);

			currentEnseignant.setUsername(username);

			currentEnseignant.setPassword(passwordEncoder.encode(password));

			currentEnseignant.setEmail(email);

			currentEnseignant.setDateNaissancePersonne(dateNaissance);

			if (photo != null) {

				currentEnseignant.setPhotoProfil(photo.getBytes());

			}

			currentEnseignant.setSalaire(salaire);

			currentEnseignant.setRoles(roles);

			currentEnseignant.setCourss(courss);

			return enseignantService.save(currentEnseignant);

		} catch (Exception ex) {

			ex.printStackTrace();

			return null;

		}

	}



	@PutMapping("/enseignants/{id}")

	public String updateEnseignant(@PathVariable Long id, @RequestParam(required = false) String nom,

			@RequestParam(required = false) String prenom, @RequestParam(required = false) String username,

			@RequestParam(required = false) String password, @RequestParam(required = false) String email,

			@RequestParam(required = false) Date dateNaissance, @RequestParam(required = false) MultipartFile photo,

			@RequestParam(required = false) Double salaire, @RequestParam(required = false) Set<Role> roles,

			@RequestParam(required = false) Set<Cours> courss) {

		Enseignant currentEnseignant = enseignantService.findOne(id);

		try {

			currentEnseignant.setNomPersonne(nom);

			currentEnseignant.setPrenomPersonne(prenom);

			currentEnseignant.setUsername(username);

			currentEnseignant.setPassword(passwordEncoder.encode(password));

			currentEnseignant.setEmail(email);

			currentEnseignant.setDateNaissancePersonne(dateNaissance);

			if (photo != null) {

				currentEnseignant.setPhotoProfil(photo.getBytes());

			}

			currentEnseignant.setSalaire(salaire);

			currentEnseignant.setRoles(roles);

			currentEnseignant.setCourss(courss);

			enseignantService.save(currentEnseignant);

			return "updated";

		} catch (Exception ex) {

			ex.printStackTrace();

			return "failed";

		}

	}

	

	@DeleteMapping("/enseignants/{id}")

	public void deleteEnseignant(@PathVariable Long id) {

		enseignantService.delete(id);

	}



}

	

	//

//	@GetMapping("/enseignants/examens/fichierReponses")

//	public List<Examen> listReponsesEleves(@RequestParam String id) {

//		return examenService.listReponsesEleves(id);

//	}

//

//	@GetMapping("/enseignants/examens/fichierExamens")

//	List<Examen> listExamen(@RequestParam String id) {

//		return examenService.listExamen(id);

//	}

//

//	@GetMapping("/enseignants/corrections/notes")

//	public List<Correction> listnotesEleves(String idCorrection) {

//		return correctionService.listnotesEleves(idCorrection);

//	}

//

//	@DeleteMapping("/enseignants/{id}")

//	public void deleteEnseignant(@PathVariable Long id) {

//		enseignantService.delete(id);

//	}

	/*

	 * @PostMapping("/enseignants/cours") public Cours insererCours(@RequestParam

	 * String idCours,@RequestParam String idPersonne, @RequestParam(required =

	 * false) MultipartFile fichierCours) { try { return

	 * coursService.insererCours(idCours, idPersonne, fichierCours);

	 * 

	 * } catch (Exception ex) { ex.printStackTrace(); return null; } }

	 */



//	@PutMapping("/enseignants/cours")

//	public Cours updaterCours(@RequestParam String idCours,@RequestParam String idPersonne, @RequestParam(required = false) MultipartFile fichierCours) {

//		Cours currentCours= coursService.findOne(Long.parseLong(idCours));

//		try {

//			currentCours.setFichierCours(fichierCours.getBytes());

//			return coursService.updaterCours(idCours, idPersonne, fichierCours.getBytes().toString());

//		} catch (Exception ex) {

//			ex.printStackTrace();

//			return null;

//		}

//	}



	/* 

	 * @PostMapping("/enseignants/examens") public Examen -> "/examens/enseignants/{idEnseignant}

	 * insererExamen(@RequestParam String idExam, @RequestParam String

	 * idPersonne, @RequestParam(required=false) MultipartFile fichierExamen) { try

	 * { Examen currentExamen = new Examen();

	 * currentExamen.setFichierExamen(fichierExamen.getBytes());

	 * 

	 * return examenService.insererExamen(idExam, idPersonne);

	 * 

	 * } catch (Exception ex) { ex.printStackTrace(); return null; }

	 * 

	 * }

	 */



//	@PutMapping("/enseignants/examens")

//	public Examen updaterExamen(@RequestParam String idExam, @RequestParam String idPersonne, @RequestParam(required =false) MultipartFile fichierExamen) {

//		Examen currentExamen= examenService.findOne(Long.parseLong(idExam));

//		try {

//			currentExamen.setFichierExamen(fichierExamen.getBytes());

//			return examenService.insererExamen(idExam, idPersonne);

//		} catch (Exception ex) {

//			ex.printStackTrace();

//			return null;

//		}

//	

//	}





//	@GetMapping("/enseignants/cours/commentaires")

//	public List<Evaluation> listCommentaires(@RequestParam String idCours) {

//		return evaluationService.listCommentaires(idCours);

//	}



