package Sbchalet.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.CommentPost;
import Sbchalet.demo.models.Facture;
import Sbchalet.demo.repository.FactureRepository;

@Service
public class FactureServiceImpl implements IFactureService {

	@Autowired
	private FactureRepository factureRepository;

	private static final Logger logger = Logger.getLogger(FactureServiceImpl.class);

	@Override
	public List<Facture> list() {
		try {
			logger.info(" Je suis dans ListFacture ");
			logger.debug("Je vais retourner ListFacture");
			logger.info("Je vien de finir l'operation ");
			return (List<Facture>) this.factureRepository.findAll();
		} catch (Exception e) {
			logger.error("Error in ListChalet() :", e);
		}
		return new ArrayList<Facture>();

	}

	@Override
	public Facture save(Facture f) {
		try {
			logger.trace("accès à la méthode");
			logger.info("je vais enregister Facture");
			return this.factureRepository.save(f);

		} catch (Exception e) {
			logger.error("Error dans save() :", e);
		}
		return new Facture();
	}

	@Override
	public void removeFacture(int id_facture) {
		try {
			logger.info("supprimer chalet= " + id_facture);
			factureRepository.deleteById(id_facture);

		} catch (Exception e) {
			logger.error("Error dans removeFacture() :", e);
		}
		logger.info("Facture n'existe pas");
	}

	@Override
	public Facture updateFacture(int id_facture, Facture facture) {
		try {
			logger.info("je suis dans updateFacture()");
			Facture updateFacture = null;
			Optional<Facture> factures = this.factureRepository.findById(id_facture);
			if (factures.isPresent()) {
				Facture upfacture = factures.get();
				upfacture = facture;
				logger.debug("je vais lancer updateFacture ,");
				updateFacture = this.factureRepository.save(upfacture);
			}
			logger.info("j'ai terminé mon instruction ");
			return updateFacture;

		} catch (Exception e) {
			logger.error("Error dans updateFacture :", e);

		}
		return new Facture();
	}

	@Override
	public Optional<Facture> getById(int id_facture) {
		try {
			logger.info("je vais afficher le Facture par id =" + id_facture);
			return this.factureRepository.findById(id_facture);

		} catch (Exception e) {
			logger.error("Error dans getById() :", e);
		}

		return null;
	}

}
